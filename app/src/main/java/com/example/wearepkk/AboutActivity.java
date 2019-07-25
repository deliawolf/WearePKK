package com.example.wearepkk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        View aboutPage = new AboutPage(this)
                .setImage(R.drawable.splash)
                .setDescription("WE ARE PKK adalah aplikasi yang dibangun dengan niat untuk membantu anggota pkk untuk lebih mudah dalam mendapatkan infromasi seputar pkk sendiri, seperti event, dan juga dibangun dengan berisi info dari buku saku pkk")
                .addItem(new Element().setTitle("Version 1.0"))
                .addGroup("Connect with us")
                .addEmail("aditya.maulana.rojakt@gmail.com")
                .addFacebook("aditya.rozak")
                .addPlayStore("com.ideashower.readitlater.pro")
                .create();

        setContentView(aboutPage);
    }
}
