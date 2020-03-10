package com.example.test1;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    Button btn1,btn2;
    TextView line1, line2;
    private FragmentManager fragmentManager;
    private aFragment FragmentA;
    private bFragment FragmentB;
    private FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=(Button)findViewById(R.id.medina);
        btn2=(Button)findViewById(R.id.parm);
        line1=(TextView)findViewById(R.id.line1);
        line2=(TextView)findViewById(R.id.line2);

        fragmentManager=getSupportFragmentManager();

        FragmentA= new aFragment();
        FragmentB= new bFragment();

        transaction =fragmentManager.beginTransaction();
        transaction.replace(R.id.framelayout, FragmentA).commitAllowingStateLoss();


        }
    @SuppressLint("ResourceAsColor")
    public void clickHandler(View view)
    {
        transaction = fragmentManager.beginTransaction();

        switch(view.getId())
        {
            case R.id.medina:
                transaction.replace(R.id.framelayout, FragmentA).commitAllowingStateLoss();
               line1.setBackgroundResource(R.drawable.shape);
                line2.setBackgroundResource(R.color.visible);
                btn1.setTextColor(Color.parseColor("#000000"));
                btn2.setTextColor(R.color.enable);
                break;

            case R.id.parm:
                transaction.replace(R.id.framelayout, FragmentB).commitAllowingStateLoss();
                line1.setBackgroundResource(R.color.visible);
                line2.setBackgroundResource(R.drawable.shape);
                btn1.setTextColor(R.color.enable);
                btn2.setTextColor(Color.parseColor("#000000"));
                break;
        }
    }
    }

