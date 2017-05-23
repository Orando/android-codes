package com.example.walterorando.yrproject.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.example.walterorando.yrproject.R;
import com.example.walterorando.yrproject.models.HomeItems;

public class StoriesAdapter extends RecyclerView.Adapter<StoriesAdapter.ViewHolderHome> {

    private ArrayList<HomeItems> mListPosts;
    private LayoutInflater mInflater;
    Context mContext;
    String timeStamp;
    Date date;
    private static OnItemClickListener listener;

    public StoriesAdapter(Context context, ArrayList<HomeItems> listPost) {
        this.mContext = context;
        this.mListPosts = listPost;
        mInflater = LayoutInflater.from(context);
    }

    public void setPosts(ArrayList<HomeItems> listPosts) {
        this.mListPosts = listPosts;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolderHome onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.stories_items, parent, false);
        return new ViewHolderHome(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolderHome holder, int position) {

        HomeItems currentPost = mListPosts.get(position);
        holder.content.setText(currentPost.getContent());

        Rect bounds = new Rect();
        Paint paint = new Paint();
        paint.setTextSize(holder.content.getTextSize());
        int contentLen = currentPost.getContent().length();
        paint.getTextBounds(currentPost.getContent(), 0,contentLen, bounds);

        int width = (int) Math.ceil( bounds.width());
        int lines = width / currentPost.getContent().length() ;
        if((contentLen - lines) > 100){
            holder.read.setVisibility(View.VISIBLE);
        }else {
            holder.read.setVisibility(View.GONE);
        }

        holder.username.setText(currentPost.getUsername());
        holder.title.setText(currentPost.getTitle());
        holder.sid.setText(currentPost.getId());

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Calendar cal = Calendar.getInstance();
        formatter.setTimeZone(cal.getTimeZone());
        try {
            date = formatter.parse(currentPost.getTimeStamp().substring(0, 24));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        timeStamp = (String) DateUtils.getRelativeTimeSpanString(date.getTime(),
                System.currentTimeMillis(),
                DateUtils.SECOND_IN_MILLIS);
        holder.contentDate.setText(timeStamp);

        if (currentPost.getBlog() != null){
            holder.blog.setText(currentPost.getBlog());
        } else {
            holder.blog.setText("Anonymous");
        }

        if (currentPost.getMedia() != null){
            holder.postImage.setVisibility(View.VISIBLE);
            Glide.with(mContext)
                    .load(currentPost.getMedia())
                    .asBitmap()
                    .into(holder.postImage);
        } else {
            holder.postImage.setVisibility(View.GONE);
        }

        Glide.with(mContext)
                .load(currentPost.getUserImage())
                .asBitmap()
                .centerCrop()
                .placeholder(R.drawable.image_holder)
                .error(R.drawable.image_holder)
                .into(new BitmapImageViewTarget(holder.userImage) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(mContext.getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        holder.userImage.setImageDrawable(circularBitmapDrawable);
                    }
                });
    }

    @Override
    public int getItemCount() {
        return mListPosts.size();
    }

    // Define the listener interface
    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }

    // Define the method that allows the parent activity or fragment to define the listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    static class ViewHolderHome extends RecyclerView.ViewHolder {

        ImageView postImage, userImage;
        TextView content, contentDate, title, blog, username, comments, sid, read;

        public ViewHolderHome(final View itemView) {
            super(itemView);
            postImage = (ImageView) itemView.findViewById(R.id.mediaImage);
            userImage = (ImageView) itemView.findViewById(R.id.userImage);
            username = (TextView) itemView.findViewById(R.id.username);
            content = (TextView) itemView.findViewById(R.id.content);
            contentDate = (TextView) itemView.findViewById(R.id.timestamp);
            title = (TextView) itemView.findViewById(R.id.title);
            blog = (TextView) itemView.findViewById(R.id.blog);
            read = (TextView) itemView.findViewById(R.id.read);
            comments = (TextView) itemView.findViewById(R.id.comments);
            sid = (TextView) itemView.findViewById(R.id.sid);

            // Setup the click listener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Triggers click upwards to the adapter on click
                    if (listener != null)
                        listener.onItemClick(itemView, getLayoutPosition());
                }
            });
        }
    }
}

