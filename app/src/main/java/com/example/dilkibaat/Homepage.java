package com.example.dilkibaat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.widget.LinearLayout;

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