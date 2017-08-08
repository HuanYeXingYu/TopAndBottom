package com.nzsc.myapplication.Entity;

/**
 * Created by 夜墨 on 2017/8/7.
 */

public class ListMain {
    private  String type;
    private String content;
    private int imageID;

    public ListMain(String type, String content) {
        this.type = type;
        this.content = content;
    }

    public ListMain(String type, String content, int imageID) {
        this.type = type;
        this.content = content;
        this.imageID = imageID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }
}
