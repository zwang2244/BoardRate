package edu.illinois.cs465.boardrate.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import edu.illinois.cs465.boardrate.Game;
import edu.illinois.cs465.boardrate.MyReviews;
import edu.illinois.cs465.boardrate.R;

public class AdapterForMyReview extends RecyclerView.Adapter<AdapterForMyReview.MyViewHolder>{
    List<MyReviews> myReviewsList;
    Context context;
    public AdapterForMyReview(List<MyReviews> myReviewsList, Context context) {
        this.myReviewsList = myReviewsList;
        this.context = context;
    }


    @NonNull
    @Override
    public AdapterForMyReview.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_review_card, parent, false);
        AdapterForMyReview.MyViewHolder holder = new AdapterForMyReview.MyViewHolder(view);
        return holder;
    }


   @Override
   public void onBindViewHolder(@NonNull AdapterForMyReview.MyViewHolder holder, int position) {
//        holder.game_pic.
       Glide.with(context).load(this.myReviewsList.get(position).getImageURL()).into(holder.game_pic);
       holder.game_title.setText(this.myReviewsList.get(position).getName());
       holder.game_rank.setText(String.valueOf(position + 1));
       holder.game_rating.setRating(Float.parseFloat(this.myReviewsList.get(position).getRating()));
       holder.game_tag1.setText(this.myReviewsList.get(position).getTag1());
       holder.game_tag2.setText(this.myReviewsList.get(position).getTag2());
       holder.game_tag3.setText(this.myReviewsList.get(position).getTag3());
       holder.game_duration.setText(this.myReviewsList.get(position).getTimetoPlay());
       holder.review_rating.setRating(Float.parseFloat(this.myReviewsList.get(position).getReview_Rating()));
       holder.review.setText(this.myReviewsList.get(position).getReview());
   }

    @Override
    public int getItemCount() {
        return myReviewsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView game_pic;
        TextView  game_title;
        TextView game_rank;
        RatingBar game_rating;
        TextView game_tag1;
        TextView game_tag2;
        TextView game_tag3;
        TextView game_duration;
        RatingBar review_rating;
        TextView review;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            game_pic = itemView.findViewById(R.id.game_pic);
            game_title = itemView.findViewById(R.id.gameTitle);
            game_rank = itemView.findViewById(R.id.rank);
            game_rating = itemView.findViewById(R.id.game_rate);
            game_tag1 = itemView.findViewById(R.id.tag1);
            game_tag2 = itemView.findViewById(R.id.tag2);
            game_tag3 = itemView.findViewById(R.id.tag3);
            game_duration = itemView.findViewById(R.id.duration);
            review_rating = itemView.findViewById(R.id.review_rating);
            review = itemView.findViewById(R.id.review);
        }
    }
}
