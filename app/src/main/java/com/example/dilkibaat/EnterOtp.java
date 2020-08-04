package com.example.dilkibaat;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EnterOtp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_otp);

    }

    public void Verify(View view) {
        Intent i = new Intent(EnterOtp.this,SettingUpProfile.class);
        startActivity(i);
        finish();
    }
}