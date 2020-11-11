package com.example.higherlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int n;
    public void clickme(View view)
    {

        String message;
        EditText editText=(EditText)findViewById(R.id.editText);
        int guessno=Integer.parseInt(editText.getText().toString());
        if (guessno>n)
        { message= "go lower";}
        else if (guessno<n)
        { message="go higher";}
        else
            message="yayy, you got it!";
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        Log.i("info","pressed");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random rand=new Random();
        n=rand.nextInt(50)+1;
    }
}