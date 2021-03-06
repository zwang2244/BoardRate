package edu.illinois.cs465.boardrate.ui.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.BaseAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import edu.illinois.cs465.boardrate.Game;
import edu.illinois.cs465.boardrate.GameDetailsActivity;
import edu.illinois.cs465.boardrate.GameDetailsFragment;
import edu.illinois.cs465.boardrate.ListViewAdapter;
import edu.illinois.cs465.boardrate.MainActivity;
import edu.illinois.cs465.boardrate.MyApplication;
import edu.illinois.cs465.boardrate.R;

public class AdapterForSearch extends BaseAdapter {
    List<Game> allGames;
    private List<Game> gamesList = null;
    List<Game> savedGames;
    Context context;
    LayoutInflater inflater;

    public AdapterForSearch(List<Game> allGames, List<Game> savedGames, Context context) {
        this.allGames = allGames;
        this.gamesList = allGames;
        this.context = context;
        this.savedGames = savedGames;
        inflater = LayoutInflater.from(context);
    }

    @NonNull

    public AdapterForSearch.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_card_search, parent, false);
        AdapterForSearch.MyViewHolder holder = new AdapterForSearch.MyViewHolder();
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
        if(this.gamesList.get(position).isIfSaved()){ //&& holder.game_save_btn != null){
            holder.game_save_btn.setColorFilter(MyApplication.red_save);
        }else{
            holder.game_save_btn.setColorFilter(MyApplication.red_unsave);
        }
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final AdapterForSearch.MyViewHolder holder;
        if (view == null) {
            holder = new AdapterForSearch.MyViewHolder();
            view = inflater.inflate(R.layout.game_card_search, null);
            view.setTag(holder);
            holder.setattr(view);
        } else {
            holder = (AdapterForSearch.MyViewHolder) view.getTag();
        }
        Glide.with(context).load(this.gamesList.get(position).getImageURL()).into(holder.game_pic);
        holder.game_title.setText(this.gamesList.get(position).getName());
        holder.game_rating.setRating(Float.parseFloat(this.gamesList.get(position).getRating()));
        holder.game_tag1.setText(this.gamesList.get(position).getTag1());
        holder.game_tag2.setText(this.gamesList.get(position).getTag2());
        holder.game_tag3.setText(this.gamesList.get(position).getTag3());
        holder.game_duration.setText(this.gamesList.get(position).getTimetoPlay());
        if(this.gamesList.get(position).isIfSaved()){ //&& holder.game_save_btn != null){
            holder.game_save_btn.setColorFilter(MyApplication.red_save);
        }else{
            holder.game_save_btn.setColorFilter(MyApplication.red_unsave);
        }
        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        gamesList = new ArrayList<Game>();
        Log.d("Search", "XXXXX Added to list");
        if (charText.length() == 0) {
            gamesList.addAll(allGames);
        } else {
            for (Game wp : allGames) {
                if (wp.getName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    gamesList.add(wp);

                }
            }
        }
        notifyDataSetChanged();
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
        ImageButton game_save_btn;
        public MyViewHolder(@NonNull View itemView) {
            game_pic = itemView.findViewById(R.id.game_pic);
            game_title = itemView.findViewById(R.id.gameTitle);
            game_rating = itemView.findViewById(R.id.game_rate);
            game_tag1 = itemView.findViewById(R.id.tag1);
            game_tag2 = itemView.findViewById(R.id.tag2);
            game_tag3 = itemView.findViewById(R.id.tag3);
            game_duration = itemView.findViewById(R.id.duration);
            game_save_btn = itemView.findViewById(R.id.btn_save);
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
            game_save_btn = itemView.findViewById(R.id.btn_save);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(view.getId() != R.id.btn_save){
                        TextView title = (TextView) view.findViewById(R.id.gameTitle);
                        Intent intent = new Intent(view.getContext(), GameDetailsActivity.class);
                        intent.putExtra("gameTitle", title.getText().toString());
                        context.startActivity(intent);
                    }
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

//                    MyApplication myApplication = (MyApplication) v.getContext().get;
//                    allGames = myApplication.getAllGames();

                }
            });
        }
    }


}
