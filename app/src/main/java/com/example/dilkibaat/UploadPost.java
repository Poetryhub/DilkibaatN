package com.example.dilkibaat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.util.HashMap;

public class UploadPost extends AppCompatActivity {
    public static final int RESULT_LOAD_IMAGE=1;
    FirebaseDatabase database;
    Uri imageUri;
    private StorageReference mStorageRef;
    DatabaseReference mRef;
    EditText title,content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_post);
    database=FirebaseDatabase.getInstance();
    mRef=database.getReference().child("posts");
    title=findViewById(R.id.editTextTextPersonName);
    content=findViewById(R.id.editTextTextPersonName2);

    mStorageRef= FirebaseStorage.getInstance().getReference("posts");


    }

    public void getImage(View view) {

        Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, RESULT_LOAD_IMAGE);


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == RESULT_LOAD_IMAGE){
            imageUri = data.getData();

        }
    }

    public void setData(View view) {


        final StorageReference riversRef = mStorageRef;

        riversRef.putFile(imageUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // Get a URL to the uploaded content
                       // The string(file link) that you need
                        riversRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>()
                        {
                            @Override
                            public void onSuccess(Uri downloadUrl)
                            {
                                HashMap<String ,String> map=new HashMap<>();
                                map.put("title",title.getText().toString());
                                map.put("content",content.getText().toString());
                                map.put("imageurl",downloadUrl.toString());//do something with downloadurl
                            }
                        });


                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {


                    }
                });


    }
}