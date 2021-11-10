package com.example.erronkatest;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

@SuppressLint("StaticFieldLeak")
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent login=new Intent(this, Login.class);
        startActivity(login);
    }

}
