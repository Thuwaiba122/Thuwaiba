package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.window.SplashScreen;

public class Splash extends AppCompatActivity {

      Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
            handler=new Handler();
            handler.postDelayed(new Runnable()
            {
                @Override
                public void run() {
                    Intent intent22=new Intent(Splash.this,MainActivity.class);
                    startActivity(intent22);
                    finish();
                }
            },3000);
        }
    }