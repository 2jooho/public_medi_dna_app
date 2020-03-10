package com.example.test1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
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
import com.example.test1.gene_result.aging_result;
import com.example.test1.gene_result.alope_result;
import com.example.test1.gene_result.bmi_result;
import com.example.test1.gene_result.caffeine_result;
import com.example.test1.gene_result.elastic_result;
import com.example.test1.gene_result.gluco_result;
import com.example.test1.gene_result.hair_result;
import com.example.test1.gene_result.male_result;
import com.example.test1.gene_result.pigment_result;
import com.example.test1.gene_result.pres_result;
import com.example.test1.gene_result.total_result;
import com.example.test1.gene_result.trigly_result;
import com.example.test1.gene_result.vita_result;

import java.util.ArrayList;


public class dna_information extends AppCompatActivity {

   ImageButton[] imagebtn=new ImageButton[20];
     TextView[] textview=new TextView[20];
     TextView[] text_item=new TextView[20];
     TextView[] text_gene=new TextView[20];
     int[] btn_name={R.id.imagebtn_bmi,R.id.imagebtn_trigly, R.id.imagebtn_total
            ,R.id.imagebtn_glucose,R.id.imagebtn_pres, R.id.imagebtn_caffe,R.id.imagebtn_aging,
            R.id.imagebtn_elastic, R.id.imagebtn_pig, R.id.imagebtn_male , R.id.imagebtn_alope
            , R.id.imagebtn_hair,R.id.imagebtn_vita};

     int[] tv_name={R.id.textview_bmi,R.id.textview_trigly,  R.id.textview_total
            ,R.id.textview_glucose,R.id.textview_pres, R.id.textview_caffe,R.id.textview_aging,
            R.id.textview_elastic, R.id.textview_pig, R.id.textview_male , R.id.textview_alope
            , R.id.textview_hair,R.id.textview_vita};

     int[] tv_item={R.id.item_bmi,R.id.item_trigly,  R.id.item_total
            ,R.id.item_glucose,R.id.item_pres, R.id.item_caffe,R.id.item_aging,
            R.id.item_elastic, R.id.item_pig, R.id.item_male , R.id.item_alope
            , R.id.item_hair,R.id.item_vita};
     int[] tv_gene={R.id.gene_bmi,R.id.gene_trigly,  R.id.gene_total
            ,R.id.gene_glucose,R.id.gene_pres, R.id.gene_caffe,R.id.gene_aging,
            R.id.gene_elastic, R.id.item_pig, R.id.gene_male , R.id.gene_alope
            , R.id.gene_hair,R.id.gene_vita};


    Button bmi,tri2, vita,total,pressure,pigmentaion, male, hair,glucose, elasticity
            ,cafe,aging, alopecia;

    private FragmentManager fragmentManager;
    private bmi_result Fragment_bmi;
    private trigly_result Fragment_trigly;
    private total_result Fragment_total;
    private gluco_result Fragment_gluco;
    private pres_result Fragment_pres;
    private caffeine_result Fragment_caffe;
    private aging_result Fragment_aging;
    private elastic_result Fragment_elasti;
    private pigment_result Fragment_pigment;
    private male_result Fragment_male;
    private alope_result Fragment_alope;
    private hair_result Fragment_hair;
    private vita_result Fragment_vita;
    private FragmentTransaction transaction;

