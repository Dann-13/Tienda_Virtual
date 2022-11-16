package com.example.tienda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Detalles_Producto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_producto);

        TextView titulo = (TextView) findViewById(R.id.tvTitulo_Descripcion);
        TextView detalles = (TextView) findViewById(R.id.tvDescripccion);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        if(b!= null){
            titulo.setText(b.getString("TIT"));
            detalles.setText(b.getString("DET"));
        }
    }
}