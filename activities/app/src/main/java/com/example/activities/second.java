package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class second extends AppCompatActivity {
     TextView textView2=(TextView)findViewById(R.id.textView2);
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent=getIntent();
        int result=intent.getIntExtra("result",0);
        textView2.setText(String.valueOf(result));
    }
}