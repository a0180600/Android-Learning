package com.example.a0180600.broadcastbestpractice;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by a0180600 on 16-8-12.
 */
public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
