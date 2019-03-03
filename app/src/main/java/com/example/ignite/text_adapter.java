package com.example.ignite;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class text_adapter extends RecyclerView.Adapter<text_adapter.ViewHolder> {


    List<text_objectobject> textList;
    Context ctx;
    public text_adapter(List<text_objectobject> textList, Context ctx) {
        this.textList=textList;
        this.ctx=ctx;
    }

    @NonNull
    @Override
    public text_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.text_layout,viewGroup,false);
        return new text_adapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull text_adapter.ViewHolder viewHolder, int i) {
        text_objectobject obj = textList.get(i);
        viewHolder.mhead.setText(obj.getName());
        viewHolder.mText.setText(obj.getArray());
    }

    @Override
    public int getItemCount() {
        return textList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View mView;
        public TextView mhead;
        public TextView mText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            mhead = mView.findViewById(R.id.text);
            mText = mView.findViewById(R.id.texta);
        }
    }
}
