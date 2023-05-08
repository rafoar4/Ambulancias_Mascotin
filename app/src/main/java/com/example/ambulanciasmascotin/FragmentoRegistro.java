package com.example.ambulanciasmascotin;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.ambulanciasmascotin.databinding.FragmentFragmentoRegistroBinding;
import com.example.ambulanciasmascotin.models.Mascota;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;


public class FragmentoRegistro extends Fragment {

    FragmentFragmentoRegistroBinding binding;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_fragmento_registro, container, false);
        binding=FragmentFragmentoRegistroBinding.inflate(inflater,container,false);
        binding.bRegistrar.setBackgroundColor(Color.YELLOW);
        binding.bRegistrar.setTextColor(Color.BLACK);

        //NavController navController = NavHostFragment.findNavController(FragmentoRegistro.this);


        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getActivity(),R.array.combo_generos, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);

        binding.spinner.setAdapter(adapter);

        binding.bRegistrar.setOnClickListener(v -> {
            //Log.e("TAG", "onClick: "+binding.editNombreMas.getText() );
            //Log.e("TAG", "onClick: "+binding.editDescrip.getText() );
            //Log.e("TAG", "onClick: "+binding.editNombreDue.getText() );
            //Log.e("TAG", "onClick: "+binding.editDNI.getText() );
            //Log.e("TAG", "onClick: "+binding.spinner.getSelectedItem() );

            Mascota mascota = new Mascota();
            mascota.setNombre_mascota(binding.editNombreMas.getText().toString());
            mascota.setGenero(binding.spinner.getSelectedItem().toString());
            mascota.setNombre_duenho(binding.editNombreDue.getText().toString());
            mascota.setDNI(binding.editDNI.getText().toString());
            mascota.setDescripcion(binding.editDescrip.getText().toString());



            if(mascota.getNombre_mascota().isEmpty()||mascota.getNombre_duenho().isEmpty()||mascota.getDNI().isEmpty()||mascota.getDescripcion().isEmpty()){
                Toast.makeText(getContext(),"Complete los campos",Toast.LENGTH_SHORT).show();
                Log.e("msg","falta");

            }else {

                Bundle bundle= new Bundle();
                bundle.putString("nombre_masc",mascota.getNombre_mascota());
                bundle.putString("genero",mascota.getGenero());
                bundle.putString("nombre_due",mascota.getNombre_duenho());
                bundle.putString("DNI",mascota.getDNI());
                bundle.putString("desc",mascota.getDescripcion());
                FragmentoEmergencia fragmentoEmergencia= new FragmentoEmergencia();
                fragmentoEmergencia.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frameLayout,fragmentoEmergencia).commit();








                /*db=FirebaseFirestore.getInstance();
                db.collection("mascotas")
                        .add(mascota)
                        .addOnSuccessListener(documentReference -> {
                            Log.d("msg","se logro");
                            //Toast.makeText(getContext(),"Se guardo",Toast.LENGTH_SHORT).show();
                            Intent intent= new Intent(getActivity(),MainActivity.class);
                            startActivity(intent);

                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                //Toast.makeText(getContext(),"no Se guardo",Toast.LENGTH_SHORT).show();
                                Log.d("msg", "no se logro");
                            }
                        });

                Toast.makeText(getContext(),"Se añadió a la db",Toast.LENGTH_SHORT).show();*/


            }



        });









        return binding.getRoot();

    }

}