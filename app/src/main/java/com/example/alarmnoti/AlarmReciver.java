package com.example.alarmnoti;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class AlarmReciver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "You got a Notification", Toast.LENGTH_SHORT).show();
        String CHANNEL_ID="ID";
        String CHANNEL_NAME="NAME";
        int NOTIFICATION_ID=1;
        NotificationManager notificationManager=(NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O) {
            NotificationChannel channel=new NotificationChannel(CHANNEL_ID,CHANNEL_NAME,NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder notiBbuilder=new NotificationCompat.Builder(context,CHANNEL_ID).
                setSmallIcon(R.drawable.ic_launcher_foreground).
                setContentTitle("Alarm").
                setContentText("Your Alarm went off").
                setPriority(NotificationCompat.PRIORITY_DEFAULT);
        notificationManager.notify(NOTIFICATION_ID,notiBbuilder.build());
    }
}