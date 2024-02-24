package com.example.ppdbtingkatsma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    MediaPlayer sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sound = MediaPlayer.create(this,R.raw.rawr);
        sound.setVolume(1,1);
        sound.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent panggil = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(panggil);
                finish();
            }
        }, 5000);
    }
}

