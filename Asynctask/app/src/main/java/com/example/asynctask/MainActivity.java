package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG="Async";
    public static final String TAG1="runnable";
    ConstraintLayout clbackground;
    Button buttonchangecolor;
    Button intent1;
    ListView lvItems;
    String[] items = new String[]{
            "Al[ha",
            "beta",
            "gamma",
            "delta",
            "phi",
            "chi",
            "pie",
            "humo"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonchangecolor=findViewById(R.id.buttonchangecolor);
        clbackground=findViewById(R.id.clbackground);
        intent1=findViewById(R.id.intent1);
        lvItems=findViewById(R.id.lvItems);

        ArrayAdapter<String> itemAdapter= new ArrayAdapter<>(
         this,
         android.R.layout.simple_list_item_1,
         android.R.id.text1,
         items
        );
        lvItems.setAdapter(itemAdapter);
        intent1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,Asynctask.class);
                startActivity(intent);
            }
        });

        buttonchangecolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Handler h = new Handler();
                Runnable r= new Runnable() {
                    @Override
                    public void run() {
                        Log.d(TAG1,"we have waited 5 sec");
                        clbackground.setBackgroundColor(Color.CYAN);
                    }
                };
                h.postDelayed(r,3000);


           //   1)  waitNsec(10);
            //  1)  clbackground.setBackgroundColor(Color.CYAN);
                //  1) Log.d(TAG, "onclick: "+ System.currentTimeMillis());
            }
        });
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