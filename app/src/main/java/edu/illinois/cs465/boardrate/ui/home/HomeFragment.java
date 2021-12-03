package edu.illinois.cs465.boardrate.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import edu.illinois.cs465.boardrate.Game;
import edu.illinois.cs465.boardrate.MyApplication;
import edu.illinois.cs465.boardrate.R;
import edu.illinois.cs465.boardrate.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Game> allGames = new ArrayList<Game>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        tabLayout = binding.topBar;
        viewPager = binding.viewpageHome;
        tabLayout.setupWithViewPager(viewPager);
        AdapterForCategory adapterForCategory = new AdapterForCategory(getActivity().getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        adapterForCategory.addFragement(new CardFragment(), "Card");
        adapterForCategory.addFragement(new StrategyFragment(), "Strategy");
        adapterForCategory.addFragement(new WarFragment(), "War");
        adapterForCategory.addFragement(new PartyFragment(), "Party");
        adapterForCategory.addFragement(new FamilyFragment(), "Family");
        viewPager.setAdapter(adapterForCategory);
        //        homeViewModel.getText();
//        final TextView textView = binding.textHome;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });



//        MyApplication myApplication = (MyApplication) getActivity().getApplication();
//        allGames = myApplication.getAllGames();
//        for (int i = 0; i<allGames.size();i++){
//            Log.d("home fragment", "all games loaded?: " + allGames.get(i));
//        }
//
//        recyclerView = binding.rvGameList;
//        recyclerView.setHasFixedSize(true);
//        layoutManager = new LinearLayoutManager(getActivity());
//        recyclerView.setLayoutManager(layoutManager);
//        mAdapter = new AdapterForGame(allGames, getActivity());
//        recyclerView.setAdapter(mAdapter);


        return root;
    }

//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
////        binding = null;
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mAdapter = null;
        recyclerView = null;
    }

}