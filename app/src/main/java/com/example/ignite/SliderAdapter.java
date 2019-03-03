package com.example.ignite;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Button;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    List<Events> eventsArrayList;
    public SliderAdapter(Context context,ArrayList<Events>eventsArrayList){
        this.context=context;
        this.eventsArrayList=eventsArrayList;
    }

    @Override
    public int getCount() {
        return eventsArrayList.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull final ViewGroup container, final int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slideview,container,false);
        TextView reg=view.findViewById(R.id.register);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://students.iitgn.ac.in/ignite/"));
                context.startActivity(intent);
            }
        });
        ImageView imgslide =   view.findViewById(R.id.thumbnailslider);
        TextView open=view.findViewById(R.id.slideopen);
        Button  rulbutton=view.findViewById(R.id.rulebook);
        final TextView txttitle=  view.findViewById(R.id.textslider);
        Glide.with(context).load(eventsArrayList.get(position).getUrl()).into(imgslide);
        txttitle.setText(eventsArrayList.get(position).getInfo());
        if(eventsArrayList.get(position).getOpenTo()==-1){
            open.setVisibility(View.INVISIBLE);
            rulbutton.setVisibility(View.INVISIBLE);
        }else{
            open.setVisibility(View.VISIBLE);
            rulbutton.setVisibility(View.VISIBLE);
        }
        view.findViewById(R.id.register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse(eventsArrayList.get(position).getReg()));
                context.startActivity(intent);
            }
        });
        rulbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse(eventsArrayList.get(position).getDown()));
                context.startActivity(intent);
            }
        });

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ScrollView)object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return (view==o);
    }
}
