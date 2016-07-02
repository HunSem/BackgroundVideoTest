package com.huan.percy.backgroundvideotest;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.VideoView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mp = null;
    private VideoView myVideoView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        final String videoPath = Uri.parse("android.resource://" + getPackageName() + "/"
                + R.raw.background_gif).toString();
        myVideoView.setVideoPath(videoPath);
        myVideoView.start();
        myVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
                mp.setLooping(true);

            }
        });

        myVideoView
                .setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        myVideoView.setVideoPath(videoPath);
                        myVideoView.start();

                    }
                });
    }

    private void initView() {

        myVideoView = (VideoView) findViewById(R.id.videoView);

    }

}
