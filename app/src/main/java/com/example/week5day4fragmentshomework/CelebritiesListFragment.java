package com.example.week5day4fragmentshomework;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.week5day4fragmentshomework.model.celebrity.Celebrity;

import java.util.List;


public class CelebritiesListFragment extends Fragment implements CelebritiesListAdapter.CelebrityOnClickHandler {

private RecyclerView rvCelebrities;
    private List<Celebrity> celebrities;

    private OnFragmentInteractionListener mListener;

    public CelebritiesListFragment() {
        // Required empty public constructor
    }

    public static CelebritiesListFragment newInstance() {
        CelebritiesListFragment fragment = new CelebritiesListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }

        //save data through configchanges and lifecycle changes
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_celebrities_list, container, false);
    }

    public void setCelebrities(List<Celebrity> celebrities) {
        this.celebrities = celebrities;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        rvCelebrities = view.findViewById(R.id.rvCelebrities);
        rvCelebrities.setLayoutManager(layoutManager);
        CelebritiesListAdapter celebritiesListAdapter = new CelebritiesListAdapter(celebrities, this);
        rvCelebrities.setAdapter(celebritiesListAdapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(Celebrity celebrity) {
        mListener.onFragmentInteraction(celebrity);
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Celebrity celebrity);
    }
}
