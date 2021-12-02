package edu.illinois.cs465.boardrate;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import edu.illinois.cs465.boardrate.databinding.FragmentHomeBinding;

public class CardViewFragment extends Fragment implements View.OnClickListener {

    private View binding;
    public CardViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = inflater.inflate(R.layout.fragment_card_view, container, false);
        ImageView card = (ImageView) binding.findViewById(R.id.game_pic);

        card.setOnClickListener(this);
        return binding;
    }

    @Override
    public void onClick(View v) {
        gameCardClick(v);
    }

    public void gameCardClick(View v) {
        Intent intent = new Intent(getActivity(), GameDetailsActivity.class);
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}