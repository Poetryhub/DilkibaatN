package com.example.dilkibaat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginPage extends AppCompatActivity {
    EditText mEamil,mPassword;
    Button mLoginButton;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        mEamil=findViewById(R.id.email_ediText);
        mPassword=findViewById(R.id.password_editText);
        mLoginButton=findViewById(R.id.Login_Button);
        mAuth = FirebaseAuth.getInstance();
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();
            }
        });


    }

    private void Login() {

        String email=mEamil.getText().toString();
        String password=mPassword.getText().toString();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(getApplicationContext(),Homepage.class));
                            Toast.makeText(getApplicationContext(),"Login Success",Toast.LENGTH_LONG).show();
                        } else {
                            // If sign in fails, display a message to the user.
                          Toast.makeText(getApplicationContext(),"Login Failed",Toast.LENGTH_LONG).show();
                        }

                        // ...
                    }
                });


    }

    public void forgotPasword(View view) {
        Intent i = new Intent(LoginPage.this,MobileNoVerify.class);
        startActivity(i);
        finish();
    }
}