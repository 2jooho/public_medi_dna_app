package com.example.test1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;


import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;


public class aFragment extends Fragment {
    AutoScrollViewPager autoViewPager;
    Button dna_level,dna_market;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.main_fragment_a, container, false);
        LinearLayout layout = (LinearLayout) v.findViewById(R.id.fragment_url);

        ArrayList<Integer> data = new ArrayList<>(); //이미지 url를 저장하는 arraylist
        data.add(R.drawable.helth);
        data.add(R.drawable.market);
        data.add(R.drawable.helth);
        //data.add("https://www.gannett-cdn.com/-mm-/60f7e37cc9fdd931c890c156949aafce3b65fd8c/c=243-0-1437-898&r=x408&c=540x405/local/-/media/2017/03/14/USATODAY/USATODAY/636250854246773757-XXX-IMG-WTW-SPONGEBOB01-0105-1-1-NC9J38E8.JPG");

        autoViewPager = (AutoScrollViewPager) v.findViewById(R.id.autoViewPager);
        autoScrollAdapter scrollAdapter = new autoScrollAdapter(getActivity(), data);
      autoViewPager.setAdapter(scrollAdapter); //Auto Viewpager에 Adapter 장착
        autoViewPager.setInterval(3000); // 페이지 넘어갈 시간 간격 설정
        autoViewPager.startAutoScroll(); //Auto Scroll 시작



        dna_level=(Button)v.findViewById(R.id.dna_level);
        dna_market=(Button)v.findViewById(R.id.market);


        dna_level.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),dna_information.class);
                startActivity(intent);
            }
        });
    dna_market.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(getActivity(),market.class);
            startActivity(intent);
        }
    });
        return v;
    }


}
