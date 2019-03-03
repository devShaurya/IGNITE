package com.example.ignite;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class ScheduleFragment extends Fragment {
    private PDFView pdfView;
    private TextView textView;
    private FirebaseFirestore db;
    public ScheduleFragment(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){

        View view=inflater.inflate(R.layout.fragment_schedule,container,false);
//        pdfView=view.findViewById(R.id.pdfView);
//        pdfView.fromAsset("event.pdf").load();
//        pdfView.canScrollHorizontally(1);
        textView=view.findViewById(R.id.scheduletext);
        pdfView=view.findViewById(R.id.schedule);
        db= FirebaseFirestore.getInstance();
        db.collection("pdf").document("schedule").get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        DocumentSnapshot documentSnapshot=task.getResult();
                        Pdf pdf=documentSnapshot.toObject(Pdf.class);
//                        Log.d("msg",pdf.getUrl()+" "+ pdf.getAvailable());
                        if (pdf.getAvailable()==false){
                            pdfView.setVisibility(View.INVISIBLE);
                        }else{
                            pdfView.setVisibility(View.VISIBLE);
                            textView.setVisibility(View.INVISIBLE);
                            new pdfStream(pdfView).execute(pdf.getUrl());
                        }
                    }
                });


        return view;
    }
}
