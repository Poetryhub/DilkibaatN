package com.example.dilkibaat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void haveAccount(View view) {
        Intent i = new Intent(MainActivity.this, LoginPage.class);
        startActivity(i);

    }

    public void NewAccount(View view) {
        Intent i = new Intent(MainActivity.this, SignUp.class);
        startActivity(i);

    }

}