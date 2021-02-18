package com.example.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Mi_DB extends SQLiteOpenHelper {

    String SQLiteCreate = "CREATE TABLE Usuarios (DNI TEXT PRIMARY KEY, nombre TEXT)";

    public Mi_DB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLiteCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public String buscar(String dni) {
        SQLiteDatabase descp_busc;
        descp_busc = this.getReadableDatabase();
        String[] campos = new String[]{"nombre"};
        String[] argumentos = new String[]{dni};

        Cursor res = descp_busc.query("Usuarios", campos, "DNI = ?", argumentos, null, null, null);

        if (res.getCount() >= 1) {
            res.moveToNext();
            String _sol = res.getString(0);
            return _sol;
        } else {
            return "no encontrado";
        }


    }

    public int insertar(String nombre, String Dni) {

        SQLiteDatabase desc_ins;
        SQLiteDatabase desc_busc;

        desc_ins = this.getWritableDatabase();
        desc_busc = this.getReadableDatabase();
        String cad = "INSERT INTO Usuarios VALUES ('" + Dni + "' , '" + nombre + "')";
        boolean unico = true;

        try {
            desc_ins.execSQL(cad);
        } catch (Exception e) {
            e.getStackTrace();
            unico = false;
        }
        String[] campos = new String[]{"DNI", "nombre"};
        String[] argumentos = new String[]{Dni};

        Cursor _res = desc_busc.query("Usuarios", campos, "DNI = ?", argumentos, null, null, null);

        int i = _res.getCount();
        desc_ins.close();
        desc_busc.close();
        System.out.println("Usuarios actuales con dicho DNI: " + i);
        if (!unico) {
            return -1;
        } else if (i == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    public int eliminar(String dni){
        SQLiteDatabase descp_del;
        descp_del = this.getWritableDatabase();
        String[] val = new String[] {dni};

        int sol = descp_del.delete("Usuarios", "DNI=?", val);
        return sol;
    }
    
    

}
