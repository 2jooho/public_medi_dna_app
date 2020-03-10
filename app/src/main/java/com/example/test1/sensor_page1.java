package com.example.test1;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.test1.sensor_subbutton.sensor_fragment_page1_fan;
import com.example.test1.sensor_subbutton.sensor_sub1;
import com.example.test1.sensor_subbutton.sensor_sub2;
import com.example.test1.sensor_subbutton.sensor_sub3;
import com.example.test1.sensor_subbutton.sensor_sub4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class sensor_page1 extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4;
    TextView line1, line2,line3,line4;
    String str2;
    private FragmentManager fragmentManager;
    private sensor_sub1 sensor_sub1;
    private com.example.test1.sensor_subbutton.sensor_sub2 sensor_sub2;
    private com.example.test1.sensor_subbutton.sensor_sub3 sensor_sub3;
    private com.example.test1.sensor_subbutton.sensor_sub4 sensor_sub4;


    private FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_main);
        btn1=(Button)findViewById(R.id.information_btn);
        line1=(TextView)findViewById(R.id.information_line);
        btn2=(Button)findViewById(R.id.auto_btn);
        line2=(TextView)findViewById(R.id.auto_line);
        btn3=(Button)findViewById(R.id.sensor_btn);
        line3=(TextView)findViewById(R.id.sensor_line);
        btn4=(Button)findViewById(R.id.plant_btn);
        line4=(TextView)findViewById(R.id.plant_line);

        fragmentManager=getSupportFragmentManager();
        sensor_sub1= new sensor_sub1();
        sensor_sub2= new sensor_sub2();
        sensor_sub3= new sensor_sub3();
        sensor_sub4= new sensor_sub4();


        transaction =fragmentManager.beginTransaction();
        transaction.replace(R.id.framelayout, sensor_sub1).commitAllowingStateLoss();
}
    @SuppressLint("ResourceAsColor")
    public void clickHandler(View view)
    {
        transaction = fragmentManager.beginTransaction();

        switch(view.getId())
        {
            case R.id.information_btn:
            transaction.replace(R.id.framelayout, sensor_sub1).commitAllowingStateLoss();
                sensor_out();
                line1.setBackgroundColor(Color.parseColor("#D8DBE3"));
                btn1.setTextColor(Color.parseColor("#E1E1E1"));
          /*      MyClientTask myClientTask = new MyClientTask("192.168.0.21",9900,"information","fan_q");
                myClientTask.execute();*/
            break;
            case R.id.auto_btn:
                transaction.replace(R.id.framelayout, sensor_sub2).commitAllowingStateLoss();
                sensor_out();
                line2.setBackgroundColor(Color.parseColor("#D8DBE3"));
                btn2.setTextColor(Color.parseColor("#E1E1E1"));
                break;
            case R.id.sensor_btn:
                transaction.replace(R.id.framelayout, sensor_sub3).commitAllowingStateLoss();
                sensor_out();
                line3.setBackgroundColor(Color.parseColor("#D8DBE3"));
                btn3.setTextColor(Color.parseColor("#E1E1E1"));
                break;
            case R.id.plant_btn:
                transaction.replace(R.id.framelayout, sensor_sub4).commitAllowingStateLoss();
                sensor_out();
                line4.setBackgroundColor(Color.parseColor("#D8DBE3"));
                btn4.setTextColor(Color.parseColor("#E1E1E1"));
                break;
        }
    }
    public void sensor_out(){
        line1.setBackgroundColor(Color.parseColor("#00000000"));
        line2.setBackgroundColor(Color.parseColor("#00000000"));
        line3.setBackgroundColor(Color.parseColor("#00000000"));
        line4.setBackgroundColor(Color.parseColor("#00000000"));
        btn1.setTextColor(Color.parseColor("#838589"));
        btn2.setTextColor(Color.parseColor("#838589"));
        btn3.setTextColor(Color.parseColor("#838589"));
        btn4.setTextColor(Color.parseColor("#838589"));


    }

/*public class MyClientTask extends AsyncTask<Void, Void, Void> {
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
                sensor_fragment_page1_fan page1_fan =new sensor_fragment_page1_fan();


                System.out.println("1");
            }
            else{
                System.out.println("0");
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

*//*    @Override
    protected void onPostExecute(Void result) {
        recieveText.setText(str2);
        super.onPostExecute(result);
    }*//*
}*/
}
