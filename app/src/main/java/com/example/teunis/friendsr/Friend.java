package com.example.teunis.friendsr;

import java.io.Serializable;

// class for storing friend-items (name, bio, drawableId and rating)
public class Friend implements Serializable {
    public String name, bio;
    public int drawableId;
    public float rating;

    // make friend with: 'new Friend(name, bio, drawableId)'
    public Friend(String name, String bio, int drawableId) {
        this.name = name;
        this.bio = bio;
        this.drawableId = drawableId;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
