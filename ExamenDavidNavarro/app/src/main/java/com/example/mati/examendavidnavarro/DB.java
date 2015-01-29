package com.example.mati.examendavidnavarro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DB extends SQLiteOpenHelper {
    String sql = "CREATE TABLE dbzona (codigo INTEGER PRIMARY KEY AUTOINCREMENT, zona TEXT, costeFinal REAL)";

    public DB(Context contexto, String nombre, CursorFactory almacen, int version){
        super(contexto, nombre, almacen, version);
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {

        bd.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int versionAnterior, int versionNueva) {

        bd.execSQL("DROP TABLE IF EXISTS dbzona");

        bd.execSQL(sql);
    }
}
