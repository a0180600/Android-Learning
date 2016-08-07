package com.example.a0180600.fragmentbestpratice;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.example.a0180600.fragmentbestpratice.R;

/**
 * Created by a0180600 on 16-8-7.
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
    }

}
