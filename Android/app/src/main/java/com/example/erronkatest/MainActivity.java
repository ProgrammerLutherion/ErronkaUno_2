package com.example.erronkatest;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("StaticFieldLeak")
public class MainActivity extends AppCompatActivity {
    ArrayList<com.example.erronkatest.Product> result = new ArrayList<>();
    ArrayList<String> names = new ArrayList<>();
    static ArrayAdapter<String> adapter;
    com.example.erronkatest.Requester req;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        req =  new Requester(this);
        req.execute();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_op,menu);
        MenuItem menuItem = menu.findItem(R.id.nav_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Buscar...");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query){
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText){
                adapter.getFilter().filter(newText);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    /*public ArrayList<String> irakurri() {
        ArrayList<String> listaDatuak = new ArrayList<>();
        BufferedReader bufferLectura = null;
        try {
            InputStream is = getResources().openRawResource(R.raw.products);
            bufferLectura = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String linea = bufferLectura.readLine();
            while (linea != null) {
                listaDatuak.add(linea);
                linea = bufferLectura.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferLectura != null) {
                try {
                    bufferLectura.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return listaDatuak;
    }*/

    /*public void aldatzailea(){
       ArrayList<String> produktuak = irakurri();
        for (String produktu : produktuak) {
            String[] produktuak_aldatuta = produktu.split("[|]", 0);
            Product p = new Product(Integer.parseInt(produktuak_aldatuta[0]),
                    produktuak_aldatuta[1], produktuak_aldatuta[2], produktuak_aldatuta[3],
                    produktuak_aldatuta[4], produktuak_aldatuta[5],produktuak_aldatuta[6],
                    produktuak_aldatuta[7], Boolean.parseBoolean(produktuak_aldatuta[8]),
                    Boolean.parseBoolean(produktuak_aldatuta[9]), Boolean.parseBoolean(produktuak_aldatuta[10]));
            result.add(p);
            names.add(produktuak_aldatuta[1]);
        }
    }*/

}
