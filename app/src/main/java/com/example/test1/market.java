package com.example.test1;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.test1.gene_button.aging;
import com.example.test1.gene_button.alopecia;
import com.example.test1.gene_button.bmibutton;
import com.example.test1.gene_button.caffeine;
import com.example.test1.gene_button.elasticity;
import com.example.test1.gene_button.glucose;
import com.example.test1.gene_button.hair;
import com.example.test1.gene_button.male;
import com.example.test1.gene_button.pigmentation;
import com.example.test1.gene_button.pressure;
import com.example.test1.gene_button.total;
import com.example.test1.gene_button.triglybutton2;
import com.example.test1.gene_button.vitamin;
import com.example.test1.market_button.market_item1;
import com.example.test1.market_button.market_item2;
import com.example.test1.market_button.market_item3;
import com.example.test1.market_button.market_item4;
import com.example.test1.market_button.market_item5;

import java.util.ArrayList;


public class market extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4,btn5;

    ImageButton[] imagebtn=new ImageButton[6];
    TextView[] text_1=new TextView[6];
    TextView[] text_2=new TextView[6];
    FrameLayout[] framlay=new FrameLayout[6];
LocationManager manager;
    int[] btn_name={R.id.imagebtn_item1,R.id.imagebtn_item2, R.id.imagebtn_item3
            ,R.id.imagebtn_item4,R.id.imagebtn_item5,R.id.imagebtn_item5};

    int[] fram={R.id.fram1,R.id.fram2,  R.id.fram3
            ,R.id.fram4,R.id.fram5,R.id.fram5};

    int[] text2={R.id.text1_2,R.id.text2_2,  R.id.text3_2
            ,R.id.text4_2,R.id.text5_2,R.id.text5_2};
    int[] text1={R.id.text1_1,R.id.text2_1,  R.id.text3_1
            ,R.id.text4_1,R.id.text5_1,R.id.text5_1};

    private FragmentManager fragmentManager;
    private market_item1 Fragment_item1;
    private market_item2 Fragment_item2;
    private FragmentTransaction transaction;
   public LinearLayout market_big;

    @SuppressLint("WrongViewCast")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        manager = (LocationManager) getSystemService(LOCATION_SERVICE);
        for (int i = 0; i < btn_name.length; i++) {
            imagebtn[i] = (ImageButton) findViewById(btn_name[i]);
            text_1[i] = (TextView) findViewById(text1[i]);
            text_2[i] = (TextView) findViewById(text2[i]);
            framlay[i] = (FrameLayout) findViewById(fram[i]);

        }
        btn1=(Button)findViewById(R.id.imagebtn_item1);
        btn2=(Button)findViewById(R.id.imagebtn_item2);
        market_big=(LinearLayout)findViewById(R.id.market_big);

        ViewPager viewPager = findViewById(R.id.viewPager);
        FragmentAdapter_market fragmentAdapter = new FragmentAdapter_market(getSupportFragmentManager());
