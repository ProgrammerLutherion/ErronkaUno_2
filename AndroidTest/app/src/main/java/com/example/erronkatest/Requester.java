package com.example.erronkatest;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@SuppressLint("StaticFieldLeak")
public class Requester extends AsyncTask< Void ,Void ,ListView > {
    ListView lv;
    ArrayAdapter<String> adapter;
    List<Product> products = new ArrayList<>();
    String DB_URL = "jdbc:postgresql://192.168.65.21/ErronkaUno";
    String USER = "openpg";
    String PASS = "openpgpwd";
    String QUERY = "SELECT product_template.id, product_template.name, product_template.description_sale, product_template.list_price, product_template.volume, product_template.weight, SUM(stock_move.product_qty) - (select sum(stock_move.product_qty) from public.stock_move where stock_move.location_dest_id = 5 and stock_move.product_id = product_template.id) as stock,(select imagenes.imagen_hash from public.imagenes where imagenes.id_item = product_template.id) as imagen , product_template.sale_ok,product_template.is_published, product_template.active FROM public.product_template inner join stock_move on stock_move.product_id = product_template.id inner join imagenes on imagenes.id_item = product_template.id where stock_move.location_dest_id = 8 group by product_template.id";



    Activity mainact;
    ArrayList<Product> result = new ArrayList<>();
    ArrayList<String> names = new ArrayList<>();

    public Requester(Activity niremainact)
    {
        mainact = niremainact;
    }

    @Override
    protected ListView doInBackground(Void... voids) {
        try{
            getArrayList();
            getNames();
            return lv;
        }catch (Exception e){
            return null;
        }

    }


    @Override
    protected void onPostExecute(ListView listview) {
        listview = (ListView) mainact.findViewById(R.id.tv_emptyTextView);
        adapter = new ArrayAdapter<>(mainact.getApplicationContext(), android.R.layout.simple_list_item_1, names);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener((adapterView, view, i, l) -> {
            for (Product a:products) {
                if (a.getName().equals(adapter.getItem(i))){
                    Intent datos = new Intent(mainact, MainActivity2.class);
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
                    mainact.startActivity(datos);
                }
            }
        });
        MainActivity.adapter = adapter;
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
                        insert(product);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
    }
}
