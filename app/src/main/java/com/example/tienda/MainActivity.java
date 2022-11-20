package com.example.tienda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ListView lista;

    String[][] datos = {
            {"Casco de Star Wars", "100000", "El casco de strom tropper para hijdf"},
            {"Control", "100000", "El casco de storm tropper para hijdf"},
            {"Juguete de Sonic", "100000", "El casco de strom tropper para hijdf"}
    };
    int[] datosImg = {R.drawable.producto1, R.drawable.producto2, R.drawable.producto3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = (ListView) findViewById(R.id.lista);
        lista.setAdapter(new Adaptador(this, datos, datosImg));

        lista.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent visorDetalles = new Intent(view.getContext(), Detalles_Producto.class);
            visorDetalles.putExtra("TIT", datos[i][0]);
            visorDetalles.putExtra("DET", datos[i][2]);
            startActivity(visorDetalles);


        });

    }
    public void loguin (View view){
        Intent i = new Intent(this, login.class);
        startActivity(i);
    }

}

