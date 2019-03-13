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

public class AicheFragmentAdapter extends RecyclerView.Adapter<AicheFragmentAdapter.ViewHolder>{
    Context context;
    List<AICHE> aiches;

    public AicheFragmentAdapter(Context context, List<AICHE> aiches){
        this.context=context;
        this.aiches=aiches;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.singlelaiche,viewGroup,false);
        return new AicheFragmentAdapter.ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final AICHE aiche=aiches.get(i);
        if(aiche.getImg()!=null) {
            viewHolder.imageView.getLayoutParams().height=400;
            viewHolder.imageView.getLayoutParams().width=400;
            viewHolder.imageView.setVisibility(View.VISIBLE);
            Glide.with(context).load(Uri.parse(aiche.getImg()))
                    .into(viewHolder.imageView);
        }else{
            viewHolder.imageView.getLayoutParams().height=0;
            viewHolder.imageView.getLayoutParams().width=0;
        }
        if(aiche.getTitle()!=null) {
            viewHolder.title.setText(aiche.getTitle());
        }viewHolder.info.setText(aiche.getInfo());
        if(aiche.getTitle2()!=null) {
            viewHolder.aicheinfo2.getLayoutParams().height= ViewGroup.LayoutParams.WRAP_CONTENT;
            viewHolder.aicheinfo2.getLayoutParams().width=ViewGroup.LayoutParams.WRAP_CONTENT;
            viewHolder.aichetitle2.getLayoutParams().height=ViewGroup.LayoutParams.WRAP_CONTENT;
            viewHolder.aichetitle2.getLayoutParams().width=ViewGroup.LayoutParams.WRAP_CONTENT;
            viewHolder.aicheinfo2.setText(aiche.getTitle2());
        }else{

            viewHolder.aicheinfo2.getLayoutParams().height=0;
            viewHolder.aicheinfo2.getLayoutParams().width=0;
            viewHolder.aichetitle2.getLayoutParams().height=0;
            viewHolder.aichetitle2.getLayoutParams().width=0;
        }
        if(aiche.getReg()!=null){
            viewHolder.reg.getLayoutParams().height=ViewGroup.LayoutParams.WRAP_CONTENT;
            viewHolder.reg.getLayoutParams().width= ViewGroup.LayoutParams.WRAP_CONTENT;
        viewHolder.reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse(aiche.getReg()));
                context.startActivity(intent);
            }
        });
        }else{
            viewHolder.reg.getLayoutParams().height=0;
            viewHolder.reg.getLayoutParams().width=0;
        }
        if(aiche.getRule()!=null) {
            viewHolder.rule.getLayoutParams().height=ViewGroup.LayoutParams.WRAP_CONTENT;
            viewHolder.rule.getLayoutParams().width= ViewGroup.LayoutParams.WRAP_CONTENT;
            viewHolder.rule.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(aiche.getRule()));
                    context.startActivity(intent);
                }
            });
        }else{

            viewHolder.rule.getLayoutParams().height=0;
            viewHolder.rule.getLayoutParams().width=0;
        }
    }

    @Override
    public int getItemCount() {
        return aiches.size();
    }

    public class ViewHolder  extends  RecyclerView.ViewHolder{
        View view;
        public ImageView imageView;
        public TextView aichetitle2,info,title,reg,aicheinfo2;
        public Button rule;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view=itemView;
            imageView=view.findViewById(R.id.aichephoto);
            info=view.findViewById(R.id.singleinfoaiche);
            title=view.findViewById(R.id.singleaichetitle);
            aichetitle2=view.findViewById(R.id.aichetitle2);
            aicheinfo2=view.findViewById(R.id.aicheguide);
            reg=view.findViewById(R.id.aichereg);
            rule=view.findViewById(R.id.aicherule);
        }
    }
}
