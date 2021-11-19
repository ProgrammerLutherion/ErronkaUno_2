package com.example.erronkauno2_swipe.Secondaries;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.erronkauno2_swipe.Classes.Product;
import com.example.erronkauno2_swipe.R;

import javax.security.auth.login.LoginException;


public class Produktua_Details extends AppCompatActivity implements GestureDetector.OnGestureListener{
    private GestureDetector gestureDetector;
    private float x1,x2,y1,y2;
    private static int MIN_DISTANCE = 100;
    String TAG = "Swipped";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.produktuak_details);
        this.gestureDetector = new GestureDetector(Produktua_Details.this, this);

        Product p = new Product(Integer.parseInt(getIntent().getStringExtra("id")),
                getIntent().getStringExtra("name"),
                getIntent().getStringExtra("description"),
                getIntent().getStringExtra("list_price"),
                getIntent().getStringExtra("volume"),
                getIntent().getStringExtra("weight"),
                getIntent().getStringExtra("stock"),
                getIntent().getStringExtra("imagen"),
                Boolean.parseBoolean(getIntent().getStringExtra("sale_ok")),
                Boolean.parseBoolean(getIntent().getStringExtra("active")),
                Boolean.parseBoolean(getIntent().getStringExtra("published")));

        ImageView imagen = (ImageView) findViewById(R.id.imageView);

        byte[] decodedString = Base64.decode(p.getImagen(), Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

        imagen.setImageBitmap(decodedByte);

        TextView name = (TextView) findViewById(R.id.nameTV);
        name.setText(p.getName());
        TextView description = (TextView) findViewById(R.id.descriptionTV);
        description.setText(p.getDescription());
        TextView price = (TextView) findViewById(R.id.priceTV);
        price.setText(p.getList_price() + "€");
        TextView volume = (TextView) findViewById(R.id.volumeTV);
        volume.setText("VOLUME\n"+p.getVolume());
        TextView weight = (TextView) findViewById(R.id.weightTV);
        weight.setText("WEIGHT\n"+p.getWeight());
        TextView active = (TextView) findViewById(R.id.activeTV);
        active.setText("ACTIVE\n"+p.isActive());
        if(p.isActive()){
            active.setBackgroundColor(Color.rgb(25, 178, 45));
        }else{
            active.setBackgroundColor(Color.rgb(253, 45, 0));
        }
        TextView published = (TextView) findViewById(R.id.publishedTV);
        published.setText("PUBLISHED\n"+p.isIs_published());
        if(p.isIs_published()){
            published.setBackgroundColor(Color.rgb(25, 178, 45));
        }else{
            published.setBackgroundColor(Color.rgb(253, 45, 0));
        }
        TextView quantity = (TextView) findViewById(R.id.quantityTV);
        quantity.setText("STOCK\n"+p.getStock());

        TextView sale_ok = (TextView) findViewById(R.id.sale_okTV);
        sale_ok.setText("ON SALE\n"+p.isSale_ok());
        if(p.isSale_ok()){
            sale_ok.setBackgroundColor(Color.rgb(25, 178, 45));
        }else{
            sale_ok.setBackgroundColor(Color.rgb(253, 45, 0));
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                y1 = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                y2 = event.getY();

                float valueX = x2 - x1;
                float valueY = y2 - y1;

                if(Math.abs(valueX) > MIN_DISTANCE){
                    if (x2>x1){

                        Log.i(TAG, "onTouchEvent: right");
                    }
                    else{

                        Log.i(TAG, "onTouchEvent: left");

                    }
                }else if(Math.abs(valueY) > MIN_DISTANCE){
                    if (y2>y1){

                        Log.i(TAG, "onTouchEvent: bottom");
                    }
                    else{

                        Log.i(TAG, "onTouchEvent: top");
                        finish();
                    }
                }

        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }
}