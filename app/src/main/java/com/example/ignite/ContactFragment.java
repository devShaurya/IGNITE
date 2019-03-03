package com.example.ignite;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ContactFragment extends Fragment {
    private RecyclerView recyclerView;
    private View view;
    private List<Contacts> contactsList;
    private FirebaseFirestore db;
    private ContactListAdapter contactListAdapter;
    public ContactFragment(){

    }


    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){

        view=inflater.inflate(R.layout.fragment_contact,container,false);

        recyclerView=view.findViewById(R.id.contact_list);
        contactsList = new ArrayList<>();
        contactListAdapter=new ContactListAdapter(contactsList,getContext());
        recyclerView.setAdapter(contactListAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        db=FirebaseFirestore.getInstance();
        FirebaseFirestore db2=FirebaseFirestore.getInstance();
        FirebaseFirestore db3=FirebaseFirestore.getInstance();
//        db.collection("Contacts").get().addOnCompleteListener(getActivity(),new OnCompleteListener<QuerySnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                QuerySnapshot querySnapshot=task.getResult();
//                List<DocumentSnapshot> documentSnapshots=querySnapshot.getDocuments();
//                for(int i=0;i<documentSnapshots.size();i++){
//                    contactsList.add(documentSnapshots.get(i).toObject(Contacts.class));
//                    contactListAdapter.notifyDataSetChanged();
//                }
//            }
//        });
//        db.collection("Contacts").whereEqualTo("position","Technical Secretary | Convener").get()
//                .addOnCompleteListener(getActivity(),new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        QuerySnapshot querySnapshot=task.getResult();
//                        List<DocumentSnapshot> documentSnapshots=querySnapshot.getDocuments();
//                        for (int i=0;i<documentSnapshots.size();i++){
//                            contactsList.add(documentSnapshots.get(i).toObject(Contacts.class));
//                            contactListAdapter.notifyDataSetChanged();
//                        }
//                    }
//                });
        db.collection("Contacts").whereEqualTo("position","Convener").get()
                .addOnCompleteListener(getActivity(),new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        QuerySnapshot querySnapshot=task.getResult();
                        List<DocumentSnapshot> documentSnapshots=querySnapshot.getDocuments();
                        for (int i=0;i<documentSnapshots.size();i++){
                            contactsList.add(documentSnapshots.get(i).toObject(Contacts.class));
                            contactListAdapter.notifyDataSetChanged();
                        }
                    }
                });
        db.collection("Contacts").whereEqualTo("position","Core Member").get()
                .addOnCompleteListener(getActivity(),new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        QuerySnapshot querySnapshot=task.getResult();
                        List<DocumentSnapshot> documentSnapshots=querySnapshot.getDocuments();
                        for (int i=0;i<documentSnapshots.size();i++){
                            contactsList.add(documentSnapshots.get(i).toObject(Contacts.class));
                            contactListAdapter.notifyDataSetChanged();
                        }
                    }
                });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

}
