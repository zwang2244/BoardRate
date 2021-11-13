package edu.illinois.cs465.boardrate;

import android.os.Bundle;
import android.util.Log;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        readGamePageData(); // Read data from raw/mock_db_games_game_page.csv
        myApplication.setAllGames(allGames);
        //List<Game> Games = myApplication.getAllGames(); // the games can be get in all activities
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
                allGames.add(game);
                Log.d("Main Activity", "Just created " + game);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}