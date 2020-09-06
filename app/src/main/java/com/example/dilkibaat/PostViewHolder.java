package com.example.dilkibaat;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostViewHolder extends RecyclerView.ViewHolder {
    TextView mPostTitle,mPostContent;
    CircleImageView circularImageView;


    public PostViewHolder(@NonNull View itemView) {
        super(itemView);
        mPostTitle=itemView.findViewById(R.id.post_username);
    mPostContent=itemView.findViewById(R.id.post_content);
    circularImageView=itemView.findViewById(R.id.profile_image);

    }
}
