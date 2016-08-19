package com.example.a0180600.uilayouttest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by a0180600 on 16-7-17.
 */
public class MainActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
    }

}
