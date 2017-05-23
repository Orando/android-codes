package com.example.walterorando.yrproject.adapters;

import java.util.ArrayList;

/**
 * Created by Walter Orando on 11/3/2016.
 */

public class ChildInfo {
    private String playerName = "";

    private String jerseyNo,description,dob,country,height,image,position,weight, formerClubs;
/*
    public ChildInfo(String playerName, String description, String dob, String country, String height, String image,
                       String position, String weight, ArrayList<String> formerClubs)
    {
        this.playerName = playerName;
        this.description = description;
        this.dob = dob;
        this.country = country;
        this.height = height;
        this.image = image;
        this.position = position;
        this.weight = weight;
        this.formerClubs = formerClubs;

    } */

    public String getJerseyNo() {
        return jerseyNo;
    }

    public void setJerseyNo(String jerseyNo) {
        this.jerseyNo= jerseyNo;
    }

    public String getName() {
        return playerName;
    }

    public void setName(String playerName) {
        this.playerName = playerName;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription( String description){
        this.description = description;
    }

    public String getDob(){
        return dob;
    }
    public void setDob(String dob){
        this.dob = dob;
    }

    public String getCountry(){
        return country;
    }
    public void setCountry(String country){
        this.country = country;
    }

    public String getHeight(){
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight(){
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getThumbnailUrl() {
        return image;
    }

    public void setThumbnailUrl(String image) {
        this.image = image;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    public String getformerClubs(){
        return formerClubs;
    }

    public void setFormerClubs( String formerClubs) {
        this.formerClubs = formerClubs;
    }

}
