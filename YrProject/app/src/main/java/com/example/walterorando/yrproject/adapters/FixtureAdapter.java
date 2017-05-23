package com.example.walterorando.yrproject.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.walterorando.yrproject.R;
import com.example.walterorando.yrproject.models.FixtureItems;

import java.util.ArrayList;

/**
 * Created by Walter Orando on 5/18/2016.
 */
public class FixtureAdapter extends RecyclerView.Adapter<FixtureAdapter.ViewHolderFixture> {
    private ArrayList<FixtureItems> mListFixtures;
    private LayoutInflater mInflater;
    Context mcontext;

    public FixtureAdapter(Context context, ArrayList<FixtureItems> listFixture) {
        this.mcontext = context;
        this.mListFixtures = listFixture;
        mInflater = LayoutInflater.from(context);

    }

    public void setPosts(ArrayList<FixtureItems> listFixture) {
        this.mListFixtures = listFixture;
        //update the adapter to reflect the new set of posts
        notifyDataSetChanged();
    }

    @Override
    public ViewHolderFixture onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.fixture_item, parent, false);
        ViewHolderFixture viewHolder = new ViewHolderFixture(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolderFixture holder, int position) {

        FixtureItems currentPost = mListFixtures.get(position);
        holder.description.setText(currentPost.getDescription());
        holder.title.setText(currentPost.getTitle());


    }



    @Override
    public int getItemCount() {
        return mListFixtures.size();
    }

    class ViewHolderFixture extends RecyclerView.ViewHolder implements View.OnClickListener {


        TextView title, description;

        public ViewHolderFixture(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);

        }

        @Override
        public void onClick(View v) {
            }
        }
    }

