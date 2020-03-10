package com.example.test1.market_button;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.test1.R;
import com.example.test1.market;

public class market_item1 extends Fragment {
  /*  ImageButton image_b1;
    FrameLayout fram;
    TextView text1_1,text1_2;*/
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.market_button_1, container, false);
        /*image_b1=(ImageButton)view.findViewById(R.id.imagebtn_item1);
        fram=(FrameLayout)view.findViewById(R.id.fram);
        text1_1=(TextView)view.findViewById(R.id.text1_1);
        text1_2=(TextView)view.findViewById(R.id.text2_2);*/

        return view;
    }



}