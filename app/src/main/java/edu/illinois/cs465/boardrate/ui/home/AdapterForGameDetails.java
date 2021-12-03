package edu.illinois.cs465.boardrate.ui.home;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.BaseAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import android.view.LayoutInflater;
import java.util.Locale;

import edu.illinois.cs465.boardrate.Game;
import edu.illinois.cs465.boardrate.GameDetailsActivity;
import edu.illinois.cs465.boardrate.ListViewAdapter;
import edu.illinois.cs465.boardrate.R;

public class AdapterForGameDetails extends BaseAdapter {
    List<Game> allGames;
    private List<Game> gamesList = null;
    Context context;
    LayoutInflater inflater;

    public AdapterForGameDetails(List<Game> allGames, Context context) {
        this.allGames = allGames;
        this.gamesList = allGames;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @NonNull

    public AdapterForGameDetails.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_review, parent, false);
        AdapterForGameDetails.MyViewHolder holder = new AdapterForGameDetails.MyViewHolder();
        view.setTag(holder);
        return holder;
    }


    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        holder.game_pic.
        Glide.with(context).load(this.gamesList.get(position).getImageURL()).into(holder.game_pic);
        holder.game_title.setText(this.gamesList.get(position).getName());
        holder.game_rating.setRating(Float.parseFloat(this.gamesList.get(position).getRating()));
        holder.game_tag1.setText(this.gamesList.get(position).getTag1());
        holder.game_tag2.setText(this.gamesList.get(position).getTag2());
        holder.game_tag3.setText(this.gamesList.get(position).getTag3());
        holder.game_duration.setText(this.gamesList.get(position).getTimetoPlay());
    }

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
        Glide.with(context).load(this.gamesList.get(position).getImageURL()).into(holder.game_pic);
        holder.game_title.setText(this.gamesList.get(position).getName());
        holder.game_rating.setRating(Float.parseFloat(this.gamesList.get(position).getRating()));
        holder.game_tag1.setText(this.gamesList.get(position).getTag1());
        holder.game_tag2.setText(this.gamesList.get(position).getTag2());
        holder.game_tag3.setText(this.gamesList.get(position).getTag3());
        holder.game_duration.setText(this.gamesList.get(position).getTimetoPlay());
        return view;
    }

    @Override
    public int getCount() {
        return gamesList.size();
    }


    @Override
    public Game getItem(int position) {
        return gamesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class MyViewHolder{
        ImageView game_pic;
        TextView  game_title;
        RatingBar game_rating;
        TextView game_tag1;
        TextView game_tag2;
        TextView game_tag3;
        TextView game_duration;

        public MyViewHolder(@NonNull View itemView) {
            game_pic = itemView.findViewById(R.id.game_pic);
            game_title = itemView.findViewById(R.id.gameTitle);
            game_rating = itemView.findViewById(R.id.game_rate);
            game_tag1 = itemView.findViewById(R.id.tag1);
            game_tag2 = itemView.findViewById(R.id.tag2);
            game_tag3 = itemView.findViewById(R.id.tag3);
            game_duration = itemView.findViewById(R.id.duration);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), GameDetailsActivity.class);
                    view.getContext().startActivity(intent);
                }
            });
        }

        public MyViewHolder(){}

        public void setattr(@NonNull View itemView){
            game_pic = itemView.findViewById(R.id.game_pic);
            game_title = itemView.findViewById(R.id.gameTitle);
            game_rating = itemView.findViewById(R.id.game_rate);
            game_tag1 = itemView.findViewById(R.id.tag1);
            game_tag2 = itemView.findViewById(R.id.tag2);
            game_tag3 = itemView.findViewById(R.id.tag3);
            game_duration = itemView.findViewById(R.id.duration);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), GameDetailsActivity.class);
                    TextView title = (TextView) view.findViewById(R.id.gameTitle);
                    intent.putExtra("gameTitle", title.getText().toString());
                    view.getContext().startActivity(intent);
                }
            });
        }
    }


}