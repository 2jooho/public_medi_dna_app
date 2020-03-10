package com.example.test1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import android.support.v7.app.AppCompatActivity;

public class splashactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(),onboard.class));
            }
        },1*1500);


    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

}
