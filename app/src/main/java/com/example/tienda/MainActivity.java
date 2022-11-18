package com.example.tienda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView lista;

    String [][] datos = {
            {"Casco de Star Wars","100000","El casco de strom tropper para hijdf"},
            {"Juguete de Sonic","100000","El casco de strom tropper para hijdf"}
    };
    int[] datosImg = {R.drawable.producto1,R.drawable.producto2,R.drawable.producto3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = (ListView) findViewById(R.id.lista);
        lista.setAdapter(new Adaptador(this, datos, datosImg));

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent visorDetalles = new Intent(view.getContext(),Detalles_Producto.class);
                visorDetalles.putExtra("TIT", datos[i][0]);
                visorDetalles.putExtra("DET",datos[i][2]);
                startActivity(visorDetalles);
            }
        });
    }
}