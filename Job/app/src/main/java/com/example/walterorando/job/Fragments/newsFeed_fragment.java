package com.example.walterorando.job.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.example.walterorando.job.R;



/**
 * Created by Walter Orando on 3/24/2016.
 */
public class newsFeed_fragment extends Fragment {


    ProgressBar pro_bar;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_newsfeed, container, false);


        return v;
    }






}
