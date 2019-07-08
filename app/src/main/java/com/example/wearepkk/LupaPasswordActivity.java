package com.example.wearepkk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LupaPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lupa_password);



        com.google.android.material.button.MaterialButton klik_lupa_kembali_btn = findViewById(R.id.lupa_kembali_btn);

        klik_lupa_kembali_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LupaPasswordActivity.this,LoginActivity.class));
            }
        });
    }
}
