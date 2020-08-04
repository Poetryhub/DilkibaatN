package com.example.dilkibaat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ImageViewHolder> {

    private ArrayList<Category> imageModelArrayList;
    private LayoutInflater inflater;



    public CategoryAdapter(Context ctx, ArrayList<Category> imageModelArrayList){

        inflater = LayoutInflater.from(ctx);
        this.imageModelArrayList = imageModelArrayList;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.categories;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean sholdAttachToParentImmediately = false;
        View view = inflater.inflate(layoutIdForListItem,parent,sholdAttachToParentImmediately);
        ImageViewHolder viewHolder = new ImageViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
holder.imageView.setImageResource(imageModelArrayList.get(position).getImage_drawable());
    }

    @Override
    public int getItemCount() {
        return imageModelArrayList.size();
    }


    class ImageViewHolder extends  RecyclerView.ViewHolder{
    private ImageView imageView ;

    public  ImageViewHolder (View itemView ){
       super(itemView);

       imageView = itemView.findViewById(R.id.poetry);
    }


    }
}

