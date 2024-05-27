package com.example.myapplication11_2;

import android.animation.ObjectAnimator;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imageView);
        animation(imageView);

        Button playButton = findViewById(R.id.button);
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource("https://rus.hitmotop.com/get/music/20201207/Mil_Pops_-_ZHu-zhu-zhu_71878352.mp3");
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator moveAnim = ObjectAnimator.ofFloat(playButton, "translationX", 0f, 300f);
                moveAnim.setDuration(1000);
                moveAnim.start();

                if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.start();
                } else {
                    mediaPlayer.pause();
                }
            }
        });

        TextView textView = findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textSize(textView);
            }
        });
        }
        public void textSize(TextView scaleText){
            ObjectAnimator scaleX = ObjectAnimator.ofFloat(scaleText, "textSize", 16f, 32f);
            scaleX.setDuration(1000);
            scaleX.start();
        }
        public void animation(ImageView imageView){
            ObjectAnimator rotateAnim = ObjectAnimator.ofFloat(imageView, "rotation", 0f, 360f);
            rotateAnim.setDuration(2000);
            rotateAnim.setRepeatCount(ObjectAnimator.INFINITE);
            rotateAnim.setRepeatMode(ObjectAnimator.RESTART);
            rotateAnim.start();
        }
    }
