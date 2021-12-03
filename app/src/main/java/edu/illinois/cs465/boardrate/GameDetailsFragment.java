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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGameDetailsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        MyApplication myApplication = (MyApplication) getActivity().getApplication();
        allGames = myApplication.getAllGames();
        list = (ListView) root.findViewById(R.id.game_details_listview);
        mAdapter = new AdapterForGameDetails(allGames, getActivity());
        list.setAdapter(mAdapter);

        return root;
    }
}