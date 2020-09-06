package com.example.dilkibaat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;

import static com.example.dilkibaat.R.menu.top_bar_menu;

public class Homepage extends AppCompatActivity {
private Toolbar toolbar ;

private CategoryAdapter categoryAdapter ;
    private ArrayList<Category> imageModelArrayList;
private RecyclerView recyclerView , recyclerViewpost ;

    private int[] myImageList = new int[]{R.drawable.poetrybackground,R.drawable.storybackground,R.drawable.bookreviewbackgorund,R.drawable.poetrybackground};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        toolbar = findViewById(R.id.main_toolbar);
        recyclerView = findViewById(R.id.category_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        imageModelArrayList = eatFruits();
        categoryAdapter = new CategoryAdapter(this, imageModelArrayList);
        recyclerView.setAdapter(categoryAdapter);


        recyclerViewpost = findViewById(R.id.post_recyclerview);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerViewpost.setLayoutManager(layoutManager1);


        setPOstRecyclerView();


    }

    private void setPOstRecyclerView() {
        RecyclerView PostRecyclerView=findViewById(R.id.post_recyclerview);
        PostRecyclerView.setHasFixedSize(true);
        PostRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("posts");

        FirebaseRecyclerOptions<PostModelClass> options =
                new FirebaseRecyclerOptions.Builder<PostModelClass>()
                        .setQuery(query, PostModelClass.class)
                        .build();

        FirebaseRecyclerAdapter adapter = new FirebaseRecyclerAdapter<PostModelClass, PostViewHolder>(options){

            @NonNull
            @Override
            public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.post, parent, false);
                return new PostViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull PostViewHolder holder, int position, @NonNull PostModelClass model) {

                holder.mPostTitle.setText(""+model.getTitle());
                holder.mPostContent.setText("" +model.getContent());

                Glide.with(Homepage.this).load(model.getImageurl()).
                        into(holder.circularImageView);

            }
        };
        adapter.startListening();
        PostRecyclerView.setAdapter(adapter);


    }

    private ArrayList<Category> eatFruits(){

        ArrayList<Category> list = new ArrayList<>();

        for(int i = 0; i < 4; i++){
            Category category = new Category ();
            category.setImage_drawable(myImageList[i]);
            list.add(category);
        }

        return list;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        return true;
    }
}