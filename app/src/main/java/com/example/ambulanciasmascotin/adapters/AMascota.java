package com.example.ambulanciasmascotin.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ambulanciasmascotin.R;
import com.example.ambulanciasmascotin.models.Mascota;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.ArrayList;

public class AMascota extends RecyclerView.Adapter<AMascota.MascotaViewHolder> {

    Context context;
    ArrayList<Mascota> arrayList;



    public AMascota(Context context,ArrayList<Mascota> arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }


    @NonNull
    @Override
    public AMascota.MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mascota,parent,false);
        return new MascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AMascota.MascotaViewHolder holder, int position) {

        Mascota mascota= arrayList.get(position);
        holder.nombreMas.setText("Mascota: "+mascota.getNombre_mascota());
        holder.genero.setText("Género: "+mascota.getGenero());
        holder.nombreDue.setText("Dueño: "+mascota.getNombre_duenho());
        holder.DNI.setText("DNI: "+mascota.getDNI());
        holder.descrip.setText("Descripción: "+mascota.getDescripcion());
        holder.ruta.setText("Ruta: "+mascota.getOrigen()+" "+mascota.getDestino());



    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MascotaViewHolder extends RecyclerView.ViewHolder {
        TextView nombreMas,genero,nombreDue,DNI,descrip,ruta;
        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreMas=itemView.findViewById(R.id.iNombreMas);
            genero=itemView.findViewById(R.id.iGenero);
            nombreDue=itemView.findViewById(R.id.iNombreD);
            DNI=itemView.findViewById(R.id.iDNI);
            descrip=itemView.findViewById(R.id.iDescrip);
            ruta=itemView.findViewById(R.id.ruta);



        }
    }
}
