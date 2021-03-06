package edu.illinois.cs465.boardrate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import edu.illinois.cs465.boardrate.ui.home.AdapterForGameDetails;

public class GameDetailsActivity extends AppCompatActivity {
    private ListView list;
    private AdapterForGameDetails mAdapter;
    private List<Game> allGames = new ArrayList<Game>();
    private List<Review> allReviews = new ArrayList<>();
    private String gameTitle;
    List<Game> savedGames;

    @Override
    public void onResume(){
        super.onResume();
        mAdapter.update();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_details);
        Bundle extras = getIntent().getExtras();
        String gameTitle = "";
        if (extras != null) {
            gameTitle = extras.getString("gameTitle");
            //The key argument here must match that used in the other activity
        }

        MyApplication myApplication = (MyApplication) getApplication();
        allGames = myApplication.getAllGames();
        allReviews = myApplication.getAllReviews();
        savedGames = MyApplication.getSavedGames();
//        readGameReviewData();
        list = (ListView) findViewById(R.id.game_details_listview);
//        TextView description = (TextView) findViewById(R.id.game_details_description);
        ImageView game_pic = findViewById(R.id.game_pic);
        TextView game_title = findViewById(R.id.gameTitle);
        RatingBar game_rating = findViewById(R.id.game_rate);
        TextView game_tag1 = findViewById(R.id.tag1);
        TextView game_tag2 = findViewById(R.id.tag2);
        TextView game_tag3 = findViewById(R.id.tag3);
        TextView game_duration = findViewById(R.id.duration);
        ImageButton game_save_btn = findViewById(R.id.btn_save);
        int gameID = 0;
        for (Game g : allGames){
            if (g.getName().equals(gameTitle)){
                gameID = g.getGameID();
                Glide.with(this).load(g.getImageURL()).into(game_pic);
                game_rating.setRating(Float.parseFloat(g.getRating()));
                game_title.setText(g.getName());
                game_tag1.setText(g.getTag1());
                game_tag2.setText(g.getTag2());
                game_tag3.setText(g.getTag3());
                game_duration.setText(g.getTimetoPlay());

                if(g.isIfSaved()){ //&& holder.game_save_btn != null){
                    game_save_btn.setColorFilter(MyApplication.red_save);
                }else{
                    game_save_btn.setColorFilter(MyApplication.red_unsave);
                }
                break;
            }
        }
        mAdapter = new AdapterForGameDetails(allReviews, gameID, this);
        list.setAdapter(mAdapter);

        Button b = findViewById(R.id.button_review);
        String finalGameTitle = gameTitle;
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameDetailsActivity.this, WriteReviewActivity.class);
                intent.putExtra("gameTitle", finalGameTitle);
                startActivity(intent);
            }
        });

        ImageButton save= findViewById(R.id.btn_save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                    Toast.makeText(v.getContext(),"click", Toast.LENGTH_LONG).show();
                System.out.println("click");
                String t = game_title.getText().toString();
                boolean saved = false;
                for (int i = 0; i < allGames.size(); i++) {
                    if (allGames.get(i).getName().equals(t)) {
                        saved = allGames.get(i).isIfSaved();
                        if (!saved) {
                            allGames.get(i).setIfSaved(true);
                            savedGames.add(allGames.get(i));
                            saved = true;
                        } else {
                            allGames.get(i).setIfSaved(false);
                            savedGames.remove(allGames.get(i));
                            saved = false;
                        }

                        break;
                    }
                }
                System.out.println(save.getColorFilter());
                System.out.println(Color.argb(255, 251, 116, 114));
                System.out.println(R.color.red_save);
                if (saved) {
                    save.setColorFilter(MyApplication.red_save);
                } else {
                    save.setColorFilter(MyApplication.red_unsave);
                }

//                    MyApplication myApplication = (MyApplication) v.getContext().get;
//                    allGames = myApplication.getAllGames();

            }
        });
    }

}