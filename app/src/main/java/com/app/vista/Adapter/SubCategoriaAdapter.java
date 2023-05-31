package com.app.vista.Adapter;


import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.modelo.Subcategory;
import com.app.myapplication.R;

import java.util.ArrayList;

public class SubCategoriaAdapter extends RecyclerView.Adapter<SubCategoriaAdapter.ViewHolder> {
    ArrayList<Subcategory> sub_categorias;
    private int selectedItemPosition = RecyclerView.NO_POSITION;

    final SubCategoriaAdapter.onclickListener listener;

    public interface onclickListener{
        void onItemClick(Subcategory item);
    }


    public SubCategoriaAdapter(ArrayList<Subcategory> sub_categorias,onclickListener listener) {
        this.sub_categorias = sub_categorias;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_subcategoria, parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvSubCategoria.setText(sub_categorias.get(position).getName());
        Subcategory item = sub_categorias.get(position);
        int pos =position;

        if (selectedItemPosition == pos) {
            holder.miniLayoutCatego.setBackgroundResource(R.drawable.background_categorydark);
            holder.tvSubCategoria.setTextColor(Color.parseColor("#FFFFFF"));
        } else {
            holder.miniLayoutCatego.setBackgroundResource(R.drawable.background_category);
            holder.tvSubCategoria.setTextColor(Color.parseColor("#000000"));
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int previousSelectedItemPosition = selectedItemPosition;
                selectedItemPosition = pos;

                notifyItemChanged(previousSelectedItemPosition);
                notifyItemChanged(selectedItemPosition);

                listener.onItemClick(item);
            }
        });
    }


    @Override
    public int getItemCount() {
        return sub_categorias != null ? sub_categorias.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvSubCategoria;
        LinearLayout  miniLayoutCatego;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSubCategoria = itemView.findViewById(R.id.tvSubCategoria);
            miniLayoutCatego=itemView.findViewById(R.id.miniLayoutCatego);
        }
    }
}
