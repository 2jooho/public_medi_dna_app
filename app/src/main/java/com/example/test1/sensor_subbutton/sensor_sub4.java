package com.example.test1.sensor_subbutton;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
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
import android.view.ViewManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.airbnb.lottie.animation.content.Content;
import com.example.test1.R;


public class sensor_sub4 extends Fragment  {


    ImageButton plant_btn1,plant_btn2,plant_btn3,plant_btn4,back;
    LinearLayout lin;
    private View contentView;

    @Nullable
//    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.sensor_page4, container, false);
        lin=(LinearLayout)view.findViewById(R.id.lin);

        plant_btn1=(ImageButton)view.findViewById(R.id.plant_btn1);
        plant_btn2=(ImageButton)view.findViewById(R.id.plant_btn2);
        plant_btn3=(ImageButton)view.findViewById(R.id.plant_btn3);
        plant_btn4=(ImageButton)view.findViewById(R.id.plant_btn4);


        plant_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                final LinearLayout linear = (LinearLayout)inflater.inflate(R.layout.sensor_plant1_information, null);



                //파라미터를 세팅해줌

                LinearLayout.LayoutParams paramlinear = new LinearLayout.LayoutParams(

                        LinearLayout.LayoutParams.WRAP_CONTENT,

                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                back=(ImageButton)linear.findViewById(R.id.back);
                paramlinear.setMargins(155,100,0,100);
                //윈도우에 추가시킴
                getActivity().addContentView(linear, paramlinear);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ViewGroup parentViewGroup = (ViewGroup) linear.getParent();
                        parentViewGroup.removeView(linear);
                    }
                });

            }
        });
        plant_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                final LinearLayout linear = (LinearLayout)inflater.inflate(R.layout.sensor_plant2_information, null);



                //파라미터를 세팅해줌

                LinearLayout.LayoutParams paramlinear = new LinearLayout.LayoutParams(

                        LinearLayout.LayoutParams.WRAP_CONTENT,

                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                back=(ImageButton)linear.findViewById(R.id.back);
                paramlinear.setMargins(155,100,0,100);
                //윈도우에 추가시킴
                getActivity().addContentView(linear, paramlinear);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ViewGroup parentViewGroup = (ViewGroup) linear.getParent();
                        parentViewGroup.removeView(linear);
                    }
                });

            }
        });
        plant_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                final LinearLayout linear = (LinearLayout)inflater.inflate(R.layout.sensor_plant3_information, null);



                //파라미터를 세팅해줌

                LinearLayout.LayoutParams paramlinear = new LinearLayout.LayoutParams(

                        LinearLayout.LayoutParams.WRAP_CONTENT,

                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                back=(ImageButton)linear.findViewById(R.id.back);
                paramlinear.setMargins(155,100,0,100);
                //윈도우에 추가시킴
                getActivity().addContentView(linear, paramlinear);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ViewGroup parentViewGroup = (ViewGroup) linear.getParent();
                        parentViewGroup.removeView(linear);
                    }
                });

            }
        });
        plant_btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                final LinearLayout linear = (LinearLayout)inflater.inflate(R.layout.sensor_plant4_information, null);



                //파라미터를 세팅해줌

                LinearLayout.LayoutParams paramlinear = new LinearLayout.LayoutParams(

                        LinearLayout.LayoutParams.WRAP_CONTENT,

                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                back=(ImageButton)linear.findViewById(R.id.back);
                paramlinear.setMargins(155,100,0,100);
                //윈도우에 추가시킴
                getActivity().addContentView(linear, paramlinear);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ViewGroup parentViewGroup = (ViewGroup) linear.getParent();
                        parentViewGroup.removeView(linear);
                    }
                });

            }
        });
        return view;

    }

   /* @SuppressLint("ResourceAsColor")
    public void clickHandler(View view)
    {

        switch(view.getId()) {
            case R.id.plant_btn1:
                LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                LinearLayout linear = (LinearLayout) inflater.inflate(R.layout.sensor_plant1_information, null);


                //파라미터를 세팅해줌

                LinearLayout.LayoutParams paramlinear = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

                //윈도우에 추가시킴

                getActivity().addContentView(linear, paramlinear);

            break;

        }

    }*/

}