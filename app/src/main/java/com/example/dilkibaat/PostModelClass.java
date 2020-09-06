package com.example.dilkibaat;

public class PostModelClass {
    String title;
    String content;
    String date;
    String imageurl;

    public PostModelClass() {
    }

    public PostModelClass(String title, String content, String date, String imageurl) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.imageurl = imageurl;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }


    public String getImageurl() {
        return imageurl;
    }
}
