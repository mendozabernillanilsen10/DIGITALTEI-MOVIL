package com.app.vista.Adapter;


import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.app.modelo.Apis;
import com.app.modelo.Category;
import com.app.myapplication.R;
import com.app.vista.lista_categoria_Menu;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    public CategoryAdapter(ArrayList<Category> categoryDomains) {
        this.categoryDomains = categoryDomains;
    }

    ArrayList<Category> categoryDomains;



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category, parent, false);
        return new CategoryAdapter.ViewHolder(inflate);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.categoryName.setText(categoryDomains.get(position).getName());

        Apis apis = new Apis();
        Picasso.get().load(apis.URl_000 + categoryDomains.get(position).getImage()).networkPolicy(NetworkPolicy.NO_CACHE).memoryPolicy(MemoryPolicy.NO_CACHE).
                error(R.drawable.background_category).into(holder.categoryPic);
        Category category =categoryDomains.get(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), lista_categoria_Menu.class);
                intent.putParcelableArrayListExtra("subCategorias", (ArrayList<? extends Parcelable>) category.getSubcategories());
                intent.putExtra("id_categoria",String.valueOf(category.getId()));
                intent.putExtra("Category",String.valueOf(category.getName()));
                v.getContext().startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return categoryDomains != null ? categoryDomains.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView categoryName;
        ImageView categoryPic;
        ConstraintLayout mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.categoryName);
            categoryPic = itemView.findViewById(R.id.categoryPic);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}