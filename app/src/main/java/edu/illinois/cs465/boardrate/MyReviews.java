package edu.illinois.cs465.boardrate;

public class MyReviews {
    private int gameID;
    private String Name;
    private String Rating;
    private int NumberofReviewrs;
    private String ImageURL;
    private String TimetoPlay;
    private int NumberofPlayers;
    private String Tag1;
    private String Tag2;
    private String Tag3;

    private String review;
    private int likes;
    private String review_Rating;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRating() {
        return Rating;
    }

    public void setRating(String rating) {
        Rating = rating;
    }

    public int getNumberofReviewrs() {
        return NumberofReviewrs;
    }

    public void setNumberofReviewrs(int numberofReviewrs) {
        NumberofReviewrs = numberofReviewrs;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String imageURL) {
        ImageURL = imageURL;
    }

    public String getTimetoPlay() {
        return TimetoPlay;
    }

    public void setTimetoPlay(String timetoPlay) {
        TimetoPlay = timetoPlay;
    }

    public int getNumberofPlayers() {
        return NumberofPlayers;
    }

    public void setNumberofPlayers(int numberofPlayers) {
        NumberofPlayers = numberofPlayers;
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getReview_Rating() {
        return review_Rating;
    }

    public void setReview_Rating(String review_Rating) {
        this.review_Rating = review_Rating;
    }

    public String getTag1() {
        return Tag1;
    }

    public void setTag1(String tag1) {
        Tag1 = tag1;
    }

    public String getTag2() {
        return Tag2;
    }

    public void setTag2(String tag2) {
        Tag2 = tag2;
    }

    public String getTag3() {
        return Tag3;
    }

    public void setTag3(String tag3) {
        Tag3 = tag3;
    }

    @Override
    public String toString() {
        return "My reviews {" +
                "gameID=" + gameID +
                ", Name='" + Name + '\'' +
                ", Rating='" + Rating + '\'' +
                ", ImageURL='" + ImageURL + '\'' +
                ", TimetoPlay='" + TimetoPlay + '\'' +
                ", NumberofPlayers='" + NumberofPlayers + '\'' +
                ", Tag1='" + Tag1 + '\'' +
                ", Tag2='" + Tag2 + '\'' +
                ", Tag3='" + Tag3 + '\'' +
                ", review='" + review + '\'' +
                ", likes='" + likes + '\'' +
                ", review_Rating='" + review_Rating + '\'' +
                '}';
    }

}
