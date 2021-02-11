package com.example.firebase;

public class Node {
    String title;
    String subTitle;

    public Node(String title, String subTitle) {
        this.title = title;
        this.subTitle = subTitle;
    }

    public Node() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
}
