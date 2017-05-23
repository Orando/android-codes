package com.example.walterorando.yrproject.models;

/**
 * Created by Walter Orando on 5/18/2016.
 */
public class resultsItems {


    String gameplayed, results,sport,id;

    public resultsItems() {
    }

    public resultsItems(String gameplayed, String results,String sport,String id ) {
        super();

        this.gameplayed = gameplayed;
        this.results = results;
        this.sport = sport;
        this.id = id;
    }

    public String getGameplayed() {
        return gameplayed;
    }

    public void setGameplayed(String gameplayed) {
        this.gameplayed = gameplayed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }


}
