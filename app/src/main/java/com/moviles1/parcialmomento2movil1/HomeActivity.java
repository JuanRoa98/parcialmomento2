package com.moviles1.parcialmomento2movil1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    EditText etName;
    EditText etPassword2;
    CheckBox cbSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String userState = loadPreferences();
        if (userState.equals("ok")){
            Intent home2 = new Intent(HomeActivity.this,DataSaveActivity.class);
            startActivity(home2);
            finish();
        }
        else {
            setContentView(R.layout.activity_home);
        }
        etName = findViewById(R.id.etName);
        etPassword2= findViewById(R.id.etPassword2);
        cbSave = findViewById(R.id.cbSave);
    }
    public void session(View View){
        String Username = "juan carlos roa";
        String UserPassword2 = "123456789";
        String UserPassword3 = "234567890";

        String name = etName.getText().toString();
        String password2 = etPassword2.getText().toString();
        if (name.isEmpty()){
            Toast.makeText(this, "el nombre no puede estar vacio", Toast.LENGTH_SHORT).show();
        }
        if (password2.length()<8) {
            Toast.makeText(this, "la contraseña debe de contenerrs 8  caracteres", Toast.LENGTH_SHORT).show();
        }
        else if(name.equals(Username) && password2.equals(UserPassword2)){
           boolean isCheckboxSession = cbSave.isChecked();
           if(isCheckboxSession){
              SavePreferences();
               Toast.makeText(this, "sesion guardada", Toast.LENGTH_SHORT).show();
           }
            Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show();
            Intent home2 = new Intent(HomeActivity.this,DataSaveActivity.class);
            startActivity(home2);
            finish();
        }
        else {
            Toast.makeText(this, "no se encuentra el usuario", Toast.LENGTH_SHORT).show();
        }
    }
    public void PasswordChange(View View){
        Intent changesScreen = new Intent(HomeActivity.this,PasswordChangeActivity.class);
        startActivity(changesScreen);
        finish();

    }
    public void SavePreferences(){
        SharedPreferences preferences = getSharedPreferences("user", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("userState","ok");
        editor.commit();
    }
    public String loadPreferences(){
        SharedPreferences preferences = getSharedPreferences("user", Context.MODE_PRIVATE);
        String userState = preferences.getString("userState","error");
        return userState;
    }
}
