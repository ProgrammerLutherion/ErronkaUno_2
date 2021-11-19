package com.example.erronkauno2_swipe.Fragments;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;

import com.example.erronkauno2_swipe.Async_Tasks.Produktuak_Async;
import com.example.erronkauno2_swipe.Classes.Product;
import com.example.erronkauno2_swipe.R;

import java.util.ArrayList;
import java.util.List;


public class Produktuak extends Fragment{

    public static List<Product> main_products;
    public static ArrayAdapter<String> adapter;
    Produktuak_Async produktuak_async;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.produktuak,container,false);

        produktuak_async = new Produktuak_Async(rootView);
        produktuak_async.execute();

        return rootView;
    }
}
