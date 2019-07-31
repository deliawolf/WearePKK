package com.example.wearepkk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class EventDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);

        Intent intent = getIntent();

        String event_title = intent.getStringExtra("title_event");
        String event_desc = intent.getStringExtra("description_event");
        String location = intent.getStringExtra("location");
        String time = intent.getStringExtra("timestamp");
        String dress = intent.getStringExtra("dress_code");

        TextView textView1 = findViewById(R.id.tampil_title);
        TextView textView2 = findViewById(R.id.tampil_description);
        TextView textView3 = findViewById(R.id.tampil_location);
        TextView textView4 = findViewById(R.id.tampil_time);
        TextView textView5 = findViewById(R.id.tampil_dress);

        textView1.setText(Html.fromHtml(event_title));
        textView2.setText(Html.fromHtml(event_desc));
        textView3.setText(Html.fromHtml(location));
        textView4.setText(Html.fromHtml(time));
        textView5.setText(Html.fromHtml(dress));


    }
}
