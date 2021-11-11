package com.example.erronkatest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context, @Nullable String name,
                    @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table userstable(id_user integer  PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "username text NOT NULL,clave_user text NOT NULL)");

        db.execSQL("insert into userstable(username,clave_user) values('admin','admin')");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("create table userstable(id_user integer  PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "username text NOT NULL,clave_user text NOT NULL)");

        db.execSQL("insert into userstable(username,clave_user) values('admin','admin')");
    }}
