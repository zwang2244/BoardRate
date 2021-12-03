package edu.illinois.cs465.boardrate.ui.notifications;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import edu.illinois.cs465.boardrate.Game;
import edu.illinois.cs465.boardrate.GameDetailsActivity;
import edu.illinois.cs465.boardrate.MyApplication;
import edu.illinois.cs465.boardrate.MyReviews;
import edu.illinois.cs465.boardrate.R;
import edu.illinois.cs465.boardrate.WriteReviewActivity;
import edu.illinois.cs465.boardrate.databinding.FragmentCardBinding;
import edu.illinois.cs465.boardrate.databinding.FragmentMyReviewBinding;
import edu.illinois.cs465.boardrate.databinding.FragmentMySavedGamesBinding;
import edu.illinois.cs465.boardrate.ui.home.AdapterForCardGame;
import edu.illinois.cs465.boardrate.ui.home.AdapterForMyReview;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MySavedGamesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MySavedGamesFragment extends Fragment{

    private FragmentMySavedGamesBinding binding;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Game> allSavedGames = new ArrayList<Game>();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MySavedGamesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MySavedGamesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MySavedGamesFragment newInstance(String param1, String param2) {
        MySavedGamesFragment fragment = new MySavedGamesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_my_saved_games, container, false);
        binding = FragmentMySavedGamesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        MyApplication myApplication = (MyApplication) getActivity().getApplication();
        allSavedGames = myApplication.getSavedGames();
        recyclerView = binding.rvSavedGameList;
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new AdapterForSavedGame(allSavedGames,getActivity());
        recyclerView.setAdapter(mAdapter);
        return root;
    }

}