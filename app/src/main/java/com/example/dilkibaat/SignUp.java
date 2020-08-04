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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SignUp extends AppCompatActivity {

    EditText mUsername,mPassword,mEmail,mPhone;
    Button mSignUpButton;
    FirebaseAuth mAuth;
    FirebaseDatabase mDatabase;
    DatabaseReference mUserRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mUsername=findViewById(R.id.UsernameEditText);
        mPassword=findViewById(R.id.passwordEditText);
        mEmail=findViewById(R.id.emails_editText);
        mPhone=findViewById(R.id.PhoneEditText);
        mSignUpButton=findViewById(R.id.SignUpButton);
        mAuth=FirebaseAuth.getInstance();
        mDatabase=FirebaseDatabase.getInstance();
        mUserRef=mDatabase.getReference("Users");

        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignUpFunction();
            }
        });


    }

    private void SignUpFunction() {
        final HashMap<String ,String > mMap=new HashMap<>();
        String email=mEmail.getText().toString();
        String password=mPassword.getText().toString();
        String phone=mPhone.getText().toString();
         String username=mUsername.getText().toString();
        mMap.put("email",email);
        mMap.put("phone",phone);
        mMap.put("username",username);




        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        String Uid=mAuth.getCurrentUser().getUid();
                        mUserRef.child(Uid).setValue(mMap);

                        startActivity(new Intent(getApplicationContext(),Homepage.class));
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),"SignUp Failed",Toast.LENGTH_LONG).show();
            }
        });
    }
}