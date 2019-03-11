package com.example.ignite;

import android.content.Intent;
import android.net.Uri;
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
        view.findViewById(R.id.card_sponsor).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.iplockchain.com"));
                startActivity(intent);
            }
        });
        return view;
    }

}
