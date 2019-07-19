package com.example.week5day4fragmentshomework;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.week5day4fragmentshomework.model.celebrity.Celebrity;
import com.squareup.picasso.Picasso;


public class CelebrityDetailsFragment extends Fragment {

    private ImageView ivPicture;
    private TextView tvFullName;
    private TextView tvAge;
    private TextView tvNationality;
    private TextView tvMostPopularMovie;


    public CelebrityDetailsFragment() {
        // Required empty public constructor
    }

    public static CelebrityDetailsFragment newInstance() {
        CelebrityDetailsFragment fragment = new CelebrityDetailsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }

        //setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_celebrity_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ivPicture = view.findViewById(R.id.ivPicture);
        tvFullName = view.findViewById(R.id.tvFullName);
        tvAge = view.findViewById(R.id.tvAge);
        tvNationality = view.findViewById(R.id.tvNationality);
        tvMostPopularMovie = view.findViewById(R.id.tvMostPopularMovie);
    }

    public void displayCelebrityDetails(Celebrity celebrity) {

        Picasso.get().load(celebrity.getPicture()).into(ivPicture);

        tvFullName.setText(celebrity.getFirstName() + " " + celebrity.getLastName());
        tvAge.setText("Age: " + celebrity.getAge());
        tvNationality.setText("Nationality: " + celebrity.getNationality());
        tvMostPopularMovie.setText("Popular Movie: " + celebrity.getMostPopularMovie());
    }
}
