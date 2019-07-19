package com.example.week5day4fragmentshomework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;

import com.example.week5day4fragmentshomework.model.celebrity.Celebrity;
import com.example.week5day4fragmentshomework.model.datasource.local.database.CelebritiesDatabaseHelper;

public class MainActivity extends AppCompatActivity implements CelebritiesListFragment.OnFragmentInteractionListener {

    private CelebritiesDatabaseHelper celebritiesDatabaseHelper;
    private FragmentManager fragmentManager;
    private CelebritiesListFragment celebritiesListFragment;
    private CelebrityDetailsFragment celebrityDetailsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        celebritiesDatabaseHelper = new CelebritiesDatabaseHelper();
        setupAndAddCelebritiesListFragment();
        setupAndAddCelebrityDetailsFragment();
    }

    private void setupAndAddCelebrityDetailsFragment() {
        celebrityDetailsFragment = CelebrityDetailsFragment.newInstance();
        fragmentManager.beginTransaction().add(R.id.frmCelebrityDetailsFragment, celebrityDetailsFragment)
                .addToBackStack("CELEBRITY_DETAILS_FRAGMENT").commit();
    }

    private void setupAndAddCelebritiesListFragment() {
        celebritiesListFragment = CelebritiesListFragment.newInstance();
        celebritiesListFragment.setCelebrities(celebritiesDatabaseHelper.getCelebrities());

        fragmentManager.beginTransaction().add(R.id.frmCelebritiesListFragment, celebritiesListFragment)
                .addToBackStack("CELEBRITIES_LIST_FRAGMENT").commit();
    }

    @Override
    public void onFragmentInteraction(Celebrity celebrity) {
        Log.d("TAG_CLICKED", celebrity.getFirstName() + " " + celebrity.getLastName());

        if(celebrity != null){
            celebrityDetailsFragment.displayCelebrityDetails(celebrity);
        }

    }
}
