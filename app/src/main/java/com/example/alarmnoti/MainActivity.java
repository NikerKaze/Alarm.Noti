package com.example.alarmnoti;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private AlarmReciver alarmReciver;
    private AlarmManager alarmManager;
    private PendingIntent alarmIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alarmReciver=new AlarmReciver();
        EditText editText=findViewById(R.id.editText);
        Button button=findViewById(R.id.Button);

        Intent intent=new Intent(this,AlarmReciver.class);
        alarmIntent=PendingIntent.getBroadcast(this,12,intent,PendingIntent.FLAG_IMMUTABLE);
        alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String time=editText.getText().toString();
                int TimeInSec=Integer.parseInt(time);
                alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime()+TimeInSec*1000,alarmIntent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}