package com.example.artivatic.reddit;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by artivatic on 29/3/17.
 */


    public class DetailModel extends RealmObject
    {
        @PrimaryKey
        private long id;
        private String image;
        private String title;
        private String description;
        public long getId() {
            return id;
        }
        public void setId(long id) {
            this.id = id;
        }



    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


