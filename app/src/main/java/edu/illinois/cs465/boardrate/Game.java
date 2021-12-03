package edu.illinois.cs465.boardrate;

/**
 * Game type/class stores info
 * */
public class Game {
    private int gameID;
    private String Name;
    private String Rating;
    private int NumberofReviewrs;
    private String ImageURL;
    private String TimetoPlay;
    private int Ranking1;
    private int Rankings2;
    private String NumberofPlayers;
//    private String Description;
    private String Tag1;
    private String Tag2;
    private String Tag3;
    private int Tag1Ranking;
    private int Tag2Ranking;
    private int Tag3Ranking;
    private boolean ifSaved = false;

    public boolean isIfSaved() {
        return ifSaved;
    }

    public void setIfSaved(boolean ifSaved) {
        this.ifSaved = ifSaved;
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

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

    public int getRanking1() {
        return Ranking1;
    }

    public void setRanking1(int ranking1) {
        Ranking1 = ranking1;
    }

    public int getRankings2() {
        return Rankings2;
    }

    public void setRankings2(int rankings2) {
        Rankings2 = rankings2;
    }

    public String getNumberofPlayers() {
        return NumberofPlayers;
    }

    public void setNumberofPlayers(String numberofPlayers) {
        NumberofPlayers = numberofPlayers;
    }

//    public String getDescription() {
//        return Description;
//    }
//
//    public void setDescription(String description) {
//        Description = description;
//    }

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

    public int getTag1Ranking() {
        return Tag1Ranking;
    }

    public void setTag1Ranking(int tag1Ranking) {
        Tag1Ranking = tag1Ranking;
    }

    public int getTag2Ranking() {
        return Tag2Ranking;
    }

    public void setTag2Ranking(int tag2Ranking) {
        Tag2Ranking = tag2Ranking;
    }

    public int getTag3Ranking() {
        return Tag3Ranking;
    }

    public void setTag3Ranking(int tag3Ranking) {
        Tag3Ranking = tag3Ranking;
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameID=" + gameID +
                ", Name='" + Name + '\'' +
                ", Rating='" + Rating + '\'' +
                ", NumberofReviewrs=" + NumberofReviewrs +
                ", ImageURL='" + ImageURL + '\'' +
                ", TimetoPlay='" + TimetoPlay + '\'' +
                ", Ranking1=" + Ranking1 +
                ", Rankings2=" + Rankings2 +
                ", NumberofPlayers='" + NumberofPlayers + '\'' +
//                ", Description='" + Description + '\'' +
                ", Tag1='" + Tag1 + '\'' +
                ", Tag2='" + Tag2 + '\'' +
                ", Tag3='" + Tag3 + '\'' +
                ", Tag1Ranking=" + Tag1Ranking +
                ", Tag2Ranking=" + Tag2Ranking +
                ", Tag3Ranking=" + Tag3Ranking +
                '}';
    }
}
