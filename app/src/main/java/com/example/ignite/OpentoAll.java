package com.example.ignite;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class OpentoAll extends AppCompatActivity {
    private RecyclerView list;
    private List<Events> Namelist;
    private EventListAdapter eventListAdapter;
    private FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opento_all);
        Namelist=new ArrayList<>();
        db=FirebaseFirestore.getInstance();
//        findViewById(R.drawable.id) -700091
        eventListAdapter=new EventListAdapter(Namelist,this);
        list=findViewById(R.id.eventlist);
        list.setLayoutManager(new LinearLayoutManager(this));
//         list.setLayoutManager(new GridLayoutManager(this,2));
//        list.setHasFixedSize(true);
        list.setAdapter(eventListAdapter);
//        list.setLayoutManager(new LinearLayoutManager(this ));
//        Namelist.add( new Events("",R.drawable.projectjpg, -1,"Project Exhibition"));
//        eventListAdapter.notifyDataSetChanged();
        list.setLayoutManager(new LinearLayoutManager(this));
        db.collection("ignite").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                QuerySnapshot querySnapshot=task.getResult();
                List<DocumentSnapshot> documentSnapshots=querySnapshot.getDocuments();
                for(int i=0;i<documentSnapshots.size();i++){
                    Events events=documentSnapshots.get(i).toObject(Events.class);
                    if(events.getOpenTo()==-1){
                        Namelist.add(events);
                        eventListAdapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }

}
