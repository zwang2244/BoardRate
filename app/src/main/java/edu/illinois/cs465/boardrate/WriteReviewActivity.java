package edu.illinois.cs465.boardrate;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteReviewActivity extends AppCompatActivity {

    private List<Game> allGames = new ArrayList<Game>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_review);
        MyApplication myApplication = (MyApplication) getApplication();
        allGames = myApplication.getAllGames();


        RatingBar ratingBar = findViewById(R.id.ratingBar);
        TextInputEditText text = findViewById(R.id.textInputBox);
        Button b = findViewById(R.id.button);

        String gameTitle = getIntent().getStringExtra("gameTitle");
        TextView whatDoYouThink = findViewById(R.id.whatDoYouThink);
        whatDoYouThink.setText("What do you think about " + gameTitle + "?");

        int gameId = 0;
        for (Game g : allGames) {
            if (g.getName().equals(gameTitle)){
                gameId = g.getGameID();
                break;
            }
        }
        int finalGameId = gameId;
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(v, "Submission Confirmed!", Snackbar.LENGTH_LONG);
                snackbar.show();

                float numStars = ratingBar.getRating();
                String comment = text.getText().toString().trim();
//                    FileWriter writer = new FileWriter("mock_db_games_my_reviews.csv");
//                    writer.append("\n" + finalGameId + ", " + numStars + ", 0, " + comment);
                    MyReviews mr = new MyReviews();
                    Review r = new Review();
                    for (Game g : allGames) {
                        if (g.getName().equals(gameTitle)) {
                            mr.setGameID(finalGameId);
                            mr.setImageURL(g.getImageURL());
                            mr.setRating(g.getRating());
                            mr.setName(g.getName());
                            mr.setTag1(g.getTag1());
                            mr.setTag2(g.getTag2());
                            mr.setTag3(g.getTag3());
                            mr.setTimetoPlay(g.getTimetoPlay());
                            mr.setSaved(g.isIfSaved());

                            r.setComment(comment);
                            r.setLikes(0);
                            r.setUsername("TrialUser");
                            r.setGameId(finalGameId);
                            r.setRating(numStars);

                        }
                    }
                    mr.setReview(comment);
                    mr.setReview_Rating(Float.toString(numStars));
                    MyApplication.addMyReview(mr);
                    MyApplication.addReview(r);

                    finishActivity(1);
//                Handler handler = new Handler();
//                handler.postDelayed(new Runnable() {
//                    public void run() {
//                        // Actions to do after 1.5 seconds
//                        startActivity(new Intent(WriteReviewActivity.this, MainActivity.class)); //send back to main page
//                    }
//                }, 1500);
            }
        });


    }
}
