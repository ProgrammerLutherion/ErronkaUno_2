package com.example.erronkatest;

import android.app.Activity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

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
    Activity mainact1;

    public SpinnerThread(Activity mainact){
        mainact1 = mainact;
        sc = (Spinner) mainact.findViewById(R.id.spinnerPersona);
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
        adapter = new ArrayAdapter<>(mainact1.getApplicationContext(), android.R.layout.simple_spinner_item, names);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        PrincipalMenu.adapterPersona = adapter;
        PrincipalMenu.main_clients = clients;

    }
    public void insertName(Client client){
        names.add(client.getName());
    }
    public void insertClient(Client client){
        clients.add(client);
    }
}


