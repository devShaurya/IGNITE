package com.example.ignite;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class EventsFragment extends Fragment {
    private CardView opentoall,opentoiitgn;
    private LinearLayout linearLayout;
    private ArrayList<Events> Namelist;
    private EventListAdapter eventListAdapter;
    public EventsFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){

        View view=inflater.inflate(R.layout.fragment_events,container,false);

        Namelist=new ArrayList<>();
        eventListAdapter=new EventListAdapter(Namelist,getContext());
        linearLayout=view.findViewById(R.id.relevnts);
        final RecyclerView recyclerView=view.findViewById(R.id.recyclerevent);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
//        list.setLayoutManager(new GridLayoutManager(this,2));
//        list.setHasFixedSize(true);
        recyclerView.setAdapter(eventListAdapter);
        final FirebaseFirestore db=FirebaseFirestore.getInstance();
        db.collection("ignite").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                QuerySnapshot querySnapshot=task.getResult();
                List<DocumentSnapshot> documentSnapshots=querySnapshot.getDocuments();
                for(int i=0;i<documentSnapshots.size();i++){
//                    Log.d("msg",documentSnapshots.toString());

                    Events events=documentSnapshots.get(i).toObject(Events.class);
                      Namelist.add(events);
                    eventListAdapter.notifyDataSetChanged();
                }
            }
        });


        Log.d("event",Namelist.size()+"");
        return view;
    }
}
