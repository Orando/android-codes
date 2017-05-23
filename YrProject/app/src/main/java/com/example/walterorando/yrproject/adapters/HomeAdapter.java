package com.example.walterorando.yrproject.adapters;

import com.example.walterorando.yrproject.models.HomeItems;
import com.example.walterorando.yrproject.R;

import android.view.LayoutInflater;
import android.content.Context;
import android.text.format.DateUtils;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

/**
 * Created by Walter Orando on 3/17/2016.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolderHome> {

    //contains list of posts
    private ArrayList<HomeItems> homeposts = new ArrayList<>();
    private LayoutInflater homeInflater;
    Context homeContext;
    String timeStamp;
    Date date;

    public HomeAdapter(Context context) {
        this.homeContext = context;
        homeInflater = LayoutInflater.from(context);
    }

    public void setPosts(ArrayList<HomeItems> listposts) {
        this.homeposts = listposts;
        //update adapter to reflect set of new posts
        notifyDataSetChanged();
    }


    @Override
    public ViewHolderHome onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = homeInflater.inflate(R.layout.home_items, parent,false);
        ViewHolderHome viewHolder = new ViewHolderHome(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final HomeAdapter.ViewHolderHome holder, int position) {
        HomeItems currentPost = homeposts.get(position);
        holder.content.setText(currentPost.getContent());
        holder.username.setText(currentPost.getUsername());

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        try {
            date = formatter.parse(currentPost.getTimeStamp().substring(0, 24));
        }catch (ParseException e){
            e.printStackTrace();
        }

        timeStamp = (String) DateUtils.getRelativeTimeSpanString(date.getTime(),
        System.currentTimeMillis(),
        DateUtils.SECOND_IN_MILLIS);
        holder.contentDate.setText(timeStamp);


        holder.title.setText(currentPost.getTitle());
        if(currentPost.getBlog() != null){
            holder.blog.setText(currentPost.getBlog());
        }
        else{
         holder.blog.setVisibility(View.GONE);
        }
        if(currentPost.getMedia() != null) {
            holder.postImage.setVisibility(View.VISIBLE);
            Glide.with(homeContext)
                    .load(currentPost.getUserImage())
                    .asBitmap()
                    .centerCrop()
                    .placeholder(R.drawable.image_holder)
                    .error(R.drawable.image_holder)
                    .into(holder.postImage);
        }
        else{
        holder.postImage.setVisibility(View.GONE);
        }

        Glide.with(homeContext)
                .load(currentPost.getUserImage())
                .asBitmap()
                .centerCrop()
                .placeholder(R.drawable.image_holder)
                .error(R.drawable.image_holder)
                .into(new BitmapImageViewTarget(holder.userImage){

                protected void setResource(Bitmap resource){
                   RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(homeContext.getResources(), resource);
                    circularBitmapDrawable.setCircular(true);
                    holder.userImage.setImageDrawable(circularBitmapDrawable);
                }
        });

    }

    @Override
    public int getItemCount() {
        return homeposts.size();
    }

    static class ViewHolderHome extends RecyclerView.ViewHolder {

        ImageView postImage, userImage;
        TextView content, contentDate, title, blog, username;

        public ViewHolderHome(View itemView) {
            super(itemView);
            postImage = (ImageView) itemView.findViewById(R.id.mediaImage);
            userImage = (ImageView) itemView.findViewById(R.id.userImage);
            username = (TextView) itemView.findViewById(R.id.username);
            content = (TextView) itemView.findViewById(R.id.content);
            contentDate = (TextView) itemView.findViewById(R.id.timestamp);
            title = (TextView) itemView.findViewById(R.id.title);
            blog = (TextView) itemView.findViewById(R.id.blog);

        }
    }
}