package com.example.ignite;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SponsorsFragment extends Fragment {
    private TextView title;
    public SponsorsFragment(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){

        View view= inflater.inflate(R.layout.fragment_sponsor,container,false);

        return view;
    }

}
