package edu.illinois.cs465.boardrate.ui.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
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
import edu.illinois.cs465.boardrate.GameDetailsActivity;
import edu.illinois.cs465.boardrate.MyApplication;
import edu.illinois.cs465.boardrate.R;

public class AdapterForFamilyGame extends RecyclerView.Adapter<AdapterForFamilyGame.MyViewHolder> {
    List<Game> allGames;
    List<Game> savedGames;
    Context context;
    String SortBy;
    public AdapterForFamilyGame(List<Game> allGames, List<Game> savedGames, String SortBy, Context context) {
        this.SortBy = SortBy;
        if(this.SortBy.equals("Month")){
            //sort the game by ranking by adding a custom comparator
            Collections.sort(allGames, new Comparator<Game>(){
                public int compare(Game o1, Game o2){
                    if(o1.getRanking1() == o2.getRanking1())
                        return 0;
                    return o1.getRanking1() < o2.getRanking1() ? -1 : 1;
                }
            });
        }else if(this.SortBy.equals("Week")){
            //sort the game by ranking by adding a custom comparator
            Collections.sort(allGames, new Comparator<Game>(){
                public int compare(Game o1, Game o2){
                    if(o1.getRankings2()== o2.getRankings2())
                        return 0;
                    return o1.getRankings2() < o2.getRankings2() ? -1 : 1;
                }
            });
        }else if(this.SortBy.equals("Day")){
            Collections.sort(allGames, new Comparator<Game>(){
                public int compare(Game o1, Game o2){
                    if(Float.parseFloat(o1.getRating())== Float.parseFloat(o2.getRating()))
                        return 0;
                    return Float.parseFloat(o1.getRating()) < Float.parseFloat(o2.getRating()) ? 1 : -1;
                }
            });
        }
        // filter out the card games
        ArrayList<Game> familygames = new ArrayList<>();
        for(int i = 0; i < allGames.size(); i++){
            if(allGames.get(i).getTag1().equals("Family") || allGames.get(i).getTag2().equals("Family") || allGames.get(i).getTag3().equals("Family")){
                familygames.add(allGames.get(i));
            }
        }
        this.allGames = familygames;
        this.context = context;
        this.savedGames = savedGames;
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
        if(this.allGames.get(position).isIfSaved()){ //&& holder.game_save_btn != null){
            holder.game_save_btn.setColorFilter(MyApplication.red_save);
        }else{
            holder.game_save_btn.setColorFilter(MyApplication.red_unsave);
        }
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
        ImageButton game_save_btn;

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
            game_save_btn = itemView.findViewById(R.id.btn_save);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TextView title = (TextView) view.findViewById(R.id.gameTitle);
                    Intent intent = new Intent(view.getContext(), GameDetailsActivity.class);
                    intent.putExtra("gameTitle", title.getText().toString());
                    context.startActivity(intent);
                }
            });

            ImageButton save= itemView.findViewById(R.id.btn_save);
            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Toast.makeText(v.getContext(),"click", Toast.LENGTH_LONG).show();
                    System.out.println("click");
                    String t = game_title.getText().toString();
                    boolean saved = false;
                    for(int i = 0; i < allGames.size(); i++){
                        if(allGames.get(i).getName().equals(t)){
                            saved = allGames.get(i).isIfSaved();
                            if (!saved){
                                allGames.get(i).setIfSaved(true);
                                savedGames.add(allGames.get(i));
                                saved = true;
                            } else {
                                allGames.get(i).setIfSaved(false);
                                savedGames.remove(allGames.get(i));
                                saved = false;
                            }

                            break;
                        }
                    }
                    System.out.println(save.getColorFilter());
                    System.out.println(Color.argb(255, 251, 116, 114));
                    System.out.println(R.color.red_save);
                    if (saved){
                        save.setColorFilter(MyApplication.red_save);
                    } else {
                        save.setColorFilter(MyApplication.red_unsave);
                    }
                }
            });
        }
    }
}
