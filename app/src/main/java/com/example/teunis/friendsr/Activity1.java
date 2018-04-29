package com.example.teunis.friendsr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class Activity1 extends AppCompatActivity {

    // list for saving friends later
    ArrayList<Friend> friends = new ArrayList<>();

    // what grid item is clicked
    private class GridItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Friend clickFriend = (Friend) parent.getItemAtPosition(position);
            Log.d("friend", "name" + clickFriend.name);
            Intent intent = new Intent(Activity1.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickFriend);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);

        // get profile picture resources for later use
        int aryId = getResources().getIdentifier("arya", "drawable", getPackageName());
        int cerId = getResources().getIdentifier("cersei", "drawable", getPackageName());
        int daeId = getResources().getIdentifier("daenerys", "drawable", getPackageName());
        int jaiId = getResources().getIdentifier("jaime", "drawable", getPackageName());
        int jonId = getResources().getIdentifier("jon", "drawable", getPackageName());
        int jorId = getResources().getIdentifier("jorah", "drawable", getPackageName());
        int marId = getResources().getIdentifier("margaery", "drawable", getPackageName());
        int melId = getResources().getIdentifier("melisandre", "drawable", getPackageName());
        int sanId = getResources().getIdentifier("sansa", "drawable", getPackageName());
        int tyrId = getResources().getIdentifier("tyrion", "drawable", getPackageName());

        // make friends, add resource for profilepicture
        Friend ary = new Friend("Arya", "Hi, I am Arya.", aryId);
        Friend cer = new Friend("Cersei", "Hi, I am Cersei.", cerId);
        Friend dae = new Friend("Daenerys", "Hi, I am Daenerys.", daeId);
        Friend jai = new Friend("Jaime", "Hi, I am Jaime.", jaiId);
        Friend jon = new Friend("Jon", "Hi, I am Jon.", jonId);
        Friend jor = new Friend("Jorah", "Hi, I am Jorah.", jorId);
        Friend mar = new Friend("Margaery", "Hi, I am Margaery.", marId);
        Friend mel = new Friend("Melisandre", "Hi, I am Melisandre.", melId);
        Friend san = new Friend("Sansa", "Hi, I am Sansa.", sanId);
        Friend tyr = new Friend("Tyrion", "Hi, I am Tyrion.", tyrId);

        // add friends to list of friends
        friends.add(ary);
        friends.add(cer);
        friends.add(dae);
        friends.add(jai);
        friends.add(jon);
        friends.add(jor);
        friends.add(mar);
        friends.add(mel);
        friends.add(san);
        friends.add(tyr);

        // use adapter to link grid items with friend objects
        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, friends);
        GridView friendList = findViewById(R.id.gridviewFriends);
        friendList.setAdapter(adapter);

        // set listener for click on person to load that person's page
        friendList.setOnItemClickListener(new GridItemClickListener());
    }

}
