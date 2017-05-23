package com.example.walterorando.yrproject.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.walterorando.yrproject.R;
import com.example.walterorando.yrproject.activities.MainActivity;
import com.example.walterorando.yrproject.adapters.ChildInfo;
import com.example.walterorando.yrproject.adapters.CustomAdapter;
import com.example.walterorando.yrproject.adapters.GroupInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.android.volley.VolleyError;
import com.example.walterorando.yrproject.app.AppController;

/**
 * Created by Walter Orando on 3/24/2016.
 */
public class Team_players_fragment extends Fragment {

    private LinkedHashMap<String, GroupInfo> teamplayers = new LinkedHashMap<String, GroupInfo>();
    private ArrayList<GroupInfo> playerList = new ArrayList<GroupInfo>();

    private static final String TAG = Team_players_fragment.class.getSimpleName();
    private static final String url = "http://localhost/Tandaza/players.php";//192.168.42.35

    private CustomAdapter listAdapter;
    private ExpandableListView simpleExpandableListView;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
     //   View layout inflator(R.layout.fragment_team_players);
        View layout = inflater.inflate(R.layout.fragment_team_players, container, false);
    //add data for displaying in the expandable list

        loadData();

        //get reference of the ExpandableListView
        simpleExpandableListView = (ExpandableListView) layout.findViewById(R.id.simpleExpandableListView);
        // create the adapter by passing your ArrayList data
        listAdapter = new CustomAdapter(getActivity(), playerList);
        // attach the adapter to the expandable list view
        simpleExpandableListView.setAdapter(listAdapter);

        // setOnChildClickListener listener for child row click
        simpleExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                //get the group header
                GroupInfo headerInfo = playerList.get(groupPosition);
                //get the child info
                ChildInfo detailInfo = headerInfo.getPlayerName().get(childPosition);
                //display it or do something with it
                Toast.makeText(getContext(), " Team And Player :: " + headerInfo.getName()
                        + "/" + detailInfo.getName(), Toast.LENGTH_LONG).show();
                return false;
            }
        });
        // setOnGroupClickListener listener for group heading click
        simpleExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                //get the group header
                GroupInfo headerInfo = playerList.get(groupPosition);
                //display it or do something with it
                Toast.makeText(getContext(), " Team Name :: " + headerInfo.getName(),
                        Toast.LENGTH_LONG).show();
                setListViewHeight(parent, groupPosition) ;

                return false;
            }
        });

        simpleExpandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int grpPos =- 1;
            @Override
            public void onGroupExpand(int groupPosition) {
                if(groupPosition!=grpPos){
                    simpleExpandableListView.collapseGroup(grpPos);
                }
grpPos = groupPosition;
            }
        });

return layout;
    }


    // load some initial data into out list
    private void loadData() {

       addProduct("Goalkeepers", "Kolongo");
        addProduct("Goalkeepers", "Ted");
        addProduct("Goalkeepers", "Mark");

        addProduct("Defenders", "Valentine");
        addProduct("Defenders", "Gad");
        addProduct("Defenders", "Makori");
        addProduct("Defenders", "Austo");
        addProduct("Defenders", "Oriedi");
        addProduct("Defenders", "Manga");
        addProduct("Defenders", "Ndiefi");
        addProduct("Defenders", "Lefty");
        addProduct("Defenders", "Mula");

        addProduct("Midfielders", "Justo");
        addProduct("Midfielders", "Pinto");
        addProduct("Midfielders", "Byron");
        addProduct("Midfielders", "Sila");
        addProduct("Midfielders", "Walt");
        addProduct("Midfielders", "Melvo");
        addProduct("Midfielders", "Davy");
        addProduct("Midfielders", "Tito");
        addProduct("Midfielders", "Duff");

        addProduct("Strikers", "Mike");
        addProduct("Strikers", "Baraza");

    }


    // here we maintain team and player names
    private int addProduct(String teamName, String playerName) {

        int groupPosition = 0;

        //check the hash map if the group already exists
        GroupInfo headerInfo = teamplayers.get(teamName);
        //add the group if doesn't exists
        if (headerInfo == null) {
            headerInfo = new GroupInfo();
            headerInfo.setName(teamName);
            teamplayers.put(teamName, headerInfo);
            playerList.add(headerInfo);
        }

        // get the children for the group
        ArrayList<ChildInfo> productList = headerInfo.getPlayerName();
        // size of the children list
        int listSize = productList.size();
        // add to the counter
        listSize++;

        // create a new child and add that to the group
        ChildInfo detailInfo = new ChildInfo();
        detailInfo.setName(playerName);
        productList.add(detailInfo);
        headerInfo.setPlayerName(productList);

        // find the group position inside the list
        groupPosition = playerList.indexOf(headerInfo);
        return groupPosition;
    }

    private void setListViewHeight(ExpandableListView listView,
                                   int group) {
        ExpandableListAdapter listAdapter = (ExpandableListAdapter) listView.getExpandableListAdapter();
        int totalHeight = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(),
                View.MeasureSpec.EXACTLY);
        for (int i = 0; i < listAdapter.getGroupCount(); i++) {
            View groupItem = listAdapter.getGroupView(i, false, null, listView);
            groupItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);

            totalHeight += groupItem.getMeasuredHeight();

            if (((listView.isGroupExpanded(i)) && (i != group))
                    || ((!listView.isGroupExpanded(i)) && (i == group))) {
                for (int j = 0; j < listAdapter.getChildrenCount(i); j++) {
                    View listItem = listAdapter.getChildView(i, j, false, null,
                            listView);
                    listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);

                    totalHeight += listItem.getMeasuredHeight();

                }
            }
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        int height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getGroupCount() - 1));
        if (height < 10)
            height = 200;
        params.height = height;
        listView.setLayoutParams(params);
        listView.requestLayout();


    }

}


