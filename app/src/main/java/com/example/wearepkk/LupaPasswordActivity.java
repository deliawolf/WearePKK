package com.example.wearepkk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;

public class LupaPasswordActivity extends AppCompatActivity {

    private static final String TAG = "LupaPasswordActivity";
    private EditText mUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lupa_password);
        mUsername = findViewById(R.id.username);

        com.google.android.material.button.MaterialButton klik_lupa_kirim_btn = findViewById(R.id.lupa_kirim_btn);

        com.google.android.material.button.MaterialButton klik_lupa_kembali_btn = findViewById(R.id.lupa_kembali_btn);

        klik_lupa_kembali_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LupaPasswordActivity.this,LoginActivity.class));
            }
        });
        klik_lupa_kirim_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth auth = FirebaseAuth.getInstance();
                String mUsername = "user@example.com";

                auth.sendPasswordResetEmail(mUsername)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Log.d(TAG, "Email sent.");
                                }
                            }
                        });
            }
        });

    }
}