// ViewPager와  FragmentAdapter 연결
        viewPager.setAdapter(fragmentAdapter);

        viewPager.setClipToPadding(false);
        int dpValue = 40;
        float d = getResources().getDisplayMetrics().density;
        int margin = (int) (dpValue * d);
        viewPager.setPadding(margin, 0, (margin*2)+(int)(160*d), 0);
        viewPager.setPageMargin(margin/20);



        market_item1 imageFragment = new market_item1();
        market_item2 imageFragment2 = new market_item2();
        market_item3 imageFragment3 = new market_item3();
        market_item4 imageFragment4 = new market_item4();
        market_item5 imageFragment5 = new market_item5();

        // imageFragment.setArguments();
        fragmentAdapter.addItem(imageFragment);
        fragmentAdapter.addItem(imageFragment2);
        fragmentAdapter.addItem(imageFragment3);
        fragmentAdapter.addItem(imageFragment4);
        fragmentAdapter.addItem(imageFragment5);

        fragmentAdapter.notifyDataSetChanged();
    }
    @SuppressLint("ResourceAsColor")
    public void clickHandler(View view)
    {
        for (int i = 0; i < btn_name.length; i++) {
            imagebtn[i] = (ImageButton) findViewById(btn_name[i]);
            text_1[i] = (TextView) findViewById(text1[i]);
            text_2[i] = (TextView) findViewById(text2[i]);
            framlay[i] = (FrameLayout) findViewById(fram[i]);

        }
        switch(view.getId())
        {

            case R.id.imagebtn_item1:
                unclick();

          //      FrameLayout.LayoutParams fram_change1=(FrameLayout.LayoutParams)framlay[0].getLayoutParams();
            //    fram_change1.topMargin=0;
             //   framlay[0].setLayoutParams(fram_change1);

                market_big.setBackgroundResource(R.drawable.bugi_total);
                text_1[0].setBackgroundResource(R.drawable.stroke_market);
                text_2[0].setBackgroundColor(Color.parseColor("#00000000"));
                break;


        case R.id.imagebtn_item2:
            unclick();

           // FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
          //  FrameLayout.LayoutParams fram_change2=(FrameLayout.LayoutParams)framlay[1].getLayoutParams();
          //  fram_change2.topMargin=0;
           // framlay[1].setLayoutParams(fram_change2);
           // params=(FrameLayout.LayoutParams)framlay[1].getLayoutParams();
           // params.setMargins(0,0,0,0);
           // framlay[1].setLayoutParams(params);
            market_big.setBackgroundResource(R.drawable.two);
            text_1[1].setBackgroundResource(R.drawable.stroke_market);
            text_2[1].setBackgroundColor(Color.parseColor("#00000000"));
        break;


     case R.id.imagebtn_item3:
         unclick();


      //   FrameLayout.LayoutParams fram_change3=(FrameLayout.LayoutParams)framlay[2].getLayoutParams();
       //  fram_change3.topMargin=0;
       //  framlay[2].setLayoutParams(fram_change3);

         market_big.setBackgroundResource(R.drawable.danggam_total);
         text_1[2].setBackgroundResource(R.drawable.stroke_market);
         text_2[2].setBackgroundColor(Color.parseColor("#00000000"));
                break;


 case R.id.imagebtn_item4:
     unclick();


     //FrameLayout.LayoutParams fram_change4=(FrameLayout.LayoutParams)framlay[3].getLayoutParams();
   //  fram_change4.topMargin=0;
    // framlay[3].setLayoutParams(fram_change4);

     market_big.setBackgroundResource(R.drawable.cheonggong_total);
     text_1[3].setBackgroundResource(R.drawable.stroke_market);
     text_2[3].setBackgroundColor(Color.parseColor("#00000000"));
         break;




         case R.id.imagebtn_item5:
             unclick();


/*            FrameLayout.LayoutParams fram_change5=(FrameLayout.LayoutParams)framlay[4].getLayoutParams();
             fram_change5.topMargin=0;
            framlay[4].setLayoutParams(fram_change5);*/

             market_big.setBackgroundResource(R.drawable.huyuan);
             text_1[4].setBackgroundResource(R.drawable.stroke_market);
             text_2[4].setBackgroundColor(Color.parseColor("#00000000"));
         break;

         }
    }

    public void unclick(){
        for (int i = 0; i < btn_name.length; i++) {
            imagebtn[i] = (ImageButton) findViewById(btn_name[i]);
            text_1[i] = (TextView) findViewById(text1[i]);
            text_2[i] = (TextView) findViewById(text2[i]);
            framlay[i] = (FrameLayout) findViewById(fram[i]);
        }
       // FrameLayout.LayoutParams fram_change[]=new FrameLayout.LayoutParams[5];


    // fram_change[0]=(FrameLayout.LayoutParams)framlay[0].getLayoutParams();
        //    fram_change[0].topMargin=40;
          //  framlay[0].setLayoutParams(fram_change[0]);
            text_1[0].setBackgroundColor(Color.parseColor("#00000000"));
            text_2[0].setBackgroundColor(Color.parseColor("#4dD8DBE3"));

//        fram_change[1]=(FrameLayout.LayoutParams)framlay[1].getLayoutParams();
       // fram_change[1].topMargin=40;
//        framlay[1].setLayoutParams(fram_change[1]);
        text_1[1].setBackgroundColor(Color.parseColor("#00000000"));
        text_2[1].setBackgroundColor(Color.parseColor("#4dD8DBE3"));

        //fram_change[2]=(FrameLayout.LayoutParams)framlay[2].getLayoutParams();
      //  fram_change[2].topMargin=40;
      // framlay[2].setLayoutParams(fram_change[2]);
        text_1[2].setBackgroundColor(Color.parseColor("#00000000"));
        text_2[2].setBackgroundColor(Color.parseColor("#4dD8DBE3"));

       // fram_change[3]=(FrameLayout.LayoutParams)framlay[3].getLayoutParams();
       // fram_change[3].topMargin=40;
       // framlay[3].setLayoutParams(fram_change[3]);
        text_1[3].setBackgroundColor(Color.parseColor("#00000000"));
        text_2[3].setBackgroundColor(Color.parseColor("#4dD8DBE3"));

       // fram_change[4]=(FrameLayout.LayoutParams)framlay[4].getLayoutParams();
       // fram_change[4].topMargin=40;
       // framlay[4].setLayoutParams(fram_change[4]);

   //    text_1[5].setBackgroundColor(Color.parseColor("#00000000"));
   //    text_2[5].setBackgroundColor(Color.parseColor("#4dD8DBE3"));


    }






}
class FragmentAdapter_market extends FragmentPagerAdapter {

    // ViewPager에 들어갈 Fragment들을 담을 리스트
    private ArrayList<Fragment> fragments = new ArrayList<>();

    // 필수 생성자

    public FragmentAdapter_market(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    // List에 Fragment를 담을 함수
    void addItem(Fragment fragment) {
        fragments.add(fragment);
    }
}
