package edu.illinois.cs465.boardrate.ui.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

import edu.illinois.cs465.boardrate.Game;
import edu.illinois.cs465.boardrate.MyApplication;
import edu.illinois.cs465.boardrate.R;
import edu.illinois.cs465.boardrate.databinding.FragmentSearchBinding;

public class SearchFragment extends Fragment implements SearchView.OnQueryTextListener{

    private FragmentSearchBinding binding;
    private RecyclerView recyclerView;
    private ListView list;
    private AdapterForSearch mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Game> allGames = new ArrayList<Game>();
    private List<Game> savedGames = new ArrayList<Game>();
    SearchView editsearch;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSearchBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        MyApplication myApplication = (MyApplication) getActivity().getApplication();
        allGames = myApplication.getAllGames();
        savedGames = myApplication.getSavedGames();
        list = (ListView) root.findViewById(R.id.searchListView);
//        recyclerView = binding.rvSearch;
//        recyclerView.setHasFixedSize(true);
//        layoutManager = new LinearLayoutManager(getActivity());
//        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new AdapterForSearch(allGames, savedGames, getActivity());
        list.setAdapter(mAdapter);

        // Locate the EditText in listview_main.xml
        editsearch = (SearchView) root.findViewById(R.id.gameSearchView);
        editsearch.setOnQueryTextListener(this);
        return root;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        mAdapter.filter(newText);
        return false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mAdapter = null;
        list = null;
    }
}