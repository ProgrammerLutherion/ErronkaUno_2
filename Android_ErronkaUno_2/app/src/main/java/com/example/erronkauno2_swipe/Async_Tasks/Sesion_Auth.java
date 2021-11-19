package com.example.erronkauno2_swipe.Async_Tasks;

import android.util.Log;

import com.example.erronkauno2_swipe.Classes.Client;
import com.example.erronkauno2_swipe.Login.Login;
import com.example.erronkauno2_swipe.Login.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Sesion_Auth extends Thread{
    String DB_URL = "jdbc:postgresql://192.168.65.21/ErronkaUno";
    String USER = "openpg";
    String PASS = "openpgpwd";
    String QUERY = "SELECT res_users.id, res_users.login, user_auth.password_sha256, res_users.active FROM res_users INNER JOIN user_auth ON res_users.id = user_auth.id WHERE active = true";
    ArrayList<User> this_users = new ArrayList<>();
    @Override
    public void run() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            try{
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(QUERY);
                while (rs.next()) {
                    User newuser = new User(rs.getInt("id"), rs.getString("login"), rs.getString("password_sha256"));
                    this_users.add(newuser);

                }
                Log.i("users", "run: "+this_users.toString());
                Login.users = this_users;
            }catch (Exception e){
                e.printStackTrace();
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
