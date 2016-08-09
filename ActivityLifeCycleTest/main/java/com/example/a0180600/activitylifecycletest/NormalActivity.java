package com.example.a0180600.activitylifecycletest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by a0180600 on 16-7-15.
 */
public class NormalActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.normal_layout);
    }

}

