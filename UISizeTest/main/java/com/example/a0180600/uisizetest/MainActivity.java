package com.example.a0180600.uisizetest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by a0180600 on 16-7-19.
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        float xdpi = getResources().getDisplayMetrics().xdpi;
        float ydip = getResources().getDisplayMetrics().ydpi;

        Log.d("MainActivity", "xdpi is " + xdpi);
        Log.d("MainActivity", "ydpi is " + ydip);

    }

}
