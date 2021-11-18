package edu.illinois.cs465.boardrate.ui.dashboard;

import android.os.Bundle;
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
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import edu.illinois.cs465.boardrate.Game;
import edu.illinois.cs465.boardrate.R;
import edu.illinois.cs465.boardrate.databinding.FragmentDashboardBinding;
import edu.illinois.cs465.boardrate.ui.home.AdapterForCategory;
import edu.illinois.cs465.boardrate.ui.home.CardFragment;
import edu.illinois.cs465.boardrate.ui.home.FamilyFragment;
import edu.illinois.cs465.boardrate.ui.home.PartyFragment;
import edu.illinois.cs465.boardrate.ui.home.StrategyFragment;
import edu.illinois.cs465.boardrate.ui.home.WarFragment;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private FragmentDashboardBinding binding;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Game> allGames = new ArrayList<Game>();
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        tabLayout = binding.topBar;
        viewPager = binding.viewpageHome;
        tabLayout.setupWithViewPager(viewPager);
        edu.illinois.cs465.boardrate.ui.home.AdapterForCategory adapterForCategory = new AdapterForCategory(getActivity().getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        adapterForCategory.addFragement(new CardFragment(), "Card");
        adapterForCategory.addFragement(new StrategyFragment(), "Strategy");
        adapterForCategory.addFragement(new WarFragment(), "War");
        adapterForCategory.addFragement(new FamilyFragment(), "Family");
        adapterForCategory.addFragement(new PartyFragment(), "Party");
        viewPager.setAdapter(adapterForCategory);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}