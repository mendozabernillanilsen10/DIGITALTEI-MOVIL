package com.app.vista.Adapter;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.app.modelo.Apis;
import com.app.modelo.Productos;
import com.app.myapplication.R;
import com.app.vista.detalleproducto;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdaptadorProductHome extends RecyclerView.Adapter<AdaptadorProductHome.ViewHolder> {
    ArrayList<Productos> adaptadorProduct;

    public AdaptadorProductHome(ArrayList<Productos> adaptadorProduct) {
        this.adaptadorProduct = adaptadorProduct;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.Name.setText(adaptadorProduct.get(position).getName());
        Apis apis= new Apis();

        Picasso.get().load(apis.URl_000+adaptadorProduct.get(position).getImage()).networkPolicy(NetworkPolicy.NO_CACHE).memoryPolicy(MemoryPolicy.NO_CACHE).
                error(R.drawable.background_category).into(holder.img);


        Productos productos = adaptadorProduct.get(position);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),detalleproducto.class);
                intent.putExtra("producto",productos);
                v.getContext().startActivity(intent);
            }
        });





        /*

        CategoryDomain categori = categoryDomains.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un objeto Bundle para enviar datos al otro fragmento si es necesario
                Bundle bundle = new Bundle();
                bundle.putParcelable("key", categori);
                    Navigation.findNavController(v).navigate(R.id.action_nav_home_to_todoslosProductos);
                }

        });*/





    }

    @Override
    public int getItemCount() {
        return adaptadorProduct != null ? adaptadorProduct.size() : 0;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Name;
        ImageView img;
        ConstraintLayout mainLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.namePlatillo);
            img  = itemView.findViewById(R.id.imgPlatillo);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
