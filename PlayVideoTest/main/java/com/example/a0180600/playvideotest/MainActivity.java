package com.example.a0180600.playvideotest;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import java.io.File;

/**
 * Created by a0180600 on 16-8-22.
 */
public class MainActivity extends Activity implements View.OnClickListener {

    private VideoView videoView;
    private Button play;
    private Button pause;
    private Button replay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = (VideoView) findViewById(R.id.video_view);
        play = (Button) findViewById(R.id.play);
        pause = (Button) findViewById(R.id.pause);
        replay = (Button) findViewById(R.id.replay);
        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        replay.setOnClickListener(this);
        initVideoPath();
    }

    private void initVideoPath() {
        File file = new File(Environment.getExternalStorageDirectory(),"movie.3gp");
        videoView.setVideoPath(file.getPath());
    }

    @Override
    public void onClick(View v) {
       switch (v.getId()) {
           case R.id.play:
               if (!videoView.isPlaying()) {
                   videoView.start();
               }
               break;
           case R.id.pause:
               if (videoView.isPlaying()) {
                   videoView.pause();
               }
               break;
           case R.id.play:
               if (videoView.isPlaying()) {
                   videoView.resume();
               }
               break;
       }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (videoView != null) {
            // 释放 videoView 所占资源
            videoView.suspend();
        }
    }

}
