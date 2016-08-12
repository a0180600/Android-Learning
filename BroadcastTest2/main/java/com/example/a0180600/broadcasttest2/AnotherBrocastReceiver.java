package com.example.a0180600.broadcasttest2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by a0180600 on 16-8-11.
 */
public class AnotherBrocastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "received in AnotherBrocastReceiver",Toast.LENGTH_SHORT).show();
    }

}
