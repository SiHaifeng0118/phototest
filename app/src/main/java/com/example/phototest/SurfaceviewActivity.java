package com.example.phototest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class SurfaceviewActivity extends AppCompatActivity implements SurfaceHolder.Callback, View.OnClickListener {
    private SurfaceView surfaceView;
    private MediaPlayer mediaPlayer;
    private SurfaceHolder surfaceHolder;
    private Button btn_play;
    private Button btn_pause;
    private Button btn_stop;
    private String path;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surfaceview);
        path = "/storage/emulated/0/DCIM/Camera/VID_20221201_163533.mp4";
        surfaceView = findViewById(R.id.sfv_show);

        btn_pause = findViewById(R.id.btn_pause);
        btn_play = findViewById(R.id.btn_start);
        btn_stop = findViewById(R.id.btn_stop);
        btn_play.setOnClickListener(this);
        btn_pause.setOnClickListener(this);
        btn_stop.setOnClickListener(this);

        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);
        mediaPlayer = new MediaPlayer();

        try {
            mediaPlayer.setDataSource(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });


    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        Surface surface = surfaceHolder.getSurface();
        mediaPlayer.setSurface(surface);
        mediaPlayer.prepareAsync();


    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_start:
                mediaPlayer.start();
                break;
            case R.id.btn_pause:
                mediaPlayer.pause();
                break;
            case R.id.btn_stop:
                mediaPlayer.stop();
                break;

        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}