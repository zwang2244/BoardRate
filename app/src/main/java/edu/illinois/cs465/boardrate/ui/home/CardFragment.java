package edu.illinois.cs465.boardrate.ui.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import edu.illinois.cs465.boardrate.Game;
import edu.illinois.cs465.boardrate.MyApplication;
import edu.illinois.cs465.boardrate.R;
import edu.illinois.cs465.boardrate.databinding.FragmentCardBinding;

public class CardFragment extends Fragment {
    private FragmentCardBinding binding;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Game> allGames = new ArrayList<Game>();
    private RadioGroup radioGroup;
    private String Sortby = "Month";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        MyApplication myApplication = (MyApplication) getActivity().getApplication();
        allGames = myApplication.getAllGames();
//        for (int i = 0; i<allGames.size();i++){
//            Log.d("home fragment", "all games loaded?: " + allGames.get(i));
//        }
        recyclerView = binding.rvGameList;
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new AdapterForCardGame(allGames, Sortby, getActivity());
        recyclerView.setAdapter(mAdapter);

        radioGroup = binding.radioGroupCard;
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb1 = binding.radioButton1;
                RadioButton rb2 = binding.radioButton2;
                RadioButton rb3 = binding.radioButton3;
                if(rb1.getId() == checkedId){
                    Sortby = "Month";
                    mAdapter = new AdapterForCardGame(allGames, Sortby, getActivity());
                    recyclerView.setAdapter(mAdapter);
                }
                if(rb2.getId() == checkedId){
                    Sortby = "Week";
                    mAdapter = new AdapterForCardGame(allGames, Sortby, getActivity());
                    recyclerView.setAdapter(mAdapter);

                }else if(rb3.getId() == checkedId){
                    Sortby = "Day";
                    mAdapter = new AdapterForCardGame(allGames, Sortby, getActivity());
                    recyclerView.setAdapter(mAdapter);
                }
            }
        });

        return root;
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_card, container, false);
    }


}