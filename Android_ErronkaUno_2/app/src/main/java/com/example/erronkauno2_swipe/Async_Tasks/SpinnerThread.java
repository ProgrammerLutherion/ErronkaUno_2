package com.example.erronkauno2_swipe.Async_Tasks;

import android.app.Activity;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.erronkauno2_swipe.Classes.Client;
import com.example.erronkauno2_swipe.Fragments.Fakturak;
import com.example.erronkauno2_swipe.Fragments.Produktuak;
import com.example.erronkauno2_swipe.MainActivity;
import com.example.erronkauno2_swipe.R;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SpinnerThread extends Thread {
    private String DB_URL = "jdbc:postgresql://192.168.65.21/ErronkaUno";
    private String USER = "openpg";
    private String PASS = "openpgpwd";
    private String QUERY = "SELECT res_partner.id, res_partner.name, res_partner.active FROM res_partner WHERE active = true";
    ArrayAdapter<String> adapter;
    ArrayList<Client> clients = new ArrayList<>();
    ArrayList<String> names = new ArrayList<>();
    Spinner sc;
    ViewGroup this_view;

    public SpinnerThread(ViewGroup this_view){
        this.this_view = this_view;
        sc = (Spinner) this_view.findViewById(R.id.spinnerPersona);
    }

    public void run(){
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            try{
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(QUERY);
                while (rs.next()) {
                    Client client = new Client(rs.getInt("id"), rs.getString("name"), rs.getBoolean("active"));
                    Log.i("TAG", "run: "+rs.getString("name"));
                    insertClient(client);
                    insertName(client);
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        Fakturak.adapterPersona = adapter;
        Fakturak.main_clients = clients;
        /*adapter = new ArrayAdapter<>(this_view.getContext(), android.R.layout.simple_spinner_item, names);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);*/


    }
    public void insertName(Client client){
        names.add(client.getName());
    }
    public void insertClient(Client client){
        clients.add(client);
    }
}


