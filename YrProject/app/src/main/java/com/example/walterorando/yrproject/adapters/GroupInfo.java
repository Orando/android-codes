package com.example.walterorando.yrproject.adapters;

import java.util.ArrayList;

/**
 * Created by Walter Orando on 11/3/2016.
 */

public class GroupInfo {
    private String teamName;
    private ArrayList<ChildInfo> list = new ArrayList<ChildInfo>();

    public String getName() {
        return teamName;
    }

    public void setName(String teamName) {
        this.teamName = teamName;
    }

    public ArrayList<ChildInfo> getPlayerName() {
        return list;
    }

    public void setPlayerName(ArrayList<ChildInfo> playerName) {
        this.list = playerName;
    }

}
