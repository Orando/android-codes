package com.example.walterorando.yrproject.fragments;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.walterorando.yrproject.R;
import com.example.walterorando.yrproject.adapters.FixtureAdapter;
import com.example.walterorando.yrproject.database.LoginDataBaseAdapter;
import com.example.walterorando.yrproject.models.FixtureItems;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * Created by Walter Orando on 3/24/2016.
 */
public class Fixture_fragment extends Fragment {


    private ArrayList<FixtureItems> listItems = new ArrayList<>();
    private FixtureAdapter mPostsAdapter;
    public LinearLayoutManager layoutManager;
    LoginDataBaseAdapter myDb;

    public static final String MY_JSON = "MY_JSON";
    private static final String JSON_URL = "http://192.168.42.157/UGMMS/categories.php";

    ProgressBar pro_bar;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fixture, container, false);


        pro_bar = (ProgressBar)v.findViewById(R.id.pro_bar);
        RecyclerView pagesList = (RecyclerView)v.findViewById(R.id.fixtureList);
        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        pagesList.setLayoutManager(layoutManager);
        mPostsAdapter = new FixtureAdapter(getActivity(), listItems);
        pagesList.setAdapter(mPostsAdapter);
        getJSON(JSON_URL);
        mSwipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipeHome);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
            getJSON(JSON_URL);
            }
        });

        return v;
    }

    private void getJSON(String url){
        class GetJSON extends AsyncTask<String, Void ,String>{

            @Override
            protected void onPreExecute(){
                super.onPreExecute();

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

                                    mPostsAdapter.setPosts(parseJSONResponse(response));
                                    if(mSwipeRefreshLayout.isRefreshing()){
                                        mSwipeRefreshLayout.setRefreshing(false);
                                    }
                                }
                            }
                            ,new Response.ErrorListener() {

                        public void onErrorResponse(VolleyError error) {
                            Log.d("myError", error.toString());
                            if(mSwipeRefreshLayout.isRefreshing()) {
                                mSwipeRefreshLayout.setRefreshing(false);
                            }
                        }
                    }
                    );

                    queue.add(jsonRequest);


                }catch (Exception e){
                return null;
            }
                return null;
        }
            @Override
            protected void onPostExecute(String s){
            super.onPostExecute(s);

            }
        }
    GetJSON gj = new GetJSON();
        gj.execute(url);
    }

    public ArrayList<FixtureItems> parseJSONResponse(JSONArray response) {
        ArrayList<FixtureItems> listItems = new ArrayList<>();
        pro_bar.setVisibility(View.GONE);
        try {
            for (int i = 0; i < response.length(); i++) {
                JSONObject item = (JSONObject) response.get(i);

                String id = item.getString("fixture_id");
                String title = item.getString("Game_fixtures");
                String description = item.getString("Sport_Name");


                FixtureItems items = new FixtureItems();
                items.setDescription(description);
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
