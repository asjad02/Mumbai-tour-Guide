package com.bootcamp.mumbaitourguide;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private  static final int RC_SIGN_IN = 123;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();

//        CHECKING LOGIN STATUS
        if (auth.getCurrentUser() != null) {
//            user logged in

        } else {
//            user not loged in
            startActivityForResult(AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(Arrays.asList(
                        new AuthUI.IdpConfig.EmailBuilder().build(),
                        new AuthUI.IdpConfig.GoogleBuilder().build()))
                .build(),
            RC_SIGN_IN);
        }
        //OnClickListener Object for Architecture
        View.OnClickListener architectureListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create an intent to open the {@link ArchitectureActivity}
                Intent architectureIntent = new Intent(MainActivity.this,ArchitectureActivity.class);

                //Start the Activity
                startActivity(architectureIntent);
            }
        };

        //Find the Image View that shows the Architecture category
        ImageView architectureImageView = (ImageView) findViewById(R.id.architecture_image);

        //Set the click listener on that view
        architectureImageView.setOnClickListener(architectureListener);

        //Find the Image View that shows the Architecture category
        TextView architectureTextView = (TextView) findViewById(R.id.architecture_text);

        //Set the click listener on that view
        architectureTextView.setOnClickListener(architectureListener);

        //OnClickListener Object for Museum
        View.OnClickListener museumListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create an intent to open the {@link MuseumActivity}
                Intent museumIntent = new Intent(MainActivity.this,MuseumActivity.class);

                //Start the Activity
                startActivity(museumIntent);
            }
        };

        //Find the Image View that shows the Museum category
        ImageView museumImageView = (ImageView) findViewById(R.id.museum_image);

        //Set the click listener on that view
        museumImageView.setOnClickListener(museumListener);

        //Find the Image View that shows the Museum category
        TextView museumTextView = (TextView) findViewById(R.id.museum_text);

        //Set the click listener on that view
        museumTextView.setOnClickListener(museumListener);

        //OnClickListener Object for Restaurants
        View.OnClickListener restaurantsListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create an intent to open the {@link RestaurantsActivity}
                Intent restaurantsIntent = new Intent(MainActivity.this,RestaurantsActivity.class);

                //Start the Activity
                startActivity(restaurantsIntent);
            }
        };

        //Find the Image View that shows the Restaurants category
        ImageView restaurantsImageView = (ImageView) findViewById(R.id.restaurants_image);

        //Set the click listener on that view
        restaurantsImageView.setOnClickListener(restaurantsListener);

        //Find the Image View that shows the Restaurants category
        TextView restaurantsTextView = (TextView) findViewById(R.id.restaurants_text);

        //Set the click listener on that view
        restaurantsTextView.setOnClickListener(restaurantsListener);

        //OnClickListener Object for Events
        View.OnClickListener eventsListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create an intent to open the {@link EventActivity}
                Intent eventsIntent = new Intent(MainActivity.this,EventActivity.class);

                //Start the Activity
                startActivity(eventsIntent);
            }
        };

        //Find the Image View that shows the Events category
        ImageView eventsImageView = (ImageView) findViewById(R.id.events_image);

        //Set the click listener on that view
        eventsImageView.setOnClickListener(eventsListener);

        //Find the Image View that shows the Events category
        TextView eventsTextView = (TextView) findViewById(R.id.events_text);

        //Set the click listener on that view
        eventsTextView.setOnClickListener(eventsListener);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            if (resultCode == RESULT_OK) {
                Log.d("AUTH", auth.getCurrentUser().getEmail());
            } else {
                Log.d("AUTH", "NOT AUTHENTICATED");
            }
        }
    }
}
