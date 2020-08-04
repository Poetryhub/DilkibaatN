package com.example.dilkibaat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MobileNoVerify extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_no_verify);

    }

    public void EnterOtp(View view) {
        Intent i = new Intent(MobileNoVerify.this,EnterOtp.class);
        startActivity(i);
        finish();
    }
}