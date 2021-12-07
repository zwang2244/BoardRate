package edu.illinois.cs465.boardrate.ui.notifications;

import android.content.Context;
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

import java.util.List;

import edu.illinois.cs465.boardrate.Game;
import edu.illinois.cs465.boardrate.MyApplication;
import edu.illinois.cs465.boardrate.R;


public class AdapterForSavedGame extends RecyclerView.Adapter<AdapterForSavedGame.MyViewHolder>{
    List<Game> savedGames;
    List<Game> allGames;
    Context context;

    public AdapterForSavedGame(Context context) {

        // filter out the card games
        this.savedGames = MyApplication.getSavedGames();
        this.allGames = MyApplication.getAllGames();
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterForSavedGame.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_card, parent, false);
        AdapterForSavedGame.MyViewHolder holder = new AdapterForSavedGame.MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterForSavedGame.MyViewHolder holder, int position) {
//        holder.game_pic.
        Glide.with(context).load(this.savedGames.get(position).getImageURL()).into(holder.game_pic);
        holder.game_title.setText(this.savedGames.get(position).getName());
        holder.game_rank.setText(String.valueOf(position + 1));
        holder.game_rating.setRating(Float.parseFloat(this.savedGames.get(position).getRating()));
        holder.game_tag1.setText(this.savedGames.get(position).getTag1());
        holder.game_tag2.setText(this.savedGames.get(position).getTag2());
        holder.game_tag3.setText(this.savedGames.get(position).getTag3());
        holder.game_duration.setText(this.savedGames.get(position).getTimetoPlay());
        holder.game_save_btn.setColorFilter(MyApplication.red_save);
    }

    @Override
    public int getItemCount() {
        return savedGames.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView game_pic;
        TextView game_title;
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
            game_save_btn.setOnClickListener(new View.OnClickListener() {
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
                    System.out.println(game_save_btn.getColorFilter());
                    System.out.println(Color.argb(255, 251, 116, 114));
                    System.out.println(R.color.red_save);
                    if (saved){
                        game_save_btn.setColorFilter(MyApplication.red_save);
                    } else {
                        game_save_btn.setColorFilter(MyApplication.red_unsave);
                    }

                }
            });
        }
    }
}
