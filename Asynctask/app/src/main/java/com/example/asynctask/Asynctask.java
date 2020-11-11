package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Asynctask extends AppCompatActivity {
    public static final String TAG="hi";
    TextView TvCounter;
    Button btnStart;
    Button btnStart1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asynctask);
        TvCounter=findViewById(R.id.TvCounter);
        btnStart=findViewById(R.id.btnStart);
        btnStart1=findViewById(R.id.btnStart1);
        btnStart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random=new Random();
                TvCounter.setText(String.valueOf(random.nextInt(100)));
            }
        });
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CountTask cTask= new CountTask();
                cTask.execute();
            }
        });

    }
    class CountTask extends AsyncTask<Integer,Integer,Void>{


        @Override
        protected Void doInBackground(Integer... integers) {
            Log.d(TAG, "started");
            int n=integers[0];
            for(int i =0;i<n;i++)
                wait1sec();
            waitNsec(n);
            Log.d(TAG, "ended");
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            TvCounter.setText(String.valueOf(values[0]));

        }
    }
    void wait1sec()
    {
        long starttime = System.currentTimeMillis();
        while(System.currentTimeMillis() < starttime +1000);
    }
    void waitNsec(int n)
    {
        for(int i =0;i<n;i++){
            wait1sec();
        }
    }
}