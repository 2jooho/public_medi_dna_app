package com.example.test1.sensor_subbutton;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.test1.R;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class sensor_fragment_page2_pump extends Fragment {
    private ImageView radi;
    TextView text;
    Button btn;
    String str2;
    SeekBar bar;
    @Nullable
    public int number=0;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.sensor_fragment_page2_pump, container, false);
        LinearLayout layout = (LinearLayout) v.findViewById(R.id.fragment_url);
        text=v.findViewById(R.id.pump_text);
        btn=(Button)v.findViewById(R.id.btn);
        btn=(Button)v.findViewById(R.id.btn);
        bar=(SeekBar)v.findViewById(R.id.bar);
        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                number=bar.getProgress();
                update();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                number=bar.getProgress();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                number=bar.getProgress();
            }
        });
        MyClientTask myClientTask = new MyClientTask("192.168.0.21",9900,"auto","pump");
        myClientTask.execute();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyClientTask myClientTask = new MyClientTask("192.168.0.21",9900,"auto_mois",text.getText().toString());
                myClientTask.execute();
            }
        });

        return v;
    }
    public void update(){
        text.setText(new StringBuilder().append(number));
        // seekbar의 값에 따라 TextView로 보여주고 화면을 바꾸기 위해 정의한 함수
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
                System.out.println(new String(arr,"UTF-8").substring(0,4));

                str2 = new String(arr,"UTF-8").substring(0,4);

                text.setText(str2);

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