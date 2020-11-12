package com.example.filereadwrite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText= findViewById(R.id.editText);
        Button btnWrite= findViewById(R.id.btnWrite);
        Button btnRead= findViewById(R.id.btnRead);
        TextView textView=findViewById(R.id.textView);
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();

                File dataDir = ContextCompat.getDataDir(MainActivity.this);
                File myFile = new File(dataDir,"file.txt");

                try {
                    FileOutputStream fos = new FileOutputStream(myFile);
                    fos.write(text.getBytes());
                } catch (FileNotFoundException e) {
                    Toast.makeText(MainActivity.this, "file not found", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(MainActivity.this, "Error while writing file", Toast.LENGTH_SHORT).show();
                }

            }
        });
        /* In Kotlin
        btnWrite.setOnClickListener{
        val dataDir = ContextCompat.getDataDir(this)
        val myFile = File(dataDir, "file.txt")
        myFile.writeText(editText.text.toString())
        }

        btnRead.setOnClickListener{
        val dataDir = ContextCompat.getDataDir(this)
        val myFile = File(dataDir, "file.txt")
        textView.text= myFile.readText()
        }
         */

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File dataDir = ContextCompat.getDataDir(MainActivity.this);
                File myFile = new File(dataDir,"file.txt");

                try {
                    FileInputStream fis = new FileInputStream(myFile);
                    InputStreamReader inputStreamReader=new InputStreamReader(fis);
                    BufferedReader bufferedReader= new BufferedReader(inputStreamReader);

                    StringBuilder stringBuilder= new StringBuilder();
                    String buffer= bufferedReader.readLine();
                    while(buffer != null)
                    {
                        stringBuilder.append(buffer);
                        buffer= bufferedReader.readLine();
                    }

                    String text = stringBuilder.toString();
                    textView.setText(text);

                } catch (FileNotFoundException e) {
                    Toast.makeText(MainActivity.this, "File not found", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(MainActivity.this, "Error while reading", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}