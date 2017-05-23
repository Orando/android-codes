package com.example.walterorando.yrproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.walterorando.yrproject.R;
import com.example.walterorando.yrproject.app.AppController;

import java.util.ArrayList;
import java.util.HashMap;

import static android.R.attr.data;
import static android.R.attr.thumbnail;

/**
 * Created by Walter Orando on 11/3/2016.
 */

public class CustomAdapter extends BaseExpandableListAdapter{

    private Context context;
    private ArrayList<GroupInfo> teamName;
    ImageLoader imageLoader = AppController.getInstance().getmImageLoader();

    public CustomAdapter(Context context, ArrayList<GroupInfo> deptList) {
        this.context = context;
        this.teamName = deptList;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        ArrayList<ChildInfo> productList = teamName.get(groupPosition).getPlayerName();
        return productList.get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                             View view, ViewGroup parent) {

        ChildInfo detailInfo = (ChildInfo) getChild(groupPosition, childPosition);
        if (view == null) {
            LayoutInflater infalInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = infalInflater.inflate(R.layout.team_players_child_items, null);
        }
        if(imageLoader == null){
            imageLoader = AppController.getInstance().getmImageLoader();
            NetworkImageView thumbnail = (NetworkImageView) view.findViewById(R.id.ivImage);
            thumbnail.setImageUrl(detailInfo.getThumbnailUrl(), imageLoader);
        }

        TextView childItemname = (TextView) view.findViewById(R.id.childItemname);
        childItemname.setText(detailInfo.getName().trim());
        TextView dob = (TextView) view.findViewById(R.id.tvDateOfBirth);
        dob.setText(detailInfo.getDob());
        TextView height = (TextView) view.findViewById(R.id.tvHeight);
        height.setText(detailInfo.getHeight());
        TextView country = (TextView) view.findViewById(R.id.tvCountry);
        country.setText(detailInfo.getCountry());
        TextView description = (TextView) view.findViewById(R.id.tvDescriptionn);
        description.setText(detailInfo.getDescription());
        TextView jerseyNo = (TextView) view.findViewById(R.id.tvJerseyNo);
        jerseyNo.setText(detailInfo.getJerseyNo());
        TextView formerClubs = (TextView) view.findViewById(R.id.tvFormerclub);
        formerClubs.setText(detailInfo.getformerClubs());
        TextView weight = (TextView) view.findViewById(R.id.tvWeight);
        weight.setText(detailInfo.getWeight());

        return view;
    }

    @Override
    public int getChildrenCount(int groupPosition) {

        ArrayList<ChildInfo> productList = teamName.get(groupPosition).getPlayerName();
        return productList.size();

    }

    @Override
    public Object getGroup(int groupPosition) {
        return teamName.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return teamName.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isLastChild, View view,
                             ViewGroup parent) {

        GroupInfo headerInfo = (GroupInfo) getGroup(groupPosition);
        if (view == null) {
            LayoutInflater inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inf.inflate(R.layout.group_team_players, null);
        }

        TextView heading = (TextView) view.findViewById(R.id.headings);
        heading.setText(headerInfo.getName().trim());

        return view;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


}
