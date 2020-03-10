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


public class sensor_sub2 extends Fragment  {
    private FragmentManager fragmentManager;
    private sensor_fragment_page2_temper sensor_fragment_page2_temper;
    private com.example.test1.sensor_subbutton.sensor_fragment_page2_hum sensor_fragment_page2_hum;
    private com.example.test1.sensor_subbutton.sensor_fragment_page2_light sensor_fragment_page2_light;
    private com.example.test1.sensor_subbutton.sensor_fragment_page2_pump sensor_fragment_page2_pump;
    private FragmentTransaction transaction;
    ImageButton sub2_temper,sub2_hum,sub2_light,sub2_pump;
    TextView temper_text, hum_text, light_text, pump_text;
    @Nullable
//    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sensor_page2, container, false);

        sub2_temper=(ImageButton)view.findViewById(R.id.sub2_temper);
        sub2_hum=(ImageButton)view.findViewById(R.id.sub2_hum);
        sub2_light=(ImageButton)view.findViewById(R.id.sub2_light);
        sub2_pump=(ImageButton)view.findViewById(R.id.sub2_pump);
        temper_text=(TextView)view.findViewById(R.id.temper_text);
        hum_text=(TextView)view.findViewById(R.id.hum_text);
        light_text=(TextView)view.findViewById(R.id.light_text);
        pump_text=(TextView)view.findViewById(R.id.pump_text);

        fragmentManager=getFragmentManager();
        sensor_fragment_page2_temper= new sensor_fragment_page2_temper();
        sensor_fragment_page2_hum= new sensor_fragment_page2_hum();
        sensor_fragment_page2_light= new sensor_fragment_page2_light();
        sensor_fragment_page2_pump= new sensor_fragment_page2_pump();



        transaction =fragmentManager.beginTransaction();
        transaction.replace(R.id.lottie_layout, sensor_fragment_page2_temper).commitAllowingStateLoss();
        sub2_temper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.lottie_layout, sensor_fragment_page2_temper).commitAllowingStateLoss();
                sensor_out();
                sub2_temper.setBackgroundResource(R.drawable.temper_w);
                temper_text.setTextColor(Color.parseColor("#ffffff"));
            }
        });
        sub2_hum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.lottie_layout, sensor_fragment_page2_hum).commitAllowingStateLoss();
                sensor_out();
                sub2_hum.setBackgroundResource(R.drawable.h_w);
                hum_text.setTextColor(Color.parseColor("#ffffff"));
            }
        });
        sub2_light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.lottie_layout, sensor_fragment_page2_light).commitAllowingStateLoss();
                sensor_out();
                sub2_light.setBackgroundResource(R.drawable.light_w);
                light_text.setTextColor(Color.parseColor("#ffffff"));
            }
        });
        sub2_pump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.lottie_layout, sensor_fragment_page2_pump).commitAllowingStateLoss();
                sensor_out();
                sub2_pump.setBackgroundResource(R.drawable.pump_w);
                pump_text.setTextColor(Color.parseColor("#ffffff"));
            }
        });


        return view;

    }

/*    @SuppressLint("ResourceAsColor")
    public void clickHandler(View view)
    {
        transaction = fragmentManager.beginTransaction();

        switch(view.getId())
        {
            case R.id.sub2_temper:
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.lottie_layout, sensor_fragment_page2_temper).commitAllowingStateLoss();
                sensor_out();
                sub2_temper.setBackgroundResource(R.drawable.temper_w);
                temper_text.setTextColor(Color.parseColor("#ffffff"));
                break;

            case R.id.sub2_hum:
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.lottie_layout, sensor_fragment_page2_hum).commitAllowingStateLoss();
                sensor_out();
                sub2_hum.setBackgroundResource(R.drawable.h_w);
                hum_text.setTextColor(Color.parseColor("#ffffff"));
                break;

            case R.id.sub2_light:
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.lottie_layout, sensor_fragment_page2_light).commitAllowingStateLoss();
                sensor_out();
                sub2_light.setBackgroundResource(R.drawable.light_w);
                light_text.setTextColor(Color.parseColor("#ffffff"));
                break;
            case R.id.sub2_pump:
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.lottie_layout, sensor_fragment_page2_pump).commitAllowingStateLoss();
                sensor_out();
                sub2_pump.setBackgroundResource(R.drawable.pump_w);
                pump_text.setTextColor(Color.parseColor("#ffffff"));
                break;
        }

    }*/
    public void sensor_out(){
        sub2_temper.setBackgroundResource(R.drawable.temper_b);
        sub2_hum.setBackgroundResource(R.drawable.h_b);
        sub2_light.setBackgroundResource(R.drawable.light_b);
        sub2_pump.setBackgroundResource(R.drawable.pump_b);
        temper_text.setTextColor(Color.parseColor("#3A404C"));
        hum_text.setTextColor(Color.parseColor("#3A404C"));
        light_text.setTextColor(Color.parseColor("#3A404C"));
        pump_text.setTextColor(Color.parseColor("#3A404C"));
    }

}