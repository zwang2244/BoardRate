package edu.illinois.cs465.boardrate;

import android.app.Application;
import android.content.Context;
import android.graphics.Color;
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
    private static List<Game> savedGames= new ArrayList<Game>();
    private static List<MyReviews> myReviews= new ArrayList<MyReviews>();
    private static List<Review> allReviews = new ArrayList<>();
    public static int red_save = Color.argb(255, 253, 62, 62);
    public static int red_unsave = Color.argb(255, 253, 200, 200);

    public MyApplication() {
    }

    public static List<Game> getSavedGames() {
        return savedGames;
    }
    public static void setSavedGames(List<Game> savedGames) {
        MyApplication.savedGames = savedGames;
    }

    public static List<Game> getAllGames() {
        return allGames;
    }

    public static void setAllGames(List<Game> allGames) {
        MyApplication.allGames = allGames;
    }

    public static void addReview(Review r) {
        MyApplication.allReviews.add(r);
    }

    public static List<Review> getAllReviews() {
        return allReviews;
    }

    public static void setAllReviews(List<Review> allReviews) {
        MyApplication.allReviews = allReviews;
    }

    public static void setMyReviews(List<MyReviews> myReviews) {
        MyApplication.myReviews = myReviews;
    }

    public static void addMyReview(MyReviews mr) {
        MyApplication.myReviews.add(mr);
    }

    public static List<MyReviews> getMyReviews() {
        return myReviews;
    }
}
