package edu.illinois.cs465.boardrate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import edu.illinois.cs465.boardrate.databinding.FragmentGameDetailsBinding;
import edu.illinois.cs465.boardrate.ui.home.AdapterForGameDetails;


public class GameDetailsFragment extends Fragment {

    private FragmentGameDetailsBinding binding;
    private ListView list;
    private AdapterForGameDetails mAdapter;
    private List<Game> allGames = new ArrayList<Game>();
    private List<Review> allReviews = new ArrayList<>();
    private String gameTitle;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentGameDetailsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        MyApplication myApplication = (MyApplication) getActivity().getApplication();
        allGames = myApplication.getAllGames();
        allReviews = ((MainActivity)getActivity()).getAllReviews();
        list = (ListView) root.findViewById(R.id.game_details_listview);
        int gameID = 0;
        for (Game g : allGames){
            if (g.getName().equals(gameTitle)){
                gameID = g.getGameID();
                break;
            }
        }
        mAdapter = new AdapterForGameDetails(allReviews, gameID, getActivity());
        list.setAdapter(mAdapter);

        return root;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }
}