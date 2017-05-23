package com.example.walterorando.yrproject.models;

/**
 * Created by Walter Orando on 5/18/2016.
 */
public class FixtureItems {

    String title, description,id;

    public FixtureItems() {
    }

    public FixtureItems(String title, String description,String id ) {
        super();

        this.title = title;
        this.description = description;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
