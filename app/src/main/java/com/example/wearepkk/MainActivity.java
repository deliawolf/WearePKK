package com.example.wearepkk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.customview.widget.ViewDragHelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView shopcard, eventcard, accountcard, pediacard, aboutcard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shopcard = findViewById(R.id.id_shop_card);
        eventcard = findViewById(R.id.id_event_card);
        accountcard = findViewById(R.id.id_account_card);
        pediacard = findViewById(R.id.id_pedia_card);
        aboutcard = findViewById(R.id.id_about_card);

        shopcard.setOnClickListener(this);
        eventcard.setOnClickListener(this);
        accountcard.setOnClickListener(this);
        pediacard.setOnClickListener(this);
        aboutcard.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()) {
            case R.id.id_shop_card:
                i = new Intent(this, ShopActivity.class);startActivity(i);
                break;
            case R.id.id_event_card:
                i = new Intent(this, EventActivity.class);startActivity(i);
                break;
            case R.id.id_account_card:
                i = new Intent(this, AccountActivity.class);startActivity(i);
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
}