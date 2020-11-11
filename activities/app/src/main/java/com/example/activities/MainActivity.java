package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
  TextView textView,textUrl;
 EditText editTextTextPersonName4,editTextTextPersonName3;
  Button btnadd;
  ImageView browser;
    String TAG="yash";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      // textView=findViewById(R.id.textView);
        textUrl=findViewById(R.id.textUrl);
       editTextTextPersonName4=findViewById(R.id.editTextTextPersonName4);
        editTextTextPersonName3=findViewById(R.id.editTextTextPersonName3);
        btnadd=findViewById(R.id.btnadd);
        browser=findViewById(R.id.browser);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int var1=Integer.valueOf(editTextTextPersonName3.getText().toString());
                int var2=Integer.valueOf(editTextTextPersonName4.getText().toString());
                int var3=var1+var2;
               // textView.setText(String.valueOf(var3));
                //go to second activity
                Intent i =new Intent(MainActivity.this, second.class);
                i.putExtra("result",var3);

                startActivity(i);
            }
        });
        browser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url=textUrl.getText().toString();
                Uri uri=Uri.parse(url);
                Intent i=new Intent(Intent.ACTION_VIEW,uri);
                try {
                    startActivity(i);
                }catch (ActivityNotFoundException exc){
                    // String TAG="yash";
                    Log.e(TAG, "onClick: not found",exc );
                    Toast.makeText(MainActivity.this, "could not found", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}