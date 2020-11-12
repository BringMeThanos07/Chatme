package com.example.alarmintro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btntask= findViewById(R.id.btntask);

        btntask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(
                        getBaseContext(),
                        MainActivity2.class
                );
                //schedule a task which will run 5 min from now and start my app
                PendingIntent pendingIntent= PendingIntent.getActivity(getBaseContext(),1234,intent,PendingIntent.FLAG_UPDATE_CURRENT);

                AlarmManager alarmManager= (AlarmManager) getSystemService(ALARM_SERVICE);

                //alarmManager.set(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime()+60000,pendingIntent);

                alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime()+60000, 60000,pendingIntent);
               // Intent i2 = new Intent(getBaseContext(),MainActivity.class);

                //PendingIntent pi2= PendingIntent.getActivity(getBaseContext())

            }
        });
    }
}