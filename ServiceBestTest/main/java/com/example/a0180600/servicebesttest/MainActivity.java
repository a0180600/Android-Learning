package com.example.a0180600.servicebesttest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by a0180600 on 16-8-22.
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, LongRunningService.class);
        startActivity(intent);
    }

}
