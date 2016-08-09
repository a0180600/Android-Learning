package com.example.a0180600.activitylifecycletest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created by a0180600 on 16-7-15.
 */
public class MainActivity extends Activity{

    public static final String TAG = "MainActivity";

    // Override onCreate 2 button
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        // make a judgement to find data_key is null or not
        if (savedInstanceState != null) {
            String tempData = savedInstanceState.getString("data_key");
            Log.d(TAG, tempData);
        }

        // Buttons creating

        Button startNormalActivity = (Button) findViewById(R.id.start_normal_activity);
        final Button startDialogActivity = (Button) findViewById(R.id.start_dialog_activity);

        startNormalActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NormalActivity.class);
                startActivity(intent);
            }
        });

        startDialogActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });
    }

    // Override onStart
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    // Overrdie onResume
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    // Override onPause
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    // Override onStop
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    // Override onDestroy
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    // Override onRestart
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    // Bundle onSaveInstanceState
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String tempData = "Something you just typed";
        outState.putString("data_key", tempData);
    }

}
