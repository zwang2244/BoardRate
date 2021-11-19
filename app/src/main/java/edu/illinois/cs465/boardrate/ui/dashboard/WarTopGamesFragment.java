package edu.illinois.cs465.boardrate.ui.dashboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import edu.illinois.cs465.boardrate.Game;
import edu.illinois.cs465.boardrate.MyApplication;
import edu.illinois.cs465.boardrate.databinding.FragmentWarTopGamesBinding;

public class WarTopGamesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private FragmentWarTopGamesBinding binding;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Game> allGames = new ArrayList<Game>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentWarTopGamesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        MyApplication myApplication = (MyApplication) getActivity().getApplication();
        allGames = myApplication.getAllGames();
        recyclerView = binding.rvTopGameListWar;
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new AdapterForTopWarGame(allGames, getActivity());
        recyclerView.setAdapter(mAdapter);
        return root;
    }
}