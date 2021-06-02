package com.moviles1.parcialmomento2movil1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etPersona;
    EditText etEmail;
    EditText etPassword;
    EditText etKeyword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etPersona = findViewById(R.id.etnombre);
        etEmail = findViewById(R.id.etemail);
        etPassword = findViewById(R.id.etcontraseña);
        etKeyword =findViewById(R.id.etpalabraclave);
    }

    public void validateUser(View View){
      String persona = etPersona.getText().toString();
      String email = etEmail.getText().toString();
      String password = etPassword. getText().toString();
      String keyword = etKeyword.getText().toString();
      if (persona.isEmpty()){
          Toast.makeText(this, "El nombre no puede estar vacio", Toast.LENGTH_SHORT).show();
      }
      if (email.isEmpty()){
          Toast.makeText(this, "El email no puede estar vacio", Toast.LENGTH_SHORT).show();
      }
      if (keyword.isEmpty()){
          Toast.makeText(this, "La palabra clave no puede estar vacia", Toast.LENGTH_SHORT).show();
      }
      if (password.length()<8){
            Toast.makeText(this, "la contraseña debe tener como minimo 8 caracteres", Toast.LENGTH_SHORT).show();
        }
      else {
          Toast.makeText(this, "usuario creado", Toast.LENGTH_SHORT).show();
          Intent changesScreen = new Intent(MainActivity.this,HomeActivity .class);
          startActivity(changesScreen);
          finish();
      }
    }
    public void log_in(View View){
        Intent changesScreen = new Intent(MainActivity.this,HomeActivity .class);
        startActivity(changesScreen);
    }
}