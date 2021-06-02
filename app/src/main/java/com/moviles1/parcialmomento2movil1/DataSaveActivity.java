package com.moviles1.parcialmomento2movil1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DataSaveActivity extends AppCompatActivity {

    Button btSession;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_save);
        btSession = findViewById(R.id.btSession);
    }
    public void closeSession(View View){
        SharedPreferences preferences = getSharedPreferences("user", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("userState","");
        editor.commit();
        Intent home3 = new Intent(DataSaveActivity.this,HomeActivity.class);
        startActivity(home3);
        finish();
    }
}