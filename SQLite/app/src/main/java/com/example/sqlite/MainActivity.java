package com.example.sqlite;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener {

    //datu base deklarazioa
    private String nameTxt = "";
    private String listPText = "";
    private String descTxt = "";
    private String volTxt = "";
    private String weightTxt = "";
    private String stockTxt ="";
    private String imagenTxt ="";
    private boolean saleB;
    private boolean activeBit;
    private boolean is_publi;

    //aldagaiak datubasea
    private SQLiteDatabase db;
    private String separadorea = ", ";
    private ListView lst_diskak;

    //lerro
    private int posicion;

    private static final int REQUEST_CODE_PERMISSIONS = 1;
    private static boolean BAIMENAK = false;

    public MainActivity() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zerrenda_lerroa);

        while (!BAIMENAK) {
            baimenak_eskatu();
        }
        if (BAIMENAK) {
            lst_diskak.setOnItemLongClickListener(this);

            dataSartu();
            }
        else{
            datuakErakutsi();
        }
    }

    private void baimenak_eskatu() {
        if (ContextCompat.checkSelfPermission(
                getApplicationContext(),
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(
                        getApplicationContext(),
                        Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {
            // Baimenak falta dira, eskatu egingo dizkiogu erabiltzaileari
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION
                    },
                    REQUEST_CODE_PERMISSIONS);
        } else {
            // Dagoeneko baditugu behar ditugun baimen guztiak
            BAIMENAK = true;
        }
    }

    // Baimenak eskatzearen erantzuna jasotakoan metodo hau exekutatuko da
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_PERMISSIONS && grantResults.length > 0) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                // Dagoeneko baditugu behar ditugun baimen guztiak
                BAIMENAK = true;
            } else {
                Toast.makeText(this, "Baimenak falta diraaa!!", Toast.LENGTH_LONG).show();
                // Ez dauzkagu behar ditugun baimen guztiak
                BAIMENAK = false;
            }
        }
    }

    public void dataSartu(){

        db = openOrCreateDatabase("Products Base Datu Lokala", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS BaseDatuLokala(iD INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, name TEXT, list_price TEXT, description TEXT, " +
                "volume TEXT, weight TEXT, stock TEXT, imagen TEXT, sale_ok bit, active bit, is_published bit);");
        String insert_query = "INSERT INTO BaseDatuLokala( name, list_price, description, volume, weight, stock, imagen, sale_ok, active, is_published) " +
                "VALUES ('" + nameTxt + "','" + listPText + "','" + descTxt + "','" + volTxt + "','" + weightTxt + "','" + stockTxt + "','" + imagenTxt + "','" + saleB + "','" + activeBit + "','" + is_publi + "')";
        db.execSQL(insert_query);
    }

    public void datuakErakutsi(){
        ArrayAdapter<String> arrayAdapter;
        List<String> zerrenda = new ArrayList<String>();
        Cursor cursor = db.rawQuery("SELECT iD , name, list_price, description, volume, weight, stock, imagen, sale_ok, active, is_published FROM BaseDatuLokala", null);
        if(cursor.getCount()==0) {
            zerrenda.add("Ez dago edukirik datu basean");
        }
        else{
            while(cursor.moveToNext()) {
                zerrenda.add(cursor.getString(0) + separadorea + cursor.getString(1) + separadorea + cursor.getString(2));
            }
        }
        arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.zerrenda_lerroa, zerrenda);
        lst_diskak.setAdapter(arrayAdapter);
        cursor.close();
    }

    @SuppressLint("Range")
    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int posicion, long iD) {
        posicion = posicion + 1;

        try (Cursor cursor = db.rawQuery("name, list_price, description, volume, weight, stock, imagen, sale_ok, active, is_published FROM BaseDatuLokala WHERE iD = '" + posicion + "'", null)) {
            if (cursor.moveToFirst()) {
                nameTxt = String.valueOf(cursor.getString(cursor.getColumnIndex("name")));
                listPText = String.valueOf(cursor.getString(cursor.getColumnIndex("list")));
                descTxt = String.valueOf(cursor.getString(cursor.getColumnIndex("description")));
                volTxt = String.valueOf(cursor.getString(cursor.getColumnIndex("volume")));
                weightTxt = String.valueOf(cursor.getString(cursor.getColumnIndex("weight")));
                stockTxt = String.valueOf(cursor.getString(cursor.getColumnIndex("stock")));
                imagenTxt = String.valueOf(cursor.getString(cursor.getColumnIndex("imagen")));
                saleB = Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex("sale_ok")));
                activeBit = Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex("active")));
                is_publi = Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex("is_published")));
            }
        }

        Toast.makeText(this,  nameTxt +" , "+ listPText +" , " + descTxt + " , " + volTxt + " ," + weightTxt + " ," + stockTxt + " ," + imagenTxt + " ," + saleB + " ," + activeBit + " ," + is_publi + " ,", Toast.LENGTH_LONG).show();
        return false;
    }
}