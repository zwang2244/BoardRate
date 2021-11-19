package edu.illinois.cs465.boardrate.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import edu.illinois.cs465.boardrate.Game;
import edu.illinois.cs465.boardrate.databinding.FragmentDashboardBinding;


public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private FragmentDashboardBinding binding;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        tabLayout = binding.topBarTop;
        viewPager = binding.viewpageTop;
        tabLayout.setupWithViewPager(viewPager);
        AdapterForTopCategory adapterForCategory = new AdapterForTopCategory(getActivity().getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        adapterForCategory.addFragement(new CardTopGamesFragment(), "Card");
        adapterForCategory.addFragement(new StrategyTopGamesFragment(), "Strategy");
        adapterForCategory.addFragement(new WarTopGamesFragment(), "War");
        adapterForCategory.addFragement(new FamilyTopGamesFragment(), "Family");
        adapterForCategory.addFragement(new PartyTopGamesFragment(), "Party");
        viewPager.setAdapter(adapterForCategory);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}