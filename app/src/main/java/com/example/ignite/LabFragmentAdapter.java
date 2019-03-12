package com.example.ignite;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class LabFragmentAdapter extends RecyclerView.Adapter<LabFragmentAdapter.ViewHolder>{
    Context context;
    List<LabTour> labTours;

    public  LabFragmentAdapter(Context context, List<LabTour> labTours){
        this.context=context;
        this.labTours=labTours;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.singlelab,viewGroup,false);
        return new LabFragmentAdapter.ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final LabTour labTour=labTours.get(i);
        Glide.with(context).load(Uri.parse(labTour.getImg()))
                .into(viewHolder.imageView);
        viewHolder.title.setText(labTour.getTitle());
        viewHolder.info.setText(labTour.getInfo());
        viewHolder.labguide.setText(labTour.getLabguide());
        viewHolder.regbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse(labTour.getRegister()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return labTours.size();
    }

    public class ViewHolder  extends  RecyclerView.ViewHolder{
        View view;
        public ImageView imageView;
        public TextView info,labguide,title;
        public Button regbutton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view=itemView;
            imageView=view.findViewById(R.id.labphoto);
            info=view.findViewById(R.id.singleinfolab);
            title=view.findViewById(R.id.singlelabtitle);
            labguide=view.findViewById(R.id.labguide);
            regbutton=view.findViewById(R.id.labreg);
        }
    }
}
