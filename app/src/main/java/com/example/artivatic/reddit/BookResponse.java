package com.example.artivatic.reddit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by artivatic on 1/4/17.
 */

class BookResponse {

    private int status;

    private List<Info> info=new ArrayList<>();

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public List<Info> getInfo() {
        return info
                ;
    }

    /**
     *
     * @param activity
     * The activity
     */
    public void setActivity(List<Info> activity) {
        this.info = activity;
    }

    @Override
    public String toString() {
        return "ClassPojo [status = " + status + ", info = " + info + "]";
    }


//
public class Info {
    private String status;

    private String description;

    private String image;

    private String tilte;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTilte() {
        return tilte;
    }

    public void setTilte(String tilte) {
        this.tilte = tilte;
    }

    @Override
    public String toString() {
        return "ClassPojo [status = " + status + ", description = " + description + ", image = " + image + ", tilte = " + tilte + "]";
    }
}
}
