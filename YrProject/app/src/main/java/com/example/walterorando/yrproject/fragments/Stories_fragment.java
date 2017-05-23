package com.example.walterorando.yrproject.fragments;


import android.annotation.TargetApi;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.*;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.walterorando.yrproject.R;
import com.example.walterorando.yrproject.activities.AddStoryActivity;
import com.example.walterorando.yrproject.adapters.StoriesAdapter;
import com.example.walterorando.yrproject.database.LoginDataBaseAdapter;
import com.example.walterorando.yrproject.helper.HidingScrollListener;
import com.example.walterorando.yrproject.models.HomeItems;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Walter Orando on 3/24/2016.
 */
public class Stories_fragment extends Fragment {

    private ArrayList<HomeItems> listItems = new ArrayList<>();
    private StoriesAdapter mPostsAdapter;
    public LinearLayoutManager layoutManager;
    LoginDataBaseAdapter myDb;

    private static final String JSON_URL = "http://192.168.42.157/UGMMS/stories.php";

    private SwipeRefreshLayout mSwipeRefreshLayout;
    FloatingActionButton fab_story;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_stories, container, false);

    fab_story = (FloatingActionButton) v.findViewById(R.id.postArticle);
        fab_story.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),AddStoryActivity.class);
                startActivity(intent);
            }
        });

        RecyclerView pagesList = (RecyclerView) v.findViewById(R.id.storiesList);
        layoutManager =new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        pagesList.setLayoutManager(layoutManager);
        mPostsAdapter = new StoriesAdapter(getActivity(), listItems);
        pagesList.setAdapter(mPostsAdapter);

        pagesList.addOnScrollListener(new HidingScrollListener(layoutManager) {
            @Override
            public void onHide() {
                FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) fab_story.getLayoutParams();
                int fabBottomMargin = lp.bottomMargin;
                fab_story.animate().translationY(fab_story.getHeight() + fabBottomMargin).setInterpolator(new AccelerateInterpolator(2)).start();
            }

            @Override
            public void onShow() {
                fab_story.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2)).start();
            }

            @Override
            public void onLoadMore(int currentPage) {
            }
        });

        mSwipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipeHome);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getJSON(JSON_URL);
            }
        });

        mPostsAdapter.setOnItemClickListener(new StoriesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(final View view, int position) {

                final TextView readMore = (TextView) view.findViewById(R.id.read);
                final TextView tvContent = (TextView) view.findViewById(R.id.content);
                readMore.setOnClickListener(new View.OnClickListener() {

                    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                    @Override
                    public void onClick(View v) {
                        if (tvContent.getMaxLines() == 5) {
                            tvContent.setMaxLines(Integer.MAX_VALUE);
                            tvContent.setEllipsize(null);
                            readMore.setText(getString(R.string.less));
                        } else {
                            tvContent.setMaxLines(3);
                            tvContent.setEllipsize(TextUtils.TruncateAt.END);
                            readMore.setText(getString(R.string.read));
                        }

                    }
                });
            }
        });

        return v;

    }
    private void getJSON(String url){


        class GetJSON extends AsyncTask<String, Void ,String> {
            ProgressBar loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
//                loading.setVisibility(View.VISIBLE);
            }

            @Override
            protected String doInBackground(String... params) {

            try{
                RequestQueue queue = Volley.newRequestQueue(getActivity());
                JsonArrayRequest jsonRequest = new JsonArrayRequest(Request.Method.GET,
                       JSON_URL,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                mPostsAdapter.setPosts(  parseJSONResponse(response));
                                if(mSwipeRefreshLayout.isRefreshing()){
                                    mSwipeRefreshLayout.setRefreshing(false);
                                }
                            }
                        }
                            ,new Response.ErrorListener() {

                                public void onErrorResponse(VolleyError error) {
                                    Log.d("myError", error.toString());
                                    if(mSwipeRefreshLayout.isRefreshing()){
                                        mSwipeRefreshLayout.setRefreshing(false);
                                    }
                                }
                            }
                        );

        queue.add(jsonRequest);

                } catch (Exception e) {
                    return null;
            }
                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
//                loading.setVisibility(View.GONE);

            }
        }
        GetJSON gj = new GetJSON();
        gj.execute(url);


    }

    public ArrayList<HomeItems> parseJSONResponse(JSONArray response) {
        ArrayList<HomeItems> listItems = new ArrayList<>();
        try {
            for (int i = 0; i < response.length(); i++) {
                JSONObject item = (JSONObject) response.get(i);

                String id = item.getString("story_id");
                String title = item.getString("main_stories");
                String gameName = item.getString("Sport_Name");



                HomeItems items = new HomeItems();
                items.setContent(gameName);
                items.setTitle(title);
                items.setId(id);


                listItems.add(items);

            }
        } catch (JSONException e) {
            e.printStackTrace();

        }
        return listItems;
    }

}

