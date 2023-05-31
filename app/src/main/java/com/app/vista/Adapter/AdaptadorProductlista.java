package com.app.vista.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.modelo.Apis;
import com.app.modelo.Productos;
import com.app.myapplication.R;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdaptadorProductlista extends RecyclerView.Adapter<AdaptadorProductlista.ViewHolder> {

    ArrayList<Productos> listaProductos;
    ArrayList<Productos> listaOriginal;


    public AdaptadorProductlista(ArrayList<Productos> listaProductos) {
        this.listaProductos = listaProductos;
        listaOriginal = new ArrayList<>();
        listaOriginal.addAll(listaProductos);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.cartaproducto, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.titlee.setText(listaProductos.get(position).getName());
        holder.descriptionTxts.setText(listaProductos.get(position).getDescription());
        Apis apis= new Apis();

        Picasso.get().load(apis.URl_000+listaProductos.get(position).getImage()).networkPolicy(NetworkPolicy.NO_CACHE).memoryPolicy(MemoryPolicy.NO_CACHE).
                error(R.drawable.background_category).into(holder.imgproducto);


    }

    @Override
    public int getItemCount() {
        return listaProductos != null ? listaProductos.size() : 0;
    }



    public void filtrado(final String txtBuscar) {
        int longitud = txtBuscar.length();
        if (longitud == 0) {
            listaProductos.clear();
            listaProductos.addAll(listaOriginal);

        } else {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                List<Productos> collecion = listaProductos.stream()
                        .filter(i -> i.getName().toLowerCase().contains(txtBuscar.toLowerCase()))
                        .collect(Collectors.toList());
                listaProductos.clear();
                listaProductos.addAll(collecion);
            } else {
                for (Productos c : listaOriginal) {
                    if (c.getName().toLowerCase().contains(txtBuscar.toLowerCase())) {
                        listaProductos.add(c);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titlee;
        ImageView imgproducto;
        TextView descriptionTxts;
        Button btn_ordenear;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titlee = itemView.findViewById(R.id.titlee);
            imgproducto  = itemView.findViewById(R.id.imgproducto);
            descriptionTxts = itemView.findViewById(R.id.descriptionTxts);
            btn_ordenear  = itemView.findViewById(R.id.btn_ordenear);




        }
    }
}
