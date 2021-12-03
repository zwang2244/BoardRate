package edu.illinois.cs465.boardrate;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * This class includes global variables that are accessible for all activities
 */
public class MyApplication extends Application {
    private static List<Game> allGames= new ArrayList<Game>();
    private static List<MyReviews> myReviews= new ArrayList<MyReviews>();
    public MyApplication() {
    }


    public static List<Game> getAllGames() {
        return allGames;
    }

    public static void setAllGames(List<Game> allGames) {
        MyApplication.allGames = allGames;
    }

    public static void setMyReviews(List<MyReviews> myReviews) {
        MyApplication.myReviews = myReviews;
    }

    public static List<MyReviews> getMyReviews() {
        return myReviews;
    }
}
