package com.example.a0180600.notificationtest;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

/**
 * Created by a0180600 on 16-8-20.
 */
public class MainActivity extends Activity implements View.OnClickListener {

    private Button sendNotice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendNotice = (Button) findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_notice:

                /** 找不到 .setLatesEventInfo()方法了,官方建议用 Notification.Builder
                  * NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                  * Notification notification = new Notification(R.drawable.ic_launcher, "This is ticker text", System.currentTimeMillis());
                  * notification.setLatesEventInfo(this, "This is content title", "This is content text", null);
                  * manager.notify(1, notification);
                  * break;
                 */

                Notification.Builder builder = new Notification.Builder(MainActivity.this);
                builder.setSmallIcon(R.drawable.ic_launcher);
                builder.setTicker("This is ticker text");
                builder.setContentTitle("This is content title");
                builder.setContentText("This is content text");
                builder.setWhen(System.currentTimeMillis());

                Intent intent = new Intent(this, NotificationActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
                builder.setContentIntent(pendingIntent);

                // builder.setDefaults(Notification.DEFAULT_ALL);
                // builder.setAutoCancel(true);

                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification notification = builder.build();
                manager.notify(1, notification);

            default:
                break;
        }
    }

}
