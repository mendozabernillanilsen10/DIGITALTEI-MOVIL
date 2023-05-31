package com.app.vista;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.controlador.ProductoService;
import com.app.modelo.Apis;
import com.app.modelo.Productos;
import com.app.modelo.Subcategory;
import com.app.myapplication.R;
import com.app.vista.Adapter.AdaptadorProductlista;
import com.app.vista.Adapter.SubCategoriaAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class lista_categoria_Menu extends AppCompatActivity  implements TextWatcher {
    ProductoService productoService;
    List<Productos> listaProductos =new ArrayList<Productos>();
    EditText txtBuscar;
    AdaptadorProductlista adapter;
    private RecyclerView.Adapter  adapter2;
    ImageView bnt_regresar_;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_lista_categoria_menu);
        txtBuscar=findViewById(R.id.txtBuscar);
        bnt_regresar_ = findViewById(R.id.bnt_regresar_);
        String idCategoria = getIntent().getStringExtra("id_categoria");
        String Name  = getIntent().getStringExtra("Category");
        TextView categoria = findViewById(R.id.categoria);
        categoria.setText(Name);
        bnt_regresar_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(lista_categoria_Menu.this , Dasboar.class);
                startActivity(intent);
            }
        });
        MenuResicler();
        lista_productos_categoria(idCategoria);
        txtBuscar.addTextChangedListener((TextWatcher) this);
    }

    void MenuResicler(){
        RecyclerView recyclerViewCategotyList = findViewById(R.id.menusub);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategotyList.setLayoutManager(linearLayoutManager);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            ArrayList<Subcategory> subcategories = bundle.getParcelableArrayList("subCategorias");

            adapter2 = new SubCategoriaAdapter(subcategories, new SubCategoriaAdapter.onclickListener() {
                @Override
                public void onItemClick(Subcategory item) {
                    MostrarProductosCategoria(item);
                }
            });
            recyclerViewCategotyList.setAdapter(adapter2);
        } else {
            Toast.makeText(this, "No se encontraron subcategorías", Toast.LENGTH_SHORT).show();
        }
    }

    private void MostrarProductosCategoria(Subcategory item) {
        RecyclerView recyclerViewCategotyList = findViewById(R.id.vistapp);
        recyclerViewCategotyList.setAdapter(null);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewCategotyList.setLayoutManager(linearLayoutManager);
        productoService = Apis.getProducto();
        Call<List<Productos>> call = productoService.getproducto_SubCategoria(String.valueOf(item.getId()));
        call.enqueue(new Callback<List<Productos>>() {
            @Override
            public void onResponse(Call<List<Productos>> call, Response<List<Productos>> response) {
                if (response.isSuccessful()) {
                    List<Productos> lista = response.body();

                    adapter = new AdaptadorProductlista((ArrayList<Productos>) lista );
                    recyclerViewCategotyList.setAdapter(adapter);
                } else {
                    Toast.makeText(lista_categoria_Menu.this, "Error De Conexion", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<Productos>> call, Throwable t) {
                Toast.makeText(lista_categoria_Menu.this, "Error en la llamada a la API", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void lista_productos_categoria(String id) {
        RecyclerView recyclerViewCategotyList = findViewById(R.id.vistapp);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewCategotyList.setLayoutManager(linearLayoutManager);
        productoService = Apis.getProducto();

        Call<List<Productos>> call = productoService.getproducto_categoria(id);

        call.enqueue(new Callback<List<Productos>>() {
            @Override
            public void onResponse(Call<List<Productos>> call, Response<List<Productos>> response) {
                if (response.isSuccessful()) {
                    List<Productos> lista = response.body();

                    adapter = new AdaptadorProductlista((ArrayList<Productos>) lista );
                    recyclerViewCategotyList.setAdapter(adapter);
                } else {
                    Toast.makeText(lista_categoria_Menu.this, "Error ", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Productos>> call, Throwable t) {
                Toast.makeText(lista_categoria_Menu.this, "Error en la llamada a la API", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        String searchText = s.toString();
        adapter.filtrado(searchText);

    }
}




