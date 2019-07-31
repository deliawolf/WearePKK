package com.example.wearepkk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.customview.widget.ViewDragHelper;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.net.*;
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
        if (!isConnected(MainActivity.this))
            buildDialog(MainActivity.this).show();
        else {

        }

    }
    public boolean isConnected(Context context){

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netinfo = cm.getActiveNetworkInfo();

        if (netinfo != null && netinfo.isConnectedOrConnecting()) {
            android.net.NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            android.net.NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if ((mobile != null && mobile.isConnectedOrConnecting()) || (wifi != null & wifi.isConnectedOrConnecting()))
                return true;
            else
                return false;
        }else
            return false;

    }
    public AlertDialog.Builder buildDialog(Context c){

        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle("No Internet Connection");
        builder.setMessage("Tolong nyalakan wifi anda atau data mobile anda, untuk meload data aplikasi");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        return builder;

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