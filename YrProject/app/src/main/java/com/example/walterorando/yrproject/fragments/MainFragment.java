package com.example.walterorando.yrproject.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.design.widget.FloatingActionButton;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.walterorando.yrproject.R;
import com.example.walterorando.yrproject.adapters.HomeAdapter;
import com.example.walterorando.yrproject.models.HomeItems;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends Fragment implements View.OnClickListener{

    public LinearLayoutManager layoutManager;
    private ArrayList<HomeItems> listitems = new ArrayList<>();
    private HomeAdapter postAdapters;

    private Boolean isFabOpen = false;
    private FloatingActionButton fab, fab1,fab2,fab3;
    private Animation fab_open,fab_close,rotate_forward, rotate_backwards;

    int count;
    ProgressBar pro_bar;
    private SwipeRefreshLayout mainSwiperefreshLayout;


    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // inflating the layout for main fragment
        View v =  inflater.inflate(R.layout.fragment_main, container, false);

        postAdapters = new HomeAdapter(getActivity());
        pro_bar = (ProgressBar)v.findViewById(R.id.pro_bar);

        RecyclerView pagesList = (RecyclerView)v.findViewById(R.id.storylist);
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        pagesList.setLayoutManager(layoutManager);
        pagesList.setAdapter(postAdapters);

        /*
        *
        *
        * database handler section
        *
        *
        *
        * */
        mainSwiperefreshLayout = (SwipeRefreshLayout)v.findViewById(R.id.swipeHome);
        mainSwiperefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            public void onRefresh(){
                getallStories();
            }
        });

        fab = (FloatingActionButton)v.findViewById(R.id.fab);
        fab1 = (FloatingActionButton)v.findViewById(R.id.article);
        fab2 = (FloatingActionButton)v.findViewById(R.id.photo);
        fab3 =  (FloatingActionButton)v.findViewById(R.id.games);

        fab_open = AnimationUtils.loadAnimation(getActivity(), R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(getActivity(), R.anim.fab_close);
        rotate_forward = AnimationUtils.loadAnimation(getActivity(), R.anim.rotate_forward);
        rotate_backwards = AnimationUtils.loadAnimation(getActivity(), R.anim.rotate_backwards);

        fab.setOnClickListener(this);
        fab1.setOnClickListener(this);
        fab2.setOnClickListener(this);
        fab3.setOnClickListener(this);

    return v;
    }
//function to get home stories
    private void getallStories(){}
//**************************************************************************************************
    @Override
    public void onClick(View v) {
    int id = v.getId();
        Intent intent;
        switch(id){
            case R.id.fab:
                animateFAB();
                break;
            case R.id.article:
                //intent
                /*intent = new Intent(getActivity(), AddStoryActivity.class);
                startActivity(intent);
                * */
        }
    }

    public void animateFAB(){
        if(isFabOpen){
            fab.startAnimation(rotate_backwards);
            fab1.startAnimation(fab_close);
            fab2.startAnimation(fab_close);
            fab3.startAnimation(fab_close);
            fab1.setClickable(false);
            fab2.setClickable(false);
            fab3.setClickable(false);

            isFabOpen = true;
        }else{
            fab.startAnimation(rotate_forward);
            fab1.startAnimation(fab_open);
            fab2.startAnimation(fab_open);
            fab3.startAnimation(fab_open);
            fab1.setClickable(true);
            fab2.setClickable(true);
            fab3.setClickable(true);
            isFabOpen = true;
        }
    }
}
