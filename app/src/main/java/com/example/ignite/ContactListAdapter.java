package com.example.ignite;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.ViewHolder> {
    List<Contacts> contactsList;
    Context ctx;
    public ContactListAdapter(List<Contacts> contactsList, Context ctx) {
        this.contactsList=contactsList;
        this.ctx=ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_contact,viewGroup,false);
        return new ContactListAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Contacts contacts=contactsList.get(i);
//        Log.d("msg",contacts.getName());
        if(contacts.getName().equals("Dhruvin Shah")){
            Glide.with(ctx).load(R.drawable.dhruvin).apply(RequestOptions.circleCropTransform()).into(viewHolder.photoView);
        }else{
            Glide.with(ctx).load(contacts.getUrl()).apply(RequestOptions.circleCropTransform()).into(viewHolder.photoView);

        }
        viewHolder.emailView.setText(contacts.getEmail());
        viewHolder.nameView.setText(contacts.getName());
        viewHolder.positionView.setText(contacts.getPosition());
        viewHolder.numberView.setText(contacts.getNumber());
        viewHolder.crd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String c=contacts.getNumber();
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+c));
                ctx.startActivity(callIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        View mView;
        public ImageView photoView;
        public TextView nameView,numberView,positionView,emailView;
        public CardView crd;

        public ViewHolder (View itemView) {
            super(itemView);
            mView = itemView;

            nameView=mView.findViewById(R.id.contact_name);
            photoView= mView.findViewById(R.id.contact_photo);
            numberView=mView.findViewById(R.id.contact_number);
            positionView=mView.findViewById(R.id.contact_position);
            emailView=mView.findViewById(R.id.contact_email);
            crd=mView.findViewById(R.id.card_view_contact);
        }
    }
}