    @SuppressLint("WrongViewCast")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dna_information);



        bmi=(Button)findViewById(R.id.imagebtn_bmi);
        tri2=(Button)findViewById(R.id.imagebtn_trigly);


        fragmentManager=getSupportFragmentManager();

        Fragment_bmi= new bmi_result();
        Fragment_trigly= new trigly_result();
        Fragment_total= new total_result();
        Fragment_gluco= new gluco_result();
        Fragment_pres= new pres_result();
        Fragment_caffe= new caffeine_result();
        Fragment_aging= new aging_result();
        Fragment_elasti= new elastic_result();
        Fragment_pigment= new pigment_result();
        Fragment_male= new male_result();
        Fragment_alope= new alope_result();
        Fragment_hair= new hair_result();
        Fragment_vita= new vita_result();

        transaction =fragmentManager.beginTransaction();
        transaction.replace(R.id.framelayout, Fragment_bmi).commitAllowingStateLoss();

        ViewPager viewPager = findViewById(R.id.viewPager);
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager());
// ViewPager와  FragmentAdapter 연결
        viewPager.setAdapter(fragmentAdapter);

        viewPager.setClipToPadding(false);
        int dpValue = 40;
       float d = getResources().getDisplayMetrics().density;
        int margin = (int) (dpValue * d);
        viewPager.setPadding(margin, 0, (margin*2)+(int)(20*d), 0);
        viewPager.setPageMargin(margin/20);

      /*  ArrayList<Integer> listImage = new ArrayList<>();
        listImage.add(1);

        for (int i = 0; i < listImage.size(); i++) {
            bmibutton imageFragment = new bmibutton();
            Bundle bundle = new Bundle();
            bundle.putInt("imgRes", listImage.get(i));
            imageFragment.setArguments(bundle);
            fragmentAdapter.addItem(imageFragment);
        }*/
        bmibutton imageFragment = new bmibutton();
        triglybutton2 imageFragment2 = new triglybutton2();
        total imageFragment3 = new total();
        glucose imageFragment4 = new glucose();
        pressure imageFragment5 = new pressure();
        caffeine imageFragment6 = new caffeine();
        aging imageFragment7 = new aging();
        elasticity imageFragment8 = new elasticity();
        pigmentation imageFragment9 = new pigmentation();
        male imageFragment10 = new male();
        alopecia imageFragment11 = new alopecia();
        hair imageFragment12 = new hair();
        vitamin imageFragment13 = new vitamin();

       // imageFragment.setArguments();
        fragmentAdapter.addItem(imageFragment);
        fragmentAdapter.addItem(imageFragment2);
        fragmentAdapter.addItem(imageFragment3);
        fragmentAdapter.addItem(imageFragment4);
        fragmentAdapter.addItem(imageFragment5);
        fragmentAdapter.addItem(imageFragment6);
        fragmentAdapter.addItem(imageFragment7);
        fragmentAdapter.addItem(imageFragment8);
        fragmentAdapter.addItem(imageFragment9);
        fragmentAdapter.addItem(imageFragment10);
        fragmentAdapter.addItem(imageFragment11);
        fragmentAdapter.addItem(imageFragment12);
        fragmentAdapter.addItem(imageFragment13);
        //
        fragmentAdapter.notifyDataSetChanged();




}

public void btn_chang(int num,int num2) {

    for(int i=num;i<num2;i++){
        imagebtn[i].setBackgroundResource(R.drawable.shape2);
        textview[i].setBackgroundResource(R.drawable.shape2);
        text_item[i].setTextColor(Color.parseColor("#3E3E3E"));
        text_gene[i].setTextColor(Color.parseColor("#3E3E3E"));
    }
}

    @SuppressLint("ResourceAsColor")
    public void clickHandler(View view)
    {
        transaction = fragmentManager.beginTransaction();

        for(int i=0;i<btn_name.length;i++){
            imagebtn[i]=(ImageButton)findViewById(btn_name[i]);
            textview[i]=(TextView)findViewById(tv_name[i]);
            text_item[i]=(TextView)findViewById(tv_item[i]);
            text_gene[i]=(TextView)findViewById(tv_gene[i]);
        }


        switch(view.getId())
        {

            case R.id.imagebtn_bmi:

                transaction.replace(R.id.framelayout, Fragment_bmi).commitAllowingStateLoss();
               btn_chang(0,4);
                imagebtn[0].setBackgroundResource(R.drawable.dna_btn);
                textview[0].setBackgroundResource(R.drawable.dna_btn2);
                text_item[0].setTextColor(Color.parseColor("#ffffff"));
                text_gene[0].setTextColor(Color.parseColor("#ffffff"));
                break;

            case R.id.imagebtn_trigly:
                transaction.replace(R.id.framelayout, Fragment_trigly).commitAllowingStateLoss();
                btn_chang(0,4);

                imagebtn[1].setBackgroundResource(R.drawable.dna_btn);
                textview[1].setBackgroundResource(R.drawable.dna_btn2);
                text_item[1].setTextColor(Color.parseColor("#ffffff"));
                text_gene[1].setTextColor(Color.parseColor("#ffffff"));
                break;

            case R.id.imagebtn_total:
                transaction.replace(R.id.framelayout, Fragment_total).commitAllowingStateLoss();
               btn_chang(0,4);

                imagebtn[2].setBackgroundResource(R.drawable.dna_btn);
                textview[2].setBackgroundResource(R.drawable.dna_btn2);
                text_item[2].setTextColor(Color.parseColor("#ffffff"));
                text_gene[2].setTextColor(Color.parseColor("#ffffff"));
                break;
            case R.id.imagebtn_glucose:
                transaction.replace(R.id.framelayout, Fragment_gluco).commitAllowingStateLoss();

                btn_chang(2,6);
                imagebtn[3].setBackgroundResource(R.drawable.dna_btn);
                textview[3].setBackgroundResource(R.drawable.dna_btn2);
                text_item[3].setTextColor(Color.parseColor("#ffffff"));
                text_gene[3].setTextColor(Color.parseColor("#ffffff"));
                break;
            case R.id.imagebtn_pres:
                transaction.replace(R.id.framelayout, Fragment_pres).commitAllowingStateLoss();
                btn_chang(2,6);
                imagebtn[4].setBackgroundResource(R.drawable.dna_btn);
                textview[4].setBackgroundResource(R.drawable.dna_btn2);
                text_item[4].setTextColor(Color.parseColor("#ffffff"));
                text_gene[4].setTextColor(Color.parseColor("#ffffff"));
                break;
            case R.id.imagebtn_caffe:
                transaction.replace(R.id.framelayout, Fragment_caffe).commitAllowingStateLoss();
                btn_chang(3,7);
                imagebtn[5].setBackgroundResource(R.drawable.dna_btn);
                textview[5].setBackgroundResource(R.drawable.dna_btn2);
                text_item[5].setTextColor(Color.parseColor("#ffffff"));
                text_gene[5].setTextColor(Color.parseColor("#ffffff"));
                break;
            case R.id.imagebtn_aging:
                transaction.replace(R.id.framelayout, Fragment_aging).commitAllowingStateLoss();
                btn_chang(4,9);
                imagebtn[6].setBackgroundResource(R.drawable.dna_btn);
                textview[6].setBackgroundResource(R.drawable.dna_btn2);
                text_item[6].setTextColor(Color.parseColor("#ffffff"));
                text_gene[6].setTextColor(Color.parseColor("#ffffff"));
                break;
            case R.id.imagebtn_elastic:
                transaction.replace(R.id.framelayout, Fragment_elasti).commitAllowingStateLoss();
                btn_chang(5,9);
                imagebtn[7].setBackgroundResource(R.drawable.dna_btn);
                textview[7].setBackgroundResource(R.drawable.dna_btn2);
                text_item[7].setTextColor(Color.parseColor("#ffffff"));
                text_gene[7].setTextColor(Color.parseColor("#ffffff"));
                break;
            case R.id.imagebtn_pig:
                transaction.replace(R.id.framelayout, Fragment_pigment).commitAllowingStateLoss();
                btn_chang(6,9);
                imagebtn[8].setBackgroundResource(R.drawable.dna_btn);
                textview[8].setBackgroundResource(R.drawable.dna_btn2);
                text_item[8].setTextColor(Color.parseColor("#ffffff"));
                text_gene[8].setTextColor(Color.parseColor("#ffffff"));
                break;
            case R.id.imagebtn_male:
                transaction.replace(R.id.framelayout, Fragment_male).commitAllowingStateLoss();
                btn_chang(7,12);
                imagebtn[9].setBackgroundResource(R.drawable.dna_btn);
                textview[9].setBackgroundResource(R.drawable.dna_btn2);
                text_item[9].setTextColor(Color.parseColor("#ffffff"));
                text_gene[9].setTextColor(Color.parseColor("#ffffff"));
                break;
            case R.id.imagebtn_alope:
                transaction.replace(R.id.framelayout, Fragment_alope).commitAllowingStateLoss();
                btn_chang(8,13);
                imagebtn[10].setBackgroundResource(R.drawable.dna_btn);
                textview[10].setBackgroundResource(R.drawable.dna_btn2);
                text_item[10].setTextColor(Color.parseColor("#ffffff"));
                text_gene[10].setTextColor(Color.parseColor("#ffffff"));
                break;
            case R.id.imagebtn_hair:
                transaction.replace(R.id.framelayout, Fragment_hair).commitAllowingStateLoss();
                btn_chang(9,13);
                imagebtn[11].setBackgroundResource(R.drawable.dna_btn);
                textview[11].setBackgroundResource(R.drawable.dna_btn2);
                text_item[11].setTextColor(Color.parseColor("#ffffff"));
                text_gene[11].setTextColor(Color.parseColor("#ffffff"));
                break;
            case R.id.imagebtn_vita:
                transaction.replace(R.id.framelayout, Fragment_vita).commitAllowingStateLoss();
                btn_chang(10,13);
                imagebtn[12].setBackgroundResource(R.drawable.dna_btn);
                textview[12].setBackgroundResource(R.drawable.dna_btn2);
                text_item[12].setTextColor(Color.parseColor("#ffffff"));
                text_gene[12].setTextColor(Color.parseColor("#ffffff"));
                break;
        }
    }



}
class FragmentAdapter extends FragmentPagerAdapter {

    // ViewPager에 들어갈 Fragment들을 담을 리스트
    private ArrayList<Fragment> fragments = new ArrayList<>();

    // 필수 생성자
    FragmentAdapter(FragmentManager fm) {
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


