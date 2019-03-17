package com.example.allinone.moveapp.models;

public class move {
    String id;
    String title;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImagepath() {
        return imagepath;
    }

    public String getOverview() {
        return overview;
    }

    public String getDate() {
        return date;
    }

    public String getRate() {
        return rate;
    }

    String imagepath;
    String overview;
    String date;

    public move(String id, String title, String imagepath, String overview, String date, String rate, String type) {
        this.id = id;
        this.title = title;
        this.imagepath = imagepath;
        this.overview = overview;
        this.date = date;
        this.rate = rate;
        this.type = type;
    }

    String rate;

    public String getType() {
        return type;
    }

    String type;
}
