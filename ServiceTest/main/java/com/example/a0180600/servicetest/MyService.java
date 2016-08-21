package com.example.a0180600.servicetest;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by a0180600 on 16-8-21.
 */
public class MyService extends Service {

    private DownloadBinder mBingder = new DownloadBinder();

    class DownloadBinder extends Binder {

        public void startDownload() {
            Log.d("MyService", "startDownload executed");
        }

        public int getProgress() {
            Log.d("MyService", "getProgress executed");
            return 0;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // return mBingder;
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("MyService", "onStartCommand executed");

        new Thread(new Runnable() {
            @Override
            public void run() {
                stopSelf();
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("MyService", "onCreate executed");

        Notification notification = new Notification(R.drawable.ic_launcher,
                "Notification comes", System.currentTimeMillis());
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                notificationIntent, 0);

        // notification.setLatesEventInfo(this, "This is title", "This is content", pendingIntent);
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("This is title");
        builder.setContentText("This is content");
        builder.setContentIntent(pendingIntent);

        startForeground(1, notification);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MyService", "onDestory executed");
    }

}
