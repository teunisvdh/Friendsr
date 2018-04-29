package com.example.teunis.friendsr;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

// adapter for connecting grid items to friend objects
public class FriendsAdapter extends ArrayAdapter<Friend> {
    public FriendsAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Friend> objects) {
        super(context, resource, objects);
    friends = objects;
    }

    ArrayList<Friend> friends;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }

        // what person
        Friend thisFriend = friends.get(position);

        // what fields to change
        ImageView pictureFriend = convertView.findViewById(R.id.picturePlaceholder);
        TextView nameFriend = convertView.findViewById(R.id.namePlaceholder);

        // change fields for certain person
        int id = thisFriend.getDrawableId();
        pictureFriend.setImageResource(id);
        nameFriend.setText(thisFriend.name);

        return convertView;
    }
}
