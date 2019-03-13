package com.example.ignite;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Aicheragment extends Fragment {
    ImageView imageView;
    RecyclerView recyclerView;
    AicheFragmentAdapter aicheFragmentAdapter;
    List<AICHE> aiches;
    FirebaseFirestore db;
    public Aicheragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_aiche,container,false);
        imageView=view.findViewById(R.id.aichelogo);
        recyclerView=view.findViewById(R.id.recycleraiche);
        aiches=new ArrayList<>();
        aicheFragmentAdapter=new AicheFragmentAdapter(getContext(),aiches);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(aicheFragmentAdapter);
        Glide.with(getContext()).load(Uri.parse("http://students.iitgn.ac.in/ignite/assets/img/aiche.png"))
                .into(imageView);
        db=FirebaseFirestore.getInstance();
        db.collection("aiche").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                List<DocumentSnapshot> documentSnapshots=task.getResult().getDocuments();
                for (int i=0;i<documentSnapshots.size();i++){
                    aiches.add(documentSnapshots.get(i).toObject(AICHE.class));
                    Log.d("msg",aiches.get(i).getTitle2()+"");
                    aicheFragmentAdapter.notifyDataSetChanged();
                }
            }
        });
        return view;
    }
}
