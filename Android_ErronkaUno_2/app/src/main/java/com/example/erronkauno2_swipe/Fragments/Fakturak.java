package com.example.erronkauno2_swipe.Fragments;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.erronkauno2_swipe.Async_Tasks.Faktura_Sortu;
import com.example.erronkauno2_swipe.Async_Tasks.Fakturak_Async;
import com.example.erronkauno2_swipe.Async_Tasks.Produktuak_Async;
import com.example.erronkauno2_swipe.Async_Tasks.SpinnerThread;
import com.example.erronkauno2_swipe.Classes.Client;
import com.example.erronkauno2_swipe.Classes.Factura;
import com.example.erronkauno2_swipe.Classes.Product;
import com.example.erronkauno2_swipe.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Fakturak extends Fragment{
    public static List<Factura> fakturak;
    public static ArrayAdapter<String> adapterPersona;
    public static ArrayList<Client> main_clients;
    public static ArrayAdapter<String> adapter;


    Spinner personaSpinner;
    Spinner productoSpinner;
    NumberPicker numberPicker;
    Button sendButton;
    TextView total_price_text;
    Float total_price;
    Integer amount;
    Fakturak_Async fakturak_async;
    Factura factura;
    Faktura_Sortu fac;
    ViewGroup rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(R.layout.fakturak,container,false);
        buttonConfig();

        SpinnerThread t1 = new SpinnerThread(rootView);
        t1.start();

        fakturak_async = new Fakturak_Async(rootView);
        fakturak_async.execute();

        return rootView;
    }

    private void buttonConfig() {
        FloatingActionButton create_factura = (FloatingActionButton) rootView.findViewById(R.id.crear_facturas);

        create_factura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                        rootView.getContext(), R.style.BottomSheetDialogTheme
                );
                View bottomSheetView = LayoutInflater.from(rootView.getContext())
                        .inflate(
                                R.layout.create_product,

                                (LinearLayout) rootView.findViewById(R.id.bottomSheetContainer)
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
                        setPrice(newVal, getProductoByName(productoSpinner.getSelectedItem().toString()));
                    }
                });
                productoSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        if (getMaxValue(productoSpinner.getSelectedItem().toString()) > 0) {
                            amount = 1;
                            numberPicker.setMinValue(1);
                            numberPicker.setMaxValue(getMaxValue(productoSpinner.getSelectedItem().toString()));
                        } else {
                            amount = 0;
                            numberPicker.setMinValue(0);
                            numberPicker.setMaxValue(0);
                        }
                        setPrice(amount, getProductoByName(productoSpinner.getSelectedItem().toString()));
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                sendButton = bottomSheetView.findViewById(R.id.sendButton);
                sendButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        factura = new Factura(getClientByName(personaSpinner.getSelectedItem().toString()), getProductoByName(productoSpinner.getSelectedItem().toString()), amount, total_price);
                        Log.i("TAG", "onClick: " + factura);

                        fac = new Faktura_Sortu(rootView);
                        fac.execute(factura);


                    }
                });



                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();
            }
        });
    }

    private void setPrice(int cantidad, Product producto) {
        amount = cantidad;
        total_price = cantidad * (float) Float.parseFloat(producto.getList_price());
        total_price_text.setText(String.format("Precio final:%.2f", total_price, "€"));
    }

    private int getMaxValue(String name) {
        for (Product i : Produktuak.main_products) {
            if (name.equals(i.getName())) {
                Log.i("parseint", "getMaxValue: " + (int) (Math.round(Float.parseFloat(i.getStock()))));
                return (int) (Math.round(Float.parseFloat(i.getStock())));
            }
        }
        return 0;
    }

    private Product getProductoByName(String name) {
        for (Product i : Produktuak.main_products) {
            if (name.equals(i.getName())) {
                return i;
            }
        }
        return null;
    }

    private Client getClientByName(String name) {
        for (Client i : main_clients) {
            if (name.equals(i.getName())) {
                return i;
            }
        }
        return null;
    }
}