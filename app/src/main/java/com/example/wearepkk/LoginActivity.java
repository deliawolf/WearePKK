package com.example.wearepkk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        com.google.android.material.button.MaterialButton klik_login = findViewById(R.id.login_btn);
        com.google.android.material.button.MaterialButton klik_lupa_password = findViewById(R.id.lupa_btn);
        com.google.android.material.button.MaterialButton klik_registrasi = findViewById(R.id.register_btn);

        klik_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
            }
        });

        klik_lupa_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,LupaPasswordActivity.class));
            }
        });
        klik_registrasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
    }
}
