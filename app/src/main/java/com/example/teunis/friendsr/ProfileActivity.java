package com.example.teunis.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    // inner class to save rating when ratingBar is clicked
    private class OnRatingBarChangeListener implements RatingBar.OnRatingBarChangeListener {

        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            saveToSharedPreferences(ratingBar);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // know what person is clicked
        setContentView(R.layout.activity_profile);
        Intent intent = getIntent();
        Friend retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        // know what fields of activity_profile to change
        ImageView pictureFriend = findViewById(R.id.pictureFriend);
        TextView nameFriend = findViewById(R.id.nameFriend);
        TextView bioFriend = findViewById(R.id.bioFriend);

        // change picture to drawableId of person
        int id = retrievedFriend.getDrawableId();
        pictureFriend.setImageResource(id);

        // adjust name and bio
        nameFriend.setText(retrievedFriend.name);
        bioFriend.setText(retrievedFriend.bio);

        // retrieve (saved) rating
        loadFromSharedPreferences();
        RatingBar ratingFriend = (RatingBar) findViewById(R.id.ratingBarFriend);
        ratingFriend.setOnRatingBarChangeListener(new OnRatingBarChangeListener());

    }

    // store rating for person x
    public void saveToSharedPreferences(View view) {

        // what person
        Intent intent = getIntent();
        Friend retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        // save with key
        RatingBar ratingFriend = (RatingBar) findViewById(R.id.ratingBarFriend);
        float ratingValue = ratingFriend.getRating();
        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putFloat("ratingSaved" + retrievedFriend.name, ratingValue);
        editor.apply();
        }

    // load rating person x
    public void loadFromSharedPreferences() {

        // what person
        Intent intent = getIntent();
        Friend retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        // load with key
        RatingBar ratingFriend = (RatingBar) findViewById(R.id.ratingBarFriend);
        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        float rating = prefs.getFloat("ratingSaved" + retrievedFriend.name, 0.0f);

        if (rating != 0.0f) {
            retrievedFriend.setRating(rating);
            ratingFriend.setRating(retrievedFriend.rating);
        }
        else {
            retrievedFriend.setRating(0.0f);
            ratingFriend.setRating(retrievedFriend.rating);
        }
    }

}
