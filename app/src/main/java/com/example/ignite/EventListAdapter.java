package com.example.ignite;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.ViewHolder> {
    public List<Events> NameList;
    public Context ctx;

    public EventListAdapter(List<Events> NameList, Context ctx){
        this.NameList=NameList;
        this.ctx=ctx;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.singleevent,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        final Events name=NameList.get(i);
        Glide.with(ctx).load(name.getUrl()).into(viewHolder.imageView);
        if(name.getOpenTo()==1){
            viewHolder.iitopen.setVisibility(View.VISIBLE);
            viewHolder.iitopen.setText("Only For IITGN");
        }else{
            viewHolder.iitopen.setVisibility(View.INVISIBLE);
        }
        viewHolder.nameView.setText(name.getTimeandvenue());
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ctx,AllEventSlider.class);
                intent.putExtra("items",NameList.size());
                intent.putParcelableArrayListExtra("list", (ArrayList<? extends Parcelable>) NameList);
                intent.putExtra("current",i);
                ctx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return NameList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        View mView;
        public ImageView imageView;
        public TextView nameView;
        public TextView iitopen;
        public CardView cardView;
        public ViewHolder (View itemView) {
            super(itemView);
            mView = itemView;
            cardView=mView.findViewById(R.id.card_view_event);
            nameView=mView.findViewById(R.id.date);
            imageView= mView.findViewById(R.id.thumbnail);
            iitopen=mView.findViewById(R.id.iitopen);
        }
    }
}
