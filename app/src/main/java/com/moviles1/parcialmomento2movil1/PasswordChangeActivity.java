package com.moviles1.parcialmomento2movil1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PasswordChangeActivity extends AppCompatActivity {
    Button btChange;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_change);
        btChange = findViewById(R.id.btchange);
    }
    public void closeSession(View View){
        SharedPreferences preferences = getSharedPreferences("user", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("userState","");
        editor.commit();
        Intent home3 = new Intent(PasswordChangeActivity.this,HomeActivity.class);
        startActivity(home3);
    }
}