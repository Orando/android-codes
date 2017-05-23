package com.example.walterorando.yrproject.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.walterorando.yrproject.R;
import com.example.walterorando.yrproject.models.FixtureItems;
import com.example.walterorando.yrproject.models.resultsItems;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Walter Orando on 5/18/2016.
 */
public class ResultsAdapter extends RecyclerView.Adapter<ResultsAdapter.ViewHolderResults> {
    private ArrayList<resultsItems> mListResults;
    private LayoutInflater mInflater;
    Context mcontext;

    public ResultsAdapter(Context context, ArrayList<resultsItems> listResults) {
        this.mcontext = context;
        this.mListResults = listResults;
        mInflater = LayoutInflater.from(context);

    }

    public void setPosts(ArrayList<resultsItems> listResults) {
        this.mListResults = listResults;
        //update the adapter to reflect the new set of posts
        notifyDataSetChanged();
    }

    @Override
    public ViewHolderResults onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.results_item, parent, false);
        ViewHolderResults viewHolder = new ViewHolderResults(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolderResults holder, int position) {

        resultsItems currentPost = mListResults.get(position);
        holder.gameplayed.setText(currentPost.getGameplayed());
        holder.results.setText(currentPost.getResults());
        holder.sport.setText(currentPost.getSport());


    }



    @Override
    public int getItemCount() {
        return mListResults.size();
    }

    class ViewHolderResults extends RecyclerView.ViewHolder implements View.OnClickListener {


        TextView gameplayed, results, sport;

        public ViewHolderResults(View itemView) {
            super(itemView);

            results = (TextView) itemView.findViewById(R.id.results);
            gameplayed = (TextView) itemView.findViewById(R.id.gameplayed);
            sport =(TextView)itemView.findViewById(R.id.sport);

        }

        @Override
        public void onClick(View v) {
        }
    }
}

