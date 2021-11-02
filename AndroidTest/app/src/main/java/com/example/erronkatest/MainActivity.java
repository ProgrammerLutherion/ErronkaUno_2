package com.example.erronkatest;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SearchView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("StaticFieldLeak")
public class MainActivity extends AppCompatActivity {
    ArrayList<Product> result = new ArrayList<>();
    ArrayList<String> names = new ArrayList<>();
    static ArrayAdapter<String> adapter;
    Requester req;
    static ArrayAdapter<String> adapterPersona;
    Spinner personaSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        req =  new Requester(this);
        req.execute();
        SpinnerThread t1 = new SpinnerThread(MainActivity.this);
        t1.start();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_op,menu);
        MenuItem menuItem = menu.findItem(R.id.nav_search);
        MenuItem crearFactura = menu.findItem(R.id.crearFactura);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Buscar...");

        crearFactura.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public boolean onMenuItemClick(MenuItem item) {// inflate the layout of the popup window

                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                        MainActivity.this,R.style.BottomSheetDialogTheme
                );
                View bottomSheetView = LayoutInflater.from(getApplicationContext())
                        .inflate(
                                R.layout.create_product,

                                (LinearLayout)findViewById(R.id.bottomSheetContainer)
                        );
                personaSpinner = bottomSheetView.findViewById(R.id.spinnerPersona);
                personaSpinner.setAdapter(adapterPersona);
                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();
            return false;
            }
        });


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


}
