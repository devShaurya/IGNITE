package com.example.ignite;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Brochure extends AppCompatActivity {
    private PDFView pdfView;
    private TextView textView;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brochure);
        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(getDrawable(R.drawable.newgrad));
//        pdfView.fromAsset("brochure.pdf").load();

        textView=findViewById(R.id.brotext);
        pdfView=findViewById(R.id.brochure);
        db=FirebaseFirestore.getInstance();
        db.collection("pdf").document("brochure").get()
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

    }
}
