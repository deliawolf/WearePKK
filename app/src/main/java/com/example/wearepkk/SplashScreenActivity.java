package com.example.wearepkk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.LinearLayout;

import com.wang.avi.AVLoadingIndicatorView;

public class SplashScreenActivity extends AppCompatActivity {


    private LinearLayout lv_loading;
    private AVLoadingIndicatorView avi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        lv_loading = (LinearLayout)findViewById(R.id.lv_loading);

        avi = (AVLoadingIndicatorView) findViewById(R.id.avi);
        avi.setIndicator("LineScaleIndicator");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(SplashScreenActivity.this,IntroActivity.class);
                startActivity(i);

                finish();
            }
        },3000);
    }
}
