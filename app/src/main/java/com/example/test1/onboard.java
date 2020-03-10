package com.example.test1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;


public class onboard extends AppIntro {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_onboard);
        SharedPreferences prefs=getSharedPreferences("isFirstRun", MODE_PRIVATE);
        boolean isFirstRun = prefs.getBoolean("isFirstRun",true);
        if(isFirstRun)
        {

            addSlide(AppIntroFragment.newInstance("First App Into", "First App Intro Details",
                    R.drawable.one, ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary)));
            addSlide(AppIntroFragment.newInstance("Second App Into", "Second App Intro Details",
                    R.drawable.two, ContextCompat.getColor(getApplicationContext(), R.color.colorAccent)));
            addSlide(AppIntroFragment.newInstance("Third App Into", "Third App Intro Details",
                    R.drawable.three, ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryDark)));

            prefs.edit().putBoolean("isFirstRun",false).apply();
        }
        else{
            Intent newIntent = new Intent(getApplicationContext(), login.class);
            startActivity(newIntent);

        }
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        Intent intent=new Intent(getApplicationContext(),login.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        Intent intent=new Intent(getApplicationContext(),login.class);
        startActivity(intent);
        finish();
    }


}
