package com.example.erronkauno2_swipe.Async_Tasks;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.erronkauno2_swipe.Classes.Client;
import com.example.erronkauno2_swipe.Classes.Factura;
import com.example.erronkauno2_swipe.Classes.Product;
import com.example.erronkauno2_swipe.Fragments.Fakturak;
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

@SuppressLint("StaticFieldLeak")
public class Fakturak_Async extends AsyncTask< Void ,Void ,ListView > {
    ListView lv;
    ArrayAdapter<String> adapter;
    List<Factura> fakturak = new ArrayList<>();
    String DB_URL = "jdbc:postgresql://192.168.65.21/ErronkaUno";
    String USER = "openpg";
    String PASS = "openpgpwd";
    String QUERY = "select sale_order.name,sale_order.partner_id ,sale_order_line.product_id ,sale_order_line.price_total ,sale_order.amount_total ,sale_order_line.product_uom_qty from sale_order_line inner join sale_order on sale_order_line.order_id = sale_order.id";

    ViewGroup this_view;
    ArrayList<Factura> result = new ArrayList<>();
    ArrayList<String> names = new ArrayList<>();

    public Fakturak_Async(ViewGroup this_view)
    {
        this.this_view = this_view;
    }

    @Override
    protected ListView doInBackground(Void... voids) {
        try{
            getArrayList();
            Fakturak.fakturak = fakturak;
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
        /*listview.setOnItemClickListener((adapterView, view, i, l) -> {
            for (Factura a:fakturak) {
                if (a.getName().equals(adapter.getItem(i))){
                    Intent datos = new Intent(this_view.getContext(), Produktua_Details.class);
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
        });*/
        Fakturak.adapter = adapter;
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

    private void insert(Factura factura) {
        fakturak.add(factura);
    }

    private void getNames(){
        for(Factura faktu : fakturak){
            names.add(faktu.getName());
        }
    }

    public void hacerSQL(Connection conn,String QUERY){
        try{
            Statement stmt = conn.createStatement();
            ResultSet  rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                // Retrieve by column name
                Factura faktura = new Factura(rs.getString("name"),intToClient(rs.getInt("partner_id"),conn),intToListProduct(rs.getInt("product_id"),conn),rs.getFloat("price_total"),rs.getFloat("amount_total"),rs.getInt("product_uom_qty"));
                Log.i("TAG", "hacerSQL: "+rs.getString("name"));
                insert(faktura);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Client intToClient(int numero,Connection conn){
        for (Client cli:Fakturak.main_clients) {
            if (cli.getID() == numero){
                return cli;
            }
        }
        return null;
    }

    public List<Product> intToListProduct(int numero,Connection conn){
        String query = "select sale_order_line.product_id from sale_order_line where sale_order_line.order_id = "+numero;
        List<Product> listaProductos = new ArrayList<>();
        try{
            Statement stmt = conn.createStatement();
            ResultSet  rs = stmt.executeQuery(query);
            while (rs.next()) {

                for (Product i:Produktuak.main_products) {
                    if(i.getID() == rs.getInt("product_id")){
                        listaProductos.add(i);
                    }
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listaProductos;
    }

}
