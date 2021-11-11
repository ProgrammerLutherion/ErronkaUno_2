package com.example.erronkatest;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistroData extends AppCompatActivity {

    String Title = "Registro de Usuarios";

    EditText Etusurname, EtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_data);

        this.setTitle(Title);

        Etusurname = (EditText) findViewById(R.id.editTextTextUserName);
        EtPass = (EditText) findViewById(R.id.editTextTextPassword);
    }

    public void RegistrarDataUser(View v) {
        DBHelper admin = new DBHelper(this, "Database", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String UserName = Etusurname.getText().toString();
        String PassUser = EtPass.getText().toString();
        ContentValues values = new ContentValues();
        values.put("username", UserName);
        values.put("clave_user", PassUser);
        db.insert("userstable", null, values);
        db.close();
        Toast ToastMens = Toast.makeText(this, "Usuario registrado", Toast.LENGTH_SHORT);
        ToastMens.show();
        Intent intent = new Intent(this, PrincipalMenu.class);
        startActivity(intent);
    }
}