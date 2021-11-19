package com.example.erronkauno2_swipe.Login;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.erronkauno2_swipe.R;

public class PlaceHolderView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_holder_view);
        Intent login=new Intent(this, Login.class);
        startActivity(login);
    }

}
