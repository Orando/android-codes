package com.example.walterorando.yrproject.models;

import java.util.ArrayList;

/**
 * Created by Walter Orando on 2/8/2017.
 */

public class PlayerItems {

    private String name,description,dob,country,height,image,position,weight;
    private ArrayList<String> formerClubs;

    public PlayerItems(){

    }
    public PlayerItems(String name, String description, String dob, String country, String height, String image,
                       String position, String weight, ArrayList<String> formerClubs)
    {
        this.name = name;
        this.description = description;
        this.dob = dob;
        this.country = country;
        this.height = height;
        this.image = image;
        this.position = position;
        this.weight = weight;
        this.formerClubs = formerClubs;

    }
    //getter and setters

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    public ArrayList<String> getformerClubs(){
        return formerClubs;
    }

    public void setFormerClubs(ArrayList<String> formerClubs) {
        this.formerClubs = formerClubs;
    }
}
