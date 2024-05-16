package com.example.myapplication7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button buttonStart;
    private Button buttonStop;
    private Button buttonNext;
    private Intent startIntent;
    private Intent stopIntent;
    private boolean isMusicService1Active = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStart = findViewById(R.id.buttonStart);
        buttonStop = findViewById(R.id.buttonStop);
        buttonNext = findViewById(R.id.buttonNext);

        setupButtonListeners();
    }

    private void setupButtonListeners() {
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                

                startMusicService();

            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopMusicService();
            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleMusicService();
            }
        });
    }

    private void startMusicService() {
        if (isMusicService1Active) {
            startIntent = new Intent(MainActivity.this, MusicService.class);
        } else {
            startIntent = new Intent(MainActivity.this, MusicService2.class);
        }
        startService(startIntent);
    }

    private void stopMusicService() {
        if (isMusicService1Active) {
            stopIntent = new Intent(MainActivity.this, MusicService.class);
        } else {
            stopIntent = new Intent(MainActivity.this, MusicService2.class);
        }
        stopService(stopIntent);
    }

    private void toggleMusicService() {
        stopMusicService();
        isMusicService1Active = !isMusicService1Active;
    }
}