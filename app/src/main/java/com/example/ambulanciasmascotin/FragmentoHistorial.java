package com.example.ambulanciasmascotin;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ambulanciasmascotin.adapters.AMascota;
import com.example.ambulanciasmascotin.models.Mascota;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;


public class FragmentoHistorial extends Fragment {

    RecyclerView recyclerView;

    FirebaseFirestore db;

    ArrayList<Mascota> mascotas;

    AMascota adapter;

    //FragmentFragmentoHistorialBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_fragmento_historial,container,false);


        recyclerView=view.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));



        db=FirebaseFirestore.getInstance();
        mascotas=new ArrayList<Mascota>();

        db.collection("mascotas")
                .addSnapshotListener((value, error) -> {
                    if (error!=null){
                        Log.e("msg","Firestore error");
                        return;
                    }
                    for (DocumentChange dc:value.getDocumentChanges()){
                        Log.e("msg", String.valueOf(dc.getDocument().getData()));
                        if (dc.getType()==DocumentChange.Type.ADDED){
                            Mascota m= dc.getDocument().toObject(Mascota.class);
                            Log.e("TAG", "onEvent: "+m.getNombre_mascota() );
                            mascotas.add(m);
                            Log.e("TAG", "onCreate: "+mascotas.size());
                            Log.e("msg","no error");
                        }
                        adapter = new AMascota(getActivity(), mascotas);
                        recyclerView.setAdapter(adapter);

                    }
                });

        return view;











    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




    }
}