package edu.illinois.cs465.boardrate.ui;

public class Review {
    private int gameId;
    private String username;
    private int rating;
    private int likes;
    private String comment;

    public Review(int gameId, String username, int rating, int likes, String comment) {
        this.gameId = gameId;
        this.username = username;
        this.rating = rating;
        this.likes = likes;
        this.comment = comment;
    }

    public Review(int gameId, int rating, int likes, String comment) {
        this.gameId = gameId;
        this.username = "n/a";
        this.rating = rating;
        this.likes = likes;
        this.comment = comment;
    }


    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
