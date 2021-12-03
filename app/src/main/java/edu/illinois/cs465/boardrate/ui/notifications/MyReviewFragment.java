
package edu.illinois.cs465.boardrate.ui.notifications;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import edu.illinois.cs465.boardrate.MyApplication;
import edu.illinois.cs465.boardrate.MyReviews;
import edu.illinois.cs465.boardrate.R;
import edu.illinois.cs465.boardrate.databinding.FragmentMyReviewBinding;
import edu.illinois.cs465.boardrate.ui.home.AdapterForMyReview;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyReviewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyReviewFragment extends Fragment {

    private FragmentMyReviewBinding binding;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<MyReviews> allReviews = new ArrayList<MyReviews>();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MyReviewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyReviewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyReviewFragment newInstance(String param1, String param2) {
        MyReviewFragment fragment = new MyReviewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMyReviewBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        MyApplication myApplication = (MyApplication) getActivity().getApplication();
        allReviews = myApplication.getMyReviews();
        recyclerView = binding.rvMyReviewList;
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new AdapterForMyReview(allReviews, getActivity());
//        Log.d("mAdapter", "asdcsda");
        recyclerView.setAdapter(mAdapter);
        return root;
    }
}
