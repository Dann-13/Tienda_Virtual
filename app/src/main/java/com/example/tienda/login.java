package com.example.tienda;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    private EditText etCorreo, etContraseña;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etCorreo = findViewById(R.id.editTextCorreo);
        etContraseña = findViewById(R.id.editTextPassword);
        firebaseAuth = FirebaseAuth.getInstance();
    }
    public void ingresar(View view){
        String correo = etCorreo.getText().toString();
        String contraseña = etContraseña.getText().toString();

        firebaseAuth.signInWithEmailAndPassword(correo,contraseña).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(login.this,"Ingreso Exitoso", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(login.this, ingreso.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(login.this, "Correo o Contraseña incorrectas", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void registrar(View view){
        String correo = etCorreo.getText().toString();
        String contraseña = etContraseña.getText().toString();
        firebaseAuth.createUserWithEmailAndPassword(correo,contraseña).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(login.this, "Registro Exitoso", Toast.LENGTH_SHORT).show();;
                }else{
                    Toast.makeText(login.this,"Registro Mal", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show();
    }

}