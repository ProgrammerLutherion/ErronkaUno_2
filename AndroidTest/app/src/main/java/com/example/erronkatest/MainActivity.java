package com.example.erronkatest;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.PopupWindow;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("StaticFieldLeak")
public class MainActivity extends AppCompatActivity {
    static ArrayList<Client> main_clients = new ArrayList<>();
    static List<Product> main_products = new ArrayList<>();
    static ArrayAdapter<String> adapter;
    Requester req;
    Facturador fac;
    static ArrayAdapter<String> adapterPersona;
    Spinner personaSpinner;
    Spinner productoSpinner;
    NumberPicker numberPicker;
    Button sendButton;
    TextView total_price_text;
    Float total_price;
    Integer amount;
    Factura factura;

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
                total_price_text = bottomSheetView.findViewById(R.id.final_price);
                personaSpinner = bottomSheetView.findViewById(R.id.spinnerPersona);
                personaSpinner.setAdapter(adapterPersona);
                productoSpinner = bottomSheetView.findViewById(R.id.spinnerProducto);
                productoSpinner.setAdapter(adapter);
                numberPicker = bottomSheetView.findViewById(R.id.numberPicker);
                numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                    @Override
                    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                        setPrice(newVal,getProductoByName(productoSpinner.getSelectedItem().toString()));
                    }
                });
                productoSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        if(getMaxValue(productoSpinner.getSelectedItem().toString()) > 0){
                            amount = 1;
                            numberPicker.setMinValue(1);
                            numberPicker.setMaxValue(getMaxValue(productoSpinner.getSelectedItem().toString()));
                        }else{
                            amount = 0;
                            numberPicker.setMinValue(0);
                            numberPicker.setMaxValue(0);
                        }
                        setPrice(amount,getProductoByName(productoSpinner.getSelectedItem().toString()));
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                sendButton = bottomSheetView.findViewById(R.id.sendButton);
                sendButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        factura = new Factura(getClientByName(personaSpinner.getSelectedItem().toString()),getProductoByName(productoSpinner.getSelectedItem().toString()),amount,total_price);
                        Log.i("TAG", "onClick: "+factura);
                        fac = new Facturador(MainActivity.this);
                        fac.execute(factura);
                    }
                });


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

    private Product getProductoByName(String name){
        for(Product i: main_products){
            if(name.equals(i.getName())){
                return i;
            }
        }
        return null;
    }

    private Client getClientByName(String name){
        for(Client i: main_clients){
            if(name.equals(i.getName())){
                return i;
            }
        }
        return null;
    }

    private void setPrice(int cantidad,Product producto){
        amount = cantidad;
        total_price = cantidad * (float) Float.parseFloat(producto.list_price);
        total_price_text.setText(String.format("Precio final:%.2f",total_price,"€"));
    }

    private int getMaxValue(String name){
        for(Product i : main_products){
            if(name.equals(i.getName())){
                Log.i("parseint", "getMaxValue: "+(int)(Math.round(Float.parseFloat(i.getStock())))) ;
                return (int)(Math.round(Float.parseFloat(i.getStock())));
            }
        }
        return 0;
    }

}
