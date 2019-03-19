package com.example.movs_project.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.Window;

import com.example.movs_project.R;

public class MainActivity extends AppCompatActivity implements SearchFragment.OnFragmentInteractionListener, GameInfoFragment.OnFragmentInteractionListener, PlayerInfoFragment.OnFragmentInteractionListener, SummonerFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       this.getSupportActionBar().hide();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
