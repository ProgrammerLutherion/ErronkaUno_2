package com.example.erronkauno2_swipe.Login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.erronkauno2_swipe.Async_Tasks.Sesion_Auth;
import com.example.erronkauno2_swipe.MainActivity;
import com.example.erronkauno2_swipe.R;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity{
    EditText et1,et2;
    String Title = "Inicio de Sesión";
    String DB_URL = "jdbc:postgresql://192.168.65.21/ErronkaUno";
    String USER = "openpg";
    String PASS = "openpgpwd";
    String QUERY = "SELECT res_users.id, res_users.login, user_auth.password_sha256 FROM res_users INNER JOIN user_auth ON res_users.id = user_auth.id WHERE active = true";
    public static ArrayList<User> users = new ArrayList<>();
    Sesion_Auth sesion_auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sesion_auth = new Sesion_Auth();
        setContentView(R.layout.login);
        this.setTitle(Title);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Button ingresar = (Button) findViewById(R.id.button);
        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    InicioSesion();
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
            }
        });
        et1= (EditText) findViewById(R.id.etusuario);
        et2= (EditText) findViewById(R.id.edtclave);
    }


    public void InicioSesion() throws NoSuchAlgorithmException {
        sesion_auth.start();
        String usuario=et1.getText().toString();
        String passwordtxt=et2.getText().toString();
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(passwordtxt.getBytes(StandardCharsets.UTF_8));
        String passwordhash = bytesToHex(encodedhash);

            for(User user : users){
                Log.i("asdasdasdasdasd", "InicioSesion: "+user.login);
                if(usuario.equals(user.getLogin())){
                    if(passwordhash.equals(user.password)){
                        Intent ven=new Intent(this, MainActivity.class);
                        startActivity(ven);
                        et1.setText("");
                        et2.setText("");
                    }
                }else{
                    Toast toast=Toast.makeText(this,"Datos incorrectos",Toast.LENGTH_LONG);
                    toast.show();
                }
            }
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }


    public void RegistroData(View v){
        Intent rdata=new Intent(this, RegistroData.class);
        startActivity(rdata);
    }
}