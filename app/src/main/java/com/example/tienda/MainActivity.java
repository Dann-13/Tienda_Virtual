package com.example.tienda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView lista;

    String [][] datos = {
            {"Casco de Star Wars","100000","El casco de strom tropper para hijdf"},
            {"Control","100000","El casco de strom tropper para hijdf"},
            {"Juguete de Sonic","100000","El casco de strom tropper para hijdf"}
    };
    int[] datosImg = {R.drawable.producto1,R.drawable.producto2,R.drawable.producto3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = (ListView) findViewById(R.id.lista);
        lista.setAdapter(new Adaptador(this, datos, datosImg));
    }
}