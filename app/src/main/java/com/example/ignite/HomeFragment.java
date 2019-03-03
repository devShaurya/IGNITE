package com.example.ignite;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class HomeFragment extends Fragment {
    private TextView title;
    public HomeFragment(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){

        View view= inflater.inflate(R.layout.fragment_home,container,false);
//        title=view.findViewById(R.id.home_title);
        ImageView imageView=view.findViewById(R.id.logoimage);
        RelativeLayout relativeLayout =view.findViewById(R.id.logorel);
        AnimationDrawable animationDrawable = (AnimationDrawable) relativeLayout.getBackground();

        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);

        animationDrawable.start();
        return view;
    }

}
