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
import edu.illinois.cs465.boardrate.R;

public class AdapterForStrategyGame extends RecyclerView.Adapter<AdapterForStrategyGame.MyViewHolder> {
    List<Game> allGames;
    Context context;

    public AdapterForStrategyGame(List<Game> allGames, Context context) {

        //sort the game by ranking by adding a custom comparator
        Collections.sort(allGames, new Comparator<Game>(){
            public int compare(Game o1, Game o2){
                if(o1.getRanking1() == o2.getRanking1())
                    return 0;
                return o1.getRanking1() < o2.getRanking1() ? -1 : 1;
            }
        });
        // filter out the card games
        ArrayList<Game> strategygames = new ArrayList<>();
        for(int i = 0; i < allGames.size(); i++){
            if(allGames.get(i).getTag1().equals("Strategy") || allGames.get(i).getTag2().equals("Strategy") || allGames.get(i).getTag3().equals("Strategy")){
                strategygames.add(allGames.get(i));
            }
        }
        this.allGames = strategygames;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_card, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        holder.game_pic.
        Glide.with(context).load(this.allGames.get(position).getImageURL()).into(holder.game_pic);
        holder.game_title.setText(this.allGames.get(position).getName());
        holder.game_rank.setText(String.valueOf(position + 1));
        holder.game_rating.setRating(Float.parseFloat(this.allGames.get(position).getRating()));
        holder.game_tag1.setText(this.allGames.get(position).getTag1());
        holder.game_tag2.setText(this.allGames.get(position).getTag2());
        holder.game_tag3.setText(this.allGames.get(position).getTag3());
        holder.game_duration.setText(this.allGames.get(position).getTimetoPlay());
    }

    @Override
    public int getItemCount() {
        return allGames.size();
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
        }
    }
}
