package com.example.test1.gene_button;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.test1.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class triglybutton2 extends Fragment {
    TextView level_trigly;
    String disease_level;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.trigly_button2, container, false);

   /*     ImageView imageView = view.findViewById(R.id.imagebtn1);
        ImageView imageView2 = view.findViewById(R.id.imagebtn2);
         if (getArguments() != null) {
            Bundle args = getArguments();
    *//*        // MainActivity에서 받아온 Resource를 ImageView에 셋팅
            imageView.setImageResource(args.getInt("imgRes"));*//*
        }*/
        level_trigly=(TextView)view.findViewById(R.id.level_trigly);
        String disease = "Triglycerides";
        String user_num = "000001";
        try {
            disease_level = new CustomTask().execute(disease, user_num).get();
            level_trigly.setText(disease_level);
            text_color();
        }catch (Exception e){
            e.printStackTrace();
        }
        return view;
    }
    public void text_color(){
        if(disease_level.equals("평균    "))
            level_trigly.setTextColor(Color.parseColor("#C8900F"));
        else if(disease_level=="낮음    ")
            level_trigly.setTextColor(Color.parseColor("#0D4D1D"));
        else
            level_trigly.setTextColor(Color.parseColor("#A90C0C"));
    }
    class CustomTask extends AsyncTask<String, Void, String> {
        String sendMsg, receiveMsg;
        @Override
        // doInBackground의 매개값이 문자열 배열인데요. 보낼 값이 여러개일 경우를 위해 배열로 합니다.
        protected String doInBackground(String... strings) {
            try {
                String str;
                URL url = new URL("http://best54.cafe24.com/androidjsp/dna_information_btn.jsp");//보낼 jsp 주소를 ""안에 작성합니다.
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                conn.setRequestMethod("POST");//데이터를 POST 방식으로 전송합니다.
                OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());
                sendMsg = "disease="+strings[0]+"&user_num="+strings[1];;//보낼 정보인데요. GET방식으로 작성합니다. ex) "id=rain483&pwd=1234";
                //회원가입처럼 보낼 데이터가 여러 개일 경우 &로 구분하여 작성합니다.
                osw.write(sendMsg);//OutputStreamWriter에 담아 전송합니다.
                osw.flush();
                //jsp와 통신이 정상적으로 되었을 때 할 코드들입니다.
                if(conn.getResponseCode() == conn.HTTP_OK) {
                    InputStreamReader tmp = new InputStreamReader(conn.getInputStream(), "UTF-8");
                    BufferedReader reader = new BufferedReader(tmp);
                    StringBuffer buffer = new StringBuffer();
                    //jsp에서 보낸 값을 받겠죠?
                    while ((str = reader.readLine()) != null) {
                        buffer.append(str);
                    }
                    receiveMsg = buffer.toString();

                } else {
                    Log.i("통신 결과", conn.getResponseCode()+"에러");
                    // 통신이 실패했을 때 실패한 이유를 알기 위해 로그를 찍습니다.
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //jsp로부터 받은 리턴 값입니다.
            return receiveMsg;
        }
    }


}