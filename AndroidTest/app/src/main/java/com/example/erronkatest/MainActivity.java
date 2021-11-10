package com.example.erronkatest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@SuppressLint("StaticFieldLeak")
public class MainActivity extends AppCompatActivity {

    private ListView lst_product;
    private SQLiteDatabase db;
    private String separadorea = ", ";

    private int ProdID;
    private String nameTxt;
    private String listPText;
    private String descTxt;
    private String volTxt;
    private String weightTxt;
    private String stockTxt;
    private String imagenTxt;
    private boolean saleB;
    private boolean activeBit;
    private boolean is_publi;

    List<Product> products = new ArrayList<>();
    String DB_URL = "jdbc:postgresql://192.168.65.21/ErronkaUno";
    String USER = "openpg";
    String PASS = "openpgpwd";
    String QUERY = "SELECT product_template.id, product_template.name, product_template.description_sale, product_template.list_price, product_template.volume, product_template.weight, SUM(stock_move.product_qty) - (select sum(stock_move.product_qty) from public.stock_move where stock_move.location_dest_id = 5 and stock_move.product_id = product_template.id) as stock,(select imagenes.imagen_hash from public.imagenes where imagenes.id_item = product_template.id) as imagen , product_template.sale_ok,product_template.is_published, product_template.active FROM public.product_template inner join stock_move on stock_move.product_id = product_template.id inner join imagenes on imagenes.id_item = product_template.id where stock_move.location_dest_id = 8 group by product_template.id";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            Class.forName("org.postgresql.Driver");
            java.sql.Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(QUERY);
                while (rs.next()) {
                    Log.i("TAG", "getArrayList: "+rs.getString("name"));
                    Product product = new Product(rs.getInt("id"),rs.getString("name"),rs.getString("description_sale"),rs.getString("list_price"),rs.getString("volume"),rs.getString("weight"),rs.getString("stock"),rs.getString("imagen"),rs.getBoolean("sale_ok"),rs.getBoolean("is_published"),rs.getBoolean("active"));
                    Intent login=new Intent(this, Login.class);
                    dataSartu(product);
                    startActivity(login);
                }

        } catch (SQLException | ClassNotFoundException e) {
            lst_product.setOnItemLongClickListener((AdapterView.OnItemLongClickListener) this);
            datuakErakutsi();
        }
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
        arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.activity_main, zerrenda);
        lst_product.setAdapter(arrayAdapter);
        cursor.close();
    }

    public void dataSartu(Product product){

        db = openOrCreateDatabase("Products Local Database", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS LocalDatabase(iD INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, name TEXT, list_price TEXT, description TEXT, " +
                "volume TEXT, weight TEXT, stock TEXT, imagen TEXT, sale_ok bit, active bit, is_published bit);");
        String insert_query = "INSERT INTO BaseDatuLokala( name, list_price, description, volume, weight, stock, imagen, sale_ok, active, is_published) " +
                "VALUES ('" + nameTxt + "','" + listPText + "','" + descTxt + "','" + volTxt + "','" + weightTxt + "','" + stockTxt + "','" + imagenTxt + "','" + saleB + "','" + activeBit + "','" + is_publi + "')";
        db.execSQL(insert_query);
    }

    @SuppressLint("Range")
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
