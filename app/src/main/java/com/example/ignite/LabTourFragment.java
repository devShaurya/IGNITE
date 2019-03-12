package com.example.ignite;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

public class LabTourFragment extends Fragment {
    ImageView imageView;
    RecyclerView recyclerView;
    LabFragmentAdapter labFragmentAdapter;
    List<LabTour> labTours;
    FirebaseFirestore db;
    public LabTourFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.lab_fragment,container,false);
        imageView=view.findViewById(R.id.labtourlogo);
        recyclerView=view.findViewById(R.id.recyclerlab);
        labTours=new ArrayList<>();
        labFragmentAdapter=new LabFragmentAdapter(getContext(),labTours);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(labFragmentAdapter);
        Glide.with(getContext()).load(Uri.parse("http://students.iitgn.ac.in/ignite/assets/img/lab-tours-407x407.png"))
                .into(imageView);
        db=FirebaseFirestore.getInstance();
        db.collection("lab").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                List<DocumentSnapshot> documentSnapshots=task.getResult().getDocuments();
                for (int i=0;i<documentSnapshots.size();i++){
                    labTours.add(documentSnapshots.get(i).toObject(LabTour.class));
                    labFragmentAdapter.notifyDataSetChanged();
                }
            }
        });
        return view;
    }
}
