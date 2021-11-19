package com.example.erronkauno2_swipe.Async_Tasks;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.erronkauno2_swipe.Classes.Product;
import com.example.erronkauno2_swipe.Fragments.Produktuak;
import com.example.erronkauno2_swipe.R;
import com.example.erronkauno2_swipe.Secondaries.Produktua_Details;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import android.database.sqlite.SQLiteDatabase;

@SuppressLint("StaticFieldLeak")
public class Produktuak_Async extends AsyncTask< Void ,Void ,ListView > {
    ListView lv;
    ArrayAdapter<String> adapter;
    List<Product> products = new ArrayList<>();
    String DB_URL = "jdbc:postgresql://192.168.65.21/ErronkaUno";
    String USER = "openpg";
    String PASS = "openpgpwd";
    String QUERY = "SELECT product_template.id, product_template.name, product_template.description_sale, product_template.list_price, product_template.volume, product_template.weight, SUM(stock_move.product_qty) - (select sum(stock_move.product_qty) from public.stock_move where stock_move.location_dest_id = 5 and stock_move.product_id = product_template.id) as stock,(select imagenes.imagen_hash from public.imagenes where imagenes.id_item = product_template.id) as imagen , product_template.sale_ok,product_template.is_published, product_template.active FROM public.product_template inner join stock_move on stock_move.product_id = product_template.id inner join imagenes on imagenes.id_item = product_template.id where stock_move.location_dest_id = 8 group by product_template.id";

    private SQLiteDatabase db;

    ViewGroup this_view;
    ArrayList<Product> result = new ArrayList<>();
    ArrayList<String> names = new ArrayList<>();

    public Produktuak_Async(ViewGroup this_view)
    {
        this.this_view = this_view;
    }

    @Override
    protected ListView doInBackground(Void... voids) {
        try{
            getArrayList();
            Produktuak.main_products = products;
            getNames();
            return lv;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    protected void onPostExecute(ListView listview) {
        listview = (ListView) this_view.findViewById(R.id.tv_emptyTextView);
        adapter = new ArrayAdapter<>(this_view.getContext(), android.R.layout.simple_list_item_1, names);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener((adapterView, view, i, l) -> {
            for (Product a:products) {
                if (a.getName().equals(adapter.getItem(i))){
                    Intent datos = new Intent(this_view.getContext(), Produktua_Details.class);
                    datos.putExtra("id",a.getID()+"");
                    datos.putExtra("name",a.getName());
                    datos.putExtra("list_price",a.getList_price());
                    datos.putExtra("description",a.getDescription());
                    datos.putExtra("volume",a.getVolume());
                    datos.putExtra("weight",a.getWeight());
                    datos.putExtra("stock",a.getStock());
                    datos.putExtra("imagen",a.getImagen());
                    datos.putExtra("sale_ok",a.isSale_ok()+"");
                    datos.putExtra("active",a.isActive()+"");
                    datos.putExtra("published",a.isIs_published()+"");
                    this_view.getContext().startActivity(datos);
                }
            }
        });
        Produktuak.adapter = adapter;
    }


    private void getArrayList(){
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            hacerSQL(conn,QUERY);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void insert(Product product) {
        products.add(product);
    }

    private void getNames(){
        for(Product prod : products){
            names.add(prod.getName());
        }
    }

    public void hacerSQL(Connection conn,String QUERY){
        try{
            Statement stmt = conn.createStatement();
            ResultSet  rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                // Retrieve by column name
                Log.i("TAG", "getArrayList: "+rs.getString("name"));
                Product product = new Product(rs.getInt("id"),rs.getString("name"),rs.getString("description_sale"),rs.getString("list_price"),rs.getString("volume"),rs.getString("weight"),rs.getString("stock"),rs.getString("imagen"),rs.getBoolean("sale_ok"),rs.getBoolean("is_published"),rs.getBoolean("active"));
                dataSartu(product);
                insert(product);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void dataSartu(Product product){
        db = this_view.getContext().openOrCreateDatabase("Products Local Database", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS BaseDatuLokala(iD INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, name TEXT, list_price TEXT, description TEXT, " +
                "volume TEXT, weight TEXT, stock TEXT, imagen TEXT, sale_ok bit, active bit, is_published bit);");
        String insert_query = "INSERT INTO BaseDatuLokala( name, list_price, description, volume, weight, stock, imagen, sale_ok, active, is_published) " +
                "VALUES ('" + product.getName() + "','" + product.getList_price() + "','" + product.getDescription() + "','" + product.getVolume() + "','" + product.getWeight() + "','" + product.getStock() + "','" + product.getImagen() + "','" + product.isSale_ok() + "','" + product.isActive() + "','" + product.isIs_published() + "')";
        db.execSQL(insert_query);
    }
}
