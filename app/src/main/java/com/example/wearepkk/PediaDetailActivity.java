package com.example.wearepkk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class PediaDetailActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedia_detail);

        Intent intent = getIntent();
        String pedia_title = intent.getStringExtra("title");
        String pedia_desc = intent.getStringExtra("description");

        TextView textView1 = findViewById(R.id.tampil_title);
        TextView textView2 = findViewById(R.id.tampil_description);

        textView1.setText(Html.fromHtml(pedia_title));
        textView2.setText(Html.fromHtml(pedia_desc));
    }
}
