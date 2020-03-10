package com.example.test1.sensor_subbutton;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.RotateAnimation;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.example.test1.R;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.EventListener;


public class sensor_fragment_page2_temper extends Fragment  {
    String str2;
    private ImageView radi;
    float _deltaX, _deltaY;
    TextView text;
    Button btn;
    private double mCurrAngle = 0;
    private double mPrevAngle = 0;
    private double mAddAngle = 0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.sensor_fragment_page2_temper, container, false);
        LinearLayout layout = (LinearLayout) v.findViewById(R.id.fragment_url);
        radi = (ImageView)v.findViewById(R.id.radi);
        Display display = ((WindowManager)getActivity().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        _deltaX = display.getWidth() ;
        _deltaY = display.getHeight() ;
        text=(TextView)v.findViewById(R.id.tem_text);
        btn=(Button)v.findViewById(R.id.btn);
       v.setOnTouchListener(new View.OnTouchListener() {
           @Override
           public boolean onTouch(View v, MotionEvent motionEvent) {
               final float centerOfWidth = _deltaX() / 2;
               final float centerOfHeight = _deltaY()/ 2;
               final float x = motionEvent.getX();
               final float y = motionEvent.getY();

               switch (motionEvent.getAction()) {
                   case MotionEvent.ACTION_DOWN:
                       mCurrAngle = Math.toDegrees(Math.atan2(x - centerOfWidth, centerOfHeight - y));
                       break;


                   case MotionEvent.ACTION_MOVE:
                       mPrevAngle = mCurrAngle;
                       mCurrAngle = Math.toDegrees(Math.atan2(x - centerOfWidth, centerOfHeight - y));
                       animate(this, mAddAngle, mAddAngle + mCurrAngle - mPrevAngle);
                       mAddAngle += mCurrAngle - mPrevAngle;

                       int i=10;
                       int value2=0;
                       if(0 <= mAddAngle&&mAddAngle<=180) {

                           value2 = (int) (mAddAngle / 9);
                           i = i + value2;
                           text.setText(String.valueOf(i));
                       }
                       else {
                           text.setText("30");
                       }
                       break;

                   case MotionEvent.ACTION_UP:
                       break;
               }
               return true;
           }
       });
        MyClientTask myClientTask = new MyClientTask("192.168.0.21",9900,"auto","tmp");
        myClientTask.execute();
       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               MyClientTask myClientTask = new MyClientTask("192.168.0.21",9900,"auto_tmp",text.getText().toString().substring(0,2));
               myClientTask.execute();
           }
       });

        return v;
    }



   /* public boolean onTouchEvent(MotionEvent motionEvent)
    {

        final float centerOfWidth = _deltaX() / 2;
        final float centerOfHeight = _deltaY()/ 2;
        final float x = motionEvent.getX();
        final float y = motionEvent.getY();

        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mCurrAngle = Math.toDegrees(Math.atan2(x - centerOfWidth, centerOfHeight - y));
                break;


            case MotionEvent.ACTION_MOVE:
                mPrevAngle = mCurrAngle;
                mCurrAngle = Math.toDegrees(Math.atan2(x - centerOfWidth, centerOfHeight - y));
                animate(this, mAddAngle, mAddAngle + mCurrAngle - mPrevAngle);
                mAddAngle += mCurrAngle - mPrevAngle;
                text2.setText(String.valueOf(mAddAngle));
                int i=10;
                int value2=0;
                if(0 <= mAddAngle&&mAddAngle<=180) {

                    value2 = (int) (mAddAngle / 9);
                    i = i + value2;
                    text.setText(String.valueOf(i));
                }
                else {
                    text.setText("30");
                }
                break;

            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }*/

    private float _deltaY() {
        return _deltaY;
    }

    private float _deltaX() {
        return _deltaX;
    }

    private void animate(View.OnTouchListener view, double fromDegrees, double toDegrees) {
        final RotateAnimation rotate = new RotateAnimation((float) fromDegrees, (float) toDegrees,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(0);
        rotate.setFillAfter(true);
        radi.startAnimation(rotate);
    }
    private void rotate(View view, double fromDegrees, double toDegrees) {
        final RotateAnimation rotate = new RotateAnimation((float) fromDegrees, (float) toDegrees,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);


        rotate.setDuration(0);
        rotate.setFillAfter(true);


        view.startAnimation(rotate);
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

               int a= byteToint(arr);
                System.out.println(new String(arr,"UTF-8").substring(0,2));

                str2 = new String(arr,"UTF-8").substring(0,2);

              //  System.out.println(new String());

              // str2 = String.valueOf(a).substring(0,2);



                text.setText(str2+"º");

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
    public int byteToint(byte[] arr){
        return (arr[0] & 0xff)<<24 | (arr[1] & 0xff)<<16 | (arr[2] & 0xff)<<8 | (arr[3] & 0xff); }


}
