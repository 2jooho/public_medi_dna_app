package com.example.test1.sensor_subbutton;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;


import com.example.test1.R;


public class sensor_sub1 extends Fragment  {
    private FragmentManager fragmentManager;
    private sensor_fragment_page1_fan sensor_fragment_page1_fan;
    private com.example.test1.sensor_subbutton.sensor_fragment_page1_led sensor_fragment_page1_led;
    private com.example.test1.sensor_subbutton.sensor_fragment_page1_pump sensor_fragment_page1_pump;
    private com.example.test1.sensor_subbutton.sensor_fragment_page1_moter sensor_fragment_page1_moter;
    private com.example.test1.sensor_subbutton.sensor_fragment_page1_th sensor_fragment_page1_th;
    private FragmentTransaction transaction;
    ImageButton fan,led,pump,moter,th;
    TextView fan_text, led_text, pump_text, moter_text, th_text;
    @Nullable
//    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sensor_page1, container, false);

        fan=(ImageButton)view.findViewById(R.id.fan);
        led=(ImageButton)view.findViewById(R.id.led);
        pump=(ImageButton)view.findViewById(R.id.pump);
        moter=(ImageButton)view.findViewById(R.id.moter);
        th=(ImageButton)view.findViewById(R.id.th);
        fan_text=(TextView)view.findViewById(R.id.fan_text);
        led_text=(TextView)view.findViewById(R.id.led_text);
        pump_text=(TextView)view.findViewById(R.id.pump_text);
        moter_text=(TextView)view.findViewById(R.id.moter_text);
        th_text=(TextView)view.findViewById(R.id.th_text);
        fragmentManager=getFragmentManager();
        sensor_fragment_page1_fan= new sensor_fragment_page1_fan();
        sensor_fragment_page1_led= new sensor_fragment_page1_led();
        sensor_fragment_page1_pump= new sensor_fragment_page1_pump();
        sensor_fragment_page1_moter= new sensor_fragment_page1_moter();
        sensor_fragment_page1_th= new sensor_fragment_page1_th();


        transaction =fragmentManager.beginTransaction();
        transaction.replace(R.id.lottie_layout, sensor_fragment_page1_fan).commitAllowingStateLoss();

        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.lottie_layout, sensor_fragment_page1_fan).commitAllowingStateLoss();
                sensor_out();
                fan.setBackgroundResource(R.drawable.fan_w);
                fan_text.setTextColor(Color.parseColor("#ffffff"));
            }
        });
        led.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.lottie_layout, sensor_fragment_page1_led).commitAllowingStateLoss();
                sensor_out();
                led.setBackgroundResource(R.drawable.light_w);
                led_text.setTextColor(Color.parseColor("#ffffff"));
            }
        });
        pump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.lottie_layout, sensor_fragment_page1_pump).commitAllowingStateLoss();
                sensor_out();
                pump.setBackgroundResource(R.drawable.pump_w);
                pump_text.setTextColor(Color.parseColor("#ffffff"));
            }
        });
        moter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.lottie_layout, sensor_fragment_page1_moter).commitAllowingStateLoss();
                sensor_out();
                moter.setBackgroundResource(R.drawable.motor_w);
                moter_text.setTextColor(Color.parseColor("#ffffff"));
            }
        });
        th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.lottie_layout, sensor_fragment_page1_th).commitAllowingStateLoss();
                sensor_out();
                th.setBackgroundResource(R.drawable.temper_w);
                th_text.setTextColor(Color.parseColor("#ffffff"));
            }
        });


        return view;

    }

   /* @SuppressLint("ResourceAsColor")
    public void clickHandler(View view)
    {
        transaction = fragmentManager.beginTransaction();

        switch(view.getId())
        {
            case R.id.fan:
                transaction.replace(R.id.lottie_layout, sensor_fragment_page1_fan).commitAllowingStateLoss();
                sensor_out();
                fan.setBackgroundResource(R.drawable.fan_w);
                fan_text.setTextColor(Color.parseColor("#ffffff"));
                break;

            case R.id.led:
                transaction.replace(R.id.lottie_layout, sensor_fragment_page1_led).commitAllowingStateLoss();
                sensor_out();
                led.setBackgroundResource(R.drawable.light_w);
                led_text.setTextColor(Color.parseColor("#ffffff"));
                break;

            case R.id.pump:
                transaction.replace(R.id.lottie_layout, sensor_fragment_page1_pump).commitAllowingStateLoss();
                sensor_out();
                pump.setBackgroundResource(R.drawable.pump_w);
                pump_text.setTextColor(Color.parseColor("#ffffff"));
                break;

            case R.id.moter:
                transaction.replace(R.id.lottie_layout, sensor_fragment_page1_moter).commitAllowingStateLoss();
                sensor_out();
                moter.setBackgroundResource(R.drawable.motor_w);
                moter_text.setTextColor(Color.parseColor("#ffffff"));
                break;
            case R.id.th:
                transaction.replace(R.id.lottie_layout, sensor_fragment_page1_th).commitAllowingStateLoss();
                sensor_out();
                th.setBackgroundResource(R.drawable.temper_w);
                th_text.setTextColor(Color.parseColor("#ffffff"));
                break;


        }

    }*/
    public void sensor_out(){
        fan.setBackgroundResource(R.drawable.fan_b);
        led.setBackgroundResource(R.drawable.light_b);
        pump.setBackgroundResource(R.drawable.pump_b);
        moter.setBackgroundResource(R.drawable.motor_b);
        th.setBackgroundResource(R.drawable.temper_b);
        fan_text.setTextColor(Color.parseColor("#3A404C"));
        led_text.setTextColor(Color.parseColor("#3A404C"));
        pump_text.setTextColor(Color.parseColor("#3A404C"));
        moter_text.setTextColor(Color.parseColor("#3A404C"));
        th_text.setTextColor(Color.parseColor("#3A404C"));
    }
}