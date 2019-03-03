package com.example.ignite;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toolbar;

import java.util.ArrayList;

public class AllEventSlider extends AppCompatActivity {
    ViewPager viewPager;
    SliderAdapter sliderAdapter;
    private LinearLayout dotlayout;
    private ImageView[] dots;
    private ImageButton prevfloatingActionButton,nextfloatingActionButton;
    private ArrayList<Events> eventsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_event_slider);
        final Intent intent=getIntent();
        prevfloatingActionButton=findViewById(R.id.fabprev);
        nextfloatingActionButton=findViewById(R.id.fabnext);
        viewPager =  findViewById(R.id.all_slider);
        Toolbar toolbar=findViewById(R.id.sliderToolbar);

        eventsList=new ArrayList<>();
        final int[] curr = {intent.getIntExtra("current", 0)};
            toolbar.setTitle("Events");

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent mintent=new Intent(AllEventSlider.this,MainActivity.class);
                    startActivity(mintent);



            }
        });
        if(Build.VERSION.SDK_INT>=21){
            Window window=this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.tabunSelected));
        }
        eventsList=intent.getParcelableArrayListExtra("list");
        final int items=intent.getIntExtra("items",13);
        sliderAdapter = new SliderAdapter(this,eventsList);
        viewPager.setAdapter(sliderAdapter);

        viewPager.setCurrentItem(curr[0]);
//        dotlayout=findViewById(R.id.dotslayout);
//        createDots(curr[0],items);
//        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int i, float v, int i1) {
//
//            }
//
//            @Override
//            public void onPageSelected(int i) {
//                    createDots(i,items);
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int i) {
//
//            }
//        });
        if(curr[0]==0){
            prevfloatingActionButton.setVisibility(View.INVISIBLE);
        }
        if (curr[0]==items-1){
            nextfloatingActionButton.setVisibility(View.INVISIBLE);
        }
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if(curr[0]==0){
                    prevfloatingActionButton.setVisibility(View.INVISIBLE);
                }else{
                    prevfloatingActionButton.setVisibility(View.VISIBLE);
                }
                if(curr[0]==items-1){
                    nextfloatingActionButton.setVisibility(View.INVISIBLE);
                }else{
                    nextfloatingActionButton.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        prevfloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(curr[0]>0){
                    curr[0] -=1;
                }
                viewPager.setCurrentItem(curr[0]);
            }
        });
        nextfloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(curr[0]<items-1){
                    curr[0]+=1;
                }
                viewPager.setCurrentItem(curr[0]);
            }
        });
    }
//    private void createDots(int currpos,int total){
//        if(dotlayout!=null){
//            dotlayout.removeAllViews();
//        }
//        dots=new ImageView[total];
//        for(int i=0;i<total;i++){
//            dots[i]=new ImageView(this);
//            if(i==currpos){
//                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.activedots));
//            }else {
//                dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.defaultdots));
//            }
//            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
//                    ViewGroup.LayoutParams.MATCH_PARENT);
//            params.setMargins(12,0,12,0);
//            params.weight=1.0f;
//            dotlayout.addView(dots[i],params);
//
//            final int finalI = i;
//            dots[i].setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    viewPager.setCurrentItem(finalI);
//                }
//            });

}