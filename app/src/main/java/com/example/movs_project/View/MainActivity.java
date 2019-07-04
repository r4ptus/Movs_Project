package com.example.movs_project.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Window;

import com.example.movs_project.Model.Maps;
import com.example.movs_project.R;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements Splash.OnFragmentInteractionListener,SearchFragment.OnFragmentInteractionListener, GameInfoFragment.OnFragmentInteractionListener, PlayerInfoFragment.OnFragmentInteractionListener, SummonerFragment.OnFragmentInteractionListener {
    private static Timer timer;
    private static TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            Maps.CALLS = 0;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       this.getSupportActionBar().hide();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    static void start(){
        if(timer != null){
            return;
        }
        timer = new Timer();
        timer.scheduleAtFixedRate(timerTask,0,2000);
    }
}
