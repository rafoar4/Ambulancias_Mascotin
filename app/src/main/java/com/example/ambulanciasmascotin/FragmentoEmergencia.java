package com.example.ambulanciasmascotin;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.ambulanciasmascotin.databinding.FragmentFragmentoEmergenciaBinding;
import com.example.ambulanciasmascotin.databinding.FragmentFragmentoRegistroBinding;
import com.example.ambulanciasmascotin.models.Mascota;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.firestore.FirebaseFirestore;


public class FragmentoEmergencia extends Fragment {
    FragmentFragmentoEmergenciaBinding binding;
    FirebaseFirestore db;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_fragmento_emergencia, container, false);
        binding=FragmentFragmentoEmergenciaBinding.inflate(inflater,container,false);
        binding.bCalcular.setBackgroundColor(Color.RED);



        //Mascota mascota= FragmentoEmergenciaArgs.fromBundle(getArguments()).getMascota();

        Bundle bundle = this.getArguments();
        String nombre_masc=bundle.getString("nombre_masc");
        String genero=bundle.getString("genero");
        String nombre_due=bundle.getString("nombre_due");
        String DNI=bundle.getString("DNI");
        String desc=bundle.getString("desc");


        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getActivity(),R.array.combo_destinos, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);

        binding.spinner2.setAdapter(adapter);

        binding.bCalcular.setOnClickListener(new View.OnClickListener() {
            CountDownTimer count;
            long timeleft;
            @Override
            public void onClick(View v) {
                //Toast.makeText(getContext(),nombre_masc,Toast.LENGTH_SHORT).show();
                //Toast.makeText(getContext(),genero,Toast.LENGTH_SHORT).show();
                //Toast.makeText(getContext(),nombre_due,Toast.LENGTH_SHORT).show();
                //Toast.makeText(getContext(),DNI,Toast.LENGTH_SHORT).show();

                //Toast.makeText(getContext(),desc,Toast.LENGTH_SHORT).show();

                //Log.e("TAG", "onClick: "+binding.spinner2.getSelectedItem() );
                if(binding.spinner2.getSelectedItem().equals("Lince")){
                    //Log.e("TAG", "onClick: Lince" );
                    timeleft=600000;
                    count=new CountDownTimer(timeleft,1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            timeleft=millisUntilFinished;
                            int minutes= (int) (timeleft/60000);
                            int seconds = (int) (timeleft%60000/1000);
                            String timelefttext;

                            timelefttext=""+minutes;
                            timelefttext+= ":";
                            if(seconds<10){
                                timelefttext +="0";
                            }
                            timelefttext += seconds;
                            binding.contador.setText(timelefttext);



                        }

                        @Override
                        public void onFinish() {

                        }
                    }.start();

                } else if (binding.spinner2.getSelectedItem().equals("San Isidro")) {
                    timeleft=900000;
                    count=new CountDownTimer(timeleft,1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            timeleft=millisUntilFinished;
                            int minutes= (int) (timeleft/60000);
                            int seconds = (int) (timeleft%60000/1000);
                            String timelefttext;

                            timelefttext=""+minutes;
                            timelefttext+= ":";
                            if(seconds<10){
                                timelefttext +="0";
                            }
                            timelefttext += seconds;
                            binding.contador.setText(timelefttext);



                        }

                        @Override
                        public void onFinish() {

                        }
                    }.start();
                    //binding.contador.setText("15:00");
                } else if (binding.spinner2.getSelectedItem().equals("Magdalena")) {
                    timeleft=1200000;
                    count=new CountDownTimer(timeleft,1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            timeleft=millisUntilFinished;
                            int minutes= (int) (timeleft/60000);
                            int seconds = (int) (timeleft%60000/1000);
                            String timelefttext;

                            timelefttext=""+minutes;
                            timelefttext+= ":";
                            if(seconds<10){
                                timelefttext +="0";
                            }
                            timelefttext += seconds;
                            binding.contador.setText(timelefttext);



                        }

                        @Override
                        public void onFinish() {

                        }
                    }.start();
                    //binding.contador.setText("20:00");
                } else if (binding.spinner2.getSelectedItem().equals("Jesús María")){
                    timeleft=1500000;
                    count=new CountDownTimer(timeleft,1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            timeleft=millisUntilFinished;
                            int minutes= (int) (timeleft/60000);
                            int seconds = (int) (timeleft%60000/1000);
                            String timelefttext;

                            timelefttext=""+minutes;
                            timelefttext+= ":";
                            if(seconds<10){
                                timelefttext +="0";
                            }
                            timelefttext += seconds;
                            binding.contador.setText(timelefttext);



                        }

                        @Override
                        public void onFinish() {

                        }
                    }.start();
                    //binding.contador.setText("25:00");
                }

                Mascota mascota = new Mascota();
                mascota.setNombre_mascota(nombre_masc);
                mascota.setGenero(genero);
                mascota.setNombre_duenho(nombre_due);
                mascota.setDNI(DNI);
                mascota.setDescripcion(desc);
                mascota.setOrigen(binding.textView.getText().toString());
                mascota.setDestino(binding.spinner2.getSelectedItem().toString());
                //Toast.makeText(getContext(),mascota.getDescripcion(),Toast.LENGTH_SHORT).show();

                db= FirebaseFirestore.getInstance();
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

                //Toast.makeText(getContext(),"Se añadió a la db",Toast.LENGTH_SHORT).show();
            }
        });








        return binding.getRoot();
    }


}