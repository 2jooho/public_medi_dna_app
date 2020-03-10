package com.example.test1.sensor_subbutton;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.example.test1.R;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class sensor_fragment_page1_pump extends Fragment {
    String str2;
    LottieAnimationView animationView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.sensor_fragment_page1_pump, container, false);
        animationView = v.findViewById(R.id.lottieAnimView);
        // setUpAnimation(animationView);
        MyClientTask myClientTask = new MyClientTask("192.168.0.21",9900,"information","pump_q");
        myClientTask.execute();
        return v;
    }


    private void setUpAnimation(LottieAnimationView animationView,int a) {
        // 재생할 애니메이션 넣어준다.
        animationView.setAnimation("water.json");
        // 반복횟수를 무한히 주고 싶을 땐 LottieDrawable.INFINITE or 원하는 횟수
        if(a==1)
            animationView.setRepeatCount(LottieDrawable.INFINITE);
        else
            animationView.setRepeatCount(0);

        // 시작
        animationView.playAnimation();
    }
    public class MyClientTask extends AsyncTask<Void, Void, Void> {
        String dstAddress;
        int dstPort;
        String response = "";
        String response2 = "";
        String myMessage = "";
        String myMessage2 = "";

        //constructor
        MyClientTask(String addr, int port, String message, String message2) {
            dstAddress = addr;
            dstPort = port;
            myMessage = message;
            myMessage2 = message2;
        }
        @Override
        protected Void doInBackground(Void... arg0) {

            Socket socket = null;
            // Socket socket2 = null;
            myMessage = myMessage.toString();
            myMessage2 = myMessage2.toString();
            try {
                socket = new Socket(dstAddress, dstPort);
                //   socket2 = new Socket(dstAddress, dstPort);
                //송신
                OutputStream out = socket.getOutputStream();
                OutputStream out2 = socket.getOutputStream();
                out.write(myMessage.getBytes());
                out2.write(myMessage2.getBytes());
                //수신
                byte []arr = new byte[100];

                InputStream in = socket.getInputStream();
                in.read(arr);
                System.out.println(new String(arr,"UTF-8").substring(0,3));

                str2 = new String(arr,"UTF-8").substring(0,3);

                if(str2.equals("onn")){
                    setUpAnimation(animationView,1);
                }
                else{
                    setUpAnimation(animationView,0);
                }
            } catch (UnknownHostException e) {

                e.printStackTrace();
                response = "UnknownHostException: " + e.toString();
            } catch (IOException e) {

                e.printStackTrace();
                response = "IOException: " + e.toString();
            }finally{
                if(socket != null){
                    try {
                        socket.close();
                    } catch (IOException e) {

                        e.printStackTrace();
                    }
                }
            }
            return null;
        }

/*    @Override
    protected void onPostExecute(Void result) {
        recieveText.setText(str2);
        super.onPostExecute(result);
    }*/
    }

}