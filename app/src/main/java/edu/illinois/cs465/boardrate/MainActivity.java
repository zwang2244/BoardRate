package edu.illinois.cs465.boardrate;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import edu.illinois.cs465.boardrate.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    MyApplication myApplication = (MyApplication) this.getApplication();
    private List<Game> allGames = new ArrayList<Game>();
    private List<Game> allSavedGames = new ArrayList<Game>();
    private List<Review> allReviews = new ArrayList<>();


    public List<Game> getAllGames() {return allGames;}
    public List<Review> getAllReviews() {return allReviews;}
    private List<MyReviews> myReviews = new ArrayList<MyReviews>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_notifications, R.id.navigation_my_reviews, R.id.navigation_my_saved_games)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        readMyReviews();
        readGamePageData(); // Read data from raw/mock_db_games_game_page.csv
        readSavedGamePageData();
        myApplication.setAllGames(allGames);
        myApplication.setMyReviews(myReviews);
        myApplication.setSavedGames(allSavedGames);
        Log.d("saved Games", allSavedGames.toString());

        //List<Game> Games = myApplication.getAllGames(); // the games can be get in all activities

        readGameReviewData();

    }



    private void readGamePageData(){
        InputStream is = getResources().openRawResource(R.raw.mock_db_games_game_page);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );
        String line = "";
        try {
            reader.readLine(); // skip the first row
            while ((line = reader.readLine()) != null) {
                //split the line by ','
                String[] tokens = line.split(",");
                //read data
                Game game = new Game();
                int gameID = Integer.parseInt(tokens[0]);
                game.setGameID(Integer.parseInt(tokens[0]));
                game.setName(tokens[1]);
                game.setRating(tokens[2]);
                game.setNumberofReviewrs(Integer.parseInt(tokens[3]));
                game.setImageURL(tokens[4]);
                game.setTimetoPlay(tokens[5]);
                game.setRanking1(Integer.parseInt(tokens[6]));
                game.setRankings2(Integer.parseInt(tokens[7]));
                game.setNumberofPlayers(tokens[8]);
                game.setTag1(tokens[9]);
                game.setTag2(tokens[10]);
                game.setTag3(tokens[11]);
                game.setTag1Ranking(Integer.parseInt(tokens[12]));
                game.setTag2Ranking(Integer.parseInt(tokens[13]));
                game.setTag3Ranking(Integer.parseInt(tokens[14]));
                for(int i = 0; i < myReviews.size(); i++){
                    MyReviews myReview = myReviews.get(i);
                    if(myReview.getGameID() == gameID){
                        myReview.setName(tokens[1]);
                        myReview.setRating(tokens[2]);
                        myReview.setNumberofPlayers(Integer.parseInt(tokens[3]));
                        myReview.setImageURL(tokens[4]);
                        myReview.setTimetoPlay(tokens[5]);
                        myReview.setTag1(tokens[9]);
                        myReview.setTag2(tokens[10]);
                        myReview.setTag3(tokens[11]);
//                        Log.d("Main Activity", "Just created " + myReview);
                    }
                }

                allGames.add(game);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void readMyReviews(){
        InputStream is = getResources().openRawResource(R.raw.mock_db_games_my_reviews);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );
        String line = "";
        try {
            reader.readLine(); // skip the first row
            while ((line = reader.readLine()) != null) {
                //split the line by ','
                String[] tokens = line.split(",");
                //read data
                MyReviews myReview = new MyReviews();
                myReview.setGameID(Integer.parseInt(tokens[0]));
                myReview.setReview_Rating(tokens[1]);
                myReview.setLikes(Integer.parseInt(tokens[2]));
                myReview.setReview(tokens[3]);
                myReviews.add(myReview);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readGameReviewData(){
        InputStream is = getResources().openRawResource(R.raw.mock_db_games_reviews);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );
        String line = "";
        try {
            reader.readLine(); // skip the first row
            while ((line = reader.readLine()) != null) {
                //split the line by ','
                String[] tokens = line.split(",");
                //read data
                Review review = new Review();
                review.setGameId(Integer.parseInt(tokens[0]));
                review.setUsername(tokens[1]);
                review.setRating(Float.parseFloat(tokens[2]));
                review.setLikes(Integer.parseInt(tokens[3]));
                review.setComment(tokens[4]);

                allReviews.add(review);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void readSavedGamePageData(){
        InputStream is = getResources().openRawResource(R.raw.mock_db_games_saved_game);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );
        String line = "";
        try {
            reader.readLine(); // skip the first row
            while ((line = reader.readLine()) != null) {
                //split the line by ','
                String[] tokens = line.split(",");
                //read data
                Game game = new Game();
                int gameID = Integer.parseInt(tokens[0]);
                game.setGameID(Integer.parseInt(tokens[0]));
                game.setName(tokens[1]);
                game.setRating(tokens[2]);
                game.setNumberofReviewrs(Integer.parseInt(tokens[3]));
                game.setImageURL(tokens[4]);
                game.setTimetoPlay(tokens[5]);
                game.setRanking1(Integer.parseInt(tokens[6]));
                game.setRankings2(Integer.parseInt(tokens[7]));
                game.setNumberofPlayers(tokens[8]);
                game.setTag1(tokens[9]);
                game.setTag2(tokens[10]);
                game.setTag3(tokens[11]);
                game.setTag1Ranking(Integer.parseInt(tokens[12]));
                game.setTag2Ranking(Integer.parseInt(tokens[13]));
                game.setTag3Ranking(Integer.parseInt(tokens[14]));

                allSavedGames.add(game);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}