package com.example.sqlite;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button bt=null, bt1=null, bt2=null,bt3=null;
    private EditText edit1 , edit2, edit3;
    Mi_DB mi_bd;
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        references();

         mi_bd = new Mi_DB(this, "Mi_DB", null, 1);
    }

    public void references(){
        //  et1=(TextView) findViewById(R.id.textView2);
        bt=(Button)findViewById(R.id.insertar);
        bt1=(Button)findViewById(R.id.buscar);
        bt3=(Button)findViewById(R.id.eliminar);
edit1= (EditText)findViewById(R.id.editTextName);
        edit2= (EditText)findViewById(R.id.editTextDNI);
        edit3= (EditText)findViewById(R.id.DNIeliminar);



    }

    public void insertarBD(View view){
String _nombre = edit1.getText().toString();
        String _dni = edit2.getText().toString();

        int _res = mi_bd.insertar(_nombre, _dni); // se envian los datos para insertar
        if(_res == 1){
            builder.setTitle("Insertar en BD");
            builder.setMessage("Insertado");
            builder.setPositiveButton("Aceptar", null);

            AlertDialog dialog = builder.create();
            dialog.show(); }
        else{ builder.setTitle("Insertar en BD");
            builder.setMessage("No insertado");
            builder.setPositiveButton("Aceptar", null);

            AlertDialog dialog = builder.create();
            dialog.show(); }
    }

    public void buscarBD(View view){




    }
    public void eliminarBD(View view){
        String _dni = edit3.getText().toString();

        int _res = mi_bd.eliminar(_dni); //borrar el registro con dni
        if(_res==0) { /*"Nose ha podido borrar el dato“ */ }
        else {/* se ha Eliminado correctamente */ }

    }


}



