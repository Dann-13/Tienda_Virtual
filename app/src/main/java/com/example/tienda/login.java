package com.example.tienda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    private EditText use, pas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        use = findViewById(R.id.use);
        pas = findViewById(R.id.pas);
    }

      public Void login (View view) {

        String usuario =use.getText().toString();
        String clave = pas.getText().toString();

        if (usuario.equals("admin") && clave.equals ("12345")){
            Intent i = new Intent(this,ingreso.class );
            i.putExtra("nombre",usuario);
            startActivity(i);
        } else {
            Toast mensaje= Toast.makeText(this,"verifique usuario y/o contraseña",Toast.LENGTH_LONG);
            mensaje.show();
        }


    }
}