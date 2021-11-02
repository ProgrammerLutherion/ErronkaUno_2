package com.example.erronkatest;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

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
    private String QUERY = "SELECT res_partner.id, res_partner.name, res_partner.active  FROM res_partner";
    ArrayAdapter<String> adapter;
    ArrayList<Client> clients = new ArrayList<>();
    ArrayList<String> names = new ArrayList<>();

    public SpinnerThread(Activity mainact){
        adapter = new ArrayAdapter<>(mainact.getApplicationContext(), android.R.layout.simple_list_item_1, names);
    }

    public void run(){
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            try{
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(QUERY);
                while (rs.next()) {
                    // Retrieve by column name
                    Client client = new Client(rs.getInt("id"), rs.getString("name"), rs.getBoolean("active"));
                    insertClient(client);
                    insertName(client);
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        Spinner sc = (Spinner) findViewById(R.id.spinnerPersona);
        sc.setAdapter(adapter);

    }
    public void insertName(Client client){
        names.add(client.getName());
    }
    public void insertClient(Client client){
        clients.add(client);
    }
}


