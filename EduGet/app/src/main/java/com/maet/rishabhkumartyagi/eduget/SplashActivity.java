package com.maet.rishabhkumartyagi.eduget;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


import com.maet.rishabhkumartyagi.eduget.MainPage;

public class SplashActivity extends AppCompatActivity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;

    public void doit()
    {
        Intent i = new Intent(this, MainPage.class);
        startActivity(i);

        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                doit();

            }
        }, SPLASH_TIME_OUT);
    }

}