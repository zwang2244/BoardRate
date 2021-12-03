package edu.illinois.cs465.boardrate.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.BaseAdapter;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import edu.illinois.cs465.boardrate.Review;
import edu.illinois.cs465.boardrate.GameDetailsActivity;
import edu.illinois.cs465.boardrate.R;

public class AdapterForGameDetails extends BaseAdapter {
    List<Review> allReviews;
    private List<Review> reviewList = null;
    private int gameID;
    Context context;
    LayoutInflater inflater;

    public AdapterForGameDetails(List<Review> allReviews, int gameID, Context context) {
        this.allReviews = allReviews;

        this.context = context;
        this.gameID = gameID;
        this.reviewList = new ArrayList<>();
        for (Review r : allReviews){
            if (r.getGameId() == gameID){
                reviewList.add(r);
            }
        }
        inflater = LayoutInflater.from(context);
    }

    @NonNull

    public AdapterForGameDetails.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_review, parent, false);
        AdapterForGameDetails.MyViewHolder holder = new AdapterForGameDetails.MyViewHolder();
        view.setTag(holder);
        return holder;
    }


//    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
////        holder.game_pic.
//        Glide.with(context).load(this.reviewList.get(position).getImageURL()).into(holder.game_pic);
//        holder.game_title.setText(this.reviewList.get(position).getName());
//        holder.game_rating.setRating(Float.parseFloat(this.reviewList.get(position).getRating()));
//        holder.game_tag1.setText(this.reviewList.get(position).getTag1());
//        holder.game_tag2.setText(this.reviewList.get(position).getTag2());
//        holder.game_tag3.setText(this.reviewList.get(position).getTag3());
//        holder.game_duration.setText(this.reviewList.get(position).getTimetoPlay());
//    }

    public View getView(final int position, View view, ViewGroup parent) {
        final AdapterForGameDetails.MyViewHolder holder;
        if (view == null) {
            holder = new AdapterForGameDetails.MyViewHolder();
            view = inflater.inflate(R.layout.game_review, null);
            view.setTag(holder);
            holder.setattr(view);
        } else {
            holder = (AdapterForGameDetails.MyViewHolder) view.getTag();
        }
        holder.username_and_comment.setText(this.reviewList.get(position).getUsername() + ": " +
                this.reviewList.get(position).getComment());
        holder.game_rating.setRating(this.reviewList.get(position).getRating());
//        holder.likes.setText(this.reviewList.get(position).getLikes());
        holder.numstars.setText(Float.toString(this.reviewList.get(position).getRating()));
        return view;
    }

    @Override
    public int getCount() {
        return reviewList.size();
    }


    @Override
    public Review getItem(int position) {
        return reviewList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class MyViewHolder{
        RatingBar game_rating;
        TextView likes;
        TextView username_and_comment;
        TextView numstars;

//        public MyViewHolder(@NonNull View itemView) {
//            game_pic = itemView.findViewById(R.id.game_pic);
//            game_title = itemView.findViewById(R.id.gameTitle);
//            game_rating = itemView.findViewById(R.id.game_rate);
//            game_tag1 = itemView.findViewById(R.id.tag1);
//            game_tag2 = itemView.findViewById(R.id.tag2);
//            game_tag3 = itemView.findViewById(R.id.tag3);
//            game_duration = itemView.findViewById(R.id.duration);
//
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intent = new Intent(view.getContext(), GameDetailsActivity.class);
//                    view.getContext().startActivity(intent);
//                }
//            });
//        }

        public MyViewHolder(){}

        public void setattr(@NonNull View itemView){
            game_rating = itemView.findViewById(R.id.game_review_rating_bar);
            username_and_comment = itemView.findViewById(R.id.game_review_user_and_review);
            numstars = itemView.findViewById(R.id.game_review_num_stars);
            likes = itemView.findViewById(R.id.game_review_likes);
        }
    }


}
