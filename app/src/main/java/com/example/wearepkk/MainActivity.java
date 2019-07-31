package com.example.wearepkk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.customview.widget.ViewDragHelper;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.card.MaterialCardView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private static final String TAG = "MainActivity";
    private CardView shopcard, eventcard, accountcard, pediacard, aboutcard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eventcard = findViewById(R.id.id_event_card);
        pediacard = findViewById(R.id.id_pedia_card);
        aboutcard = findViewById(R.id.id_about_card);

        eventcard.setOnClickListener(this);
        pediacard.setOnClickListener(this);
        aboutcard.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()) {
            case R.id.id_event_card:
                i = new Intent(this, EventActivity.class);startActivity(i);
                break;
            case R.id.id_pedia_card:
                i = new Intent(this, PediaActivity.class);startActivity(i);
                break;
            case R.id.id_about_card:
                i = new Intent(this, AboutActivity.class);startActivity(i);
                break;
                default:break;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_signout, menu);

        return true;
    }
}