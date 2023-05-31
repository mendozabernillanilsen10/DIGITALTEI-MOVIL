package com.app.vista;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.controlador.CategoriaService;
import com.app.controlador.ProductoService;
import com.app.modelo.Apis;
import com.app.modelo.Category;
import com.app.modelo.CategoryResponse;
import com.app.modelo.Productos;
import com.app.modelo.Subcategory;
import com.app.modelo.limpiar;
import com.app.myapplication.databinding.FragmentHomeBinding;
import com.app.vista.Adapter.AdaptadorProductHome;
import com.app.vista.Adapter.CategoryAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    CategoriaService categoriaService;


    ProductoService productoService;
    List<Productos> listaProductos = new ArrayList<>();

    private FragmentHomeBinding binding;
    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewCategotyList;
    private RecyclerView recyclerViewProduct;

    limpiar limpiar= new limpiar();
    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {

        limpiar.clearCache(requireContext());




       binding = FragmentHomeBinding.inflate(inflater, container, false);
       View root = binding.getRoot();

       FloatingActionButton fab = binding.fab ;
       TextView btn_todos_productoz = binding.textView12;
       TextView textView11 =binding.textView11;

        listasProductosDeceados();
        listarCategoria();
      /* fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(HomeFragment.this)
                        .navigate(R.id.action_nav_home_to_MIcarritoDecompras);

            }
        });

        textView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(HomeFragment.this)
                        .navigate(R.id.action_nav_home_to_detalleProducto);
            }
        });

        btn_todos_productoz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(HomeFragment.this)
                        .navigate(R.id.action_nav_home_to_todoslosProductos);
            }
        });*/


        return root;
    }



    private void listasProductosDeceados() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerViewProduct = binding.view2;
        recyclerViewProduct.setLayoutManager(linearLayoutManager);

        productoService = Apis.getProducto();
        Call<List<Productos>> call = productoService.getProductosRecomentado();


        call.enqueue(new Callback<List<Productos>>() {
            @Override
            public void onResponse(Call<List<Productos>> call, Response<List<Productos>> response) {
                if (response.isSuccessful()) {
                    listaProductos = response.body();
                    adapter2 = new AdaptadorProductHome((ArrayList<Productos>) listaProductos);
                    recyclerViewProduct.setAdapter(adapter2);
                } else {
                    Log.e("Error:","ERROR");
                }
            }

            @Override
            public void onFailure(Call<List<Productos>> call, Throwable t) {
                Log.e("Error:",t.getMessage());
            }
        });
    }


    private void listarCategoria() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategotyList = binding.view1;
        recyclerViewCategotyList.setLayoutManager(linearLayoutManager);
        categoriaService = Apis.getCategoriaService();


        Call<List<CategoryResponse>> call = categoriaService.getCategorias();

        call.enqueue(new Callback<List<CategoryResponse>>() {
            @Override
            public void onResponse(Call<List<CategoryResponse>> call, Response<List<CategoryResponse>> response) {
                if (response.isSuccessful()) {
                    List<CategoryResponse> categoryResponses = response.body();


                    List<Category> lista_cate = new ArrayList<>();


                    for (CategoryResponse categoryResponse : categoryResponses) {

                        Category category = categoryResponse.getCategory();
                        List<Subcategory> subcategories = categoryResponse.getSubcategories();
                        category.setSubcategories(subcategories);

                        lista_cate.add(category);

                    }

                    adapter = new CategoryAdapter((ArrayList<Category>) lista_cate);
                    recyclerViewCategotyList.setAdapter(adapter);

                } else {
                    // Manejar la respuesta no exitosa aquí
                }
            }

            @Override
            public void onFailure(Call<List<CategoryResponse>> call, Throwable t) {
                // Manejar el error de la llamada aquí
            }
        });









/*





        call.enqueue(new Callback<List<CategoryDomain>>() {
            @Override
            public void onResponse(Call<List<CategoryDomain>> call, Response<List<CategoryDomain>> response) {

                List<CategoryDomain> listCategoria =new ArrayList<>();
                listCategoria = response.body();

                List<CategoryResponse> categoryResponses = response.body();
                // Procesar los datos recibidos

                // Por ejemplo, recorrer las respuestas y obtener las categorías y subcategorías
                for (CategoryResponse categoryResponse : categoryResponses) {
                    Category category = categoryResponse.getCategory();
                    List<Subcategory> subcategories = categoryResponse.getSubcategories();

                    // Realizar las operaciones necesarias con las categorías y subcategorías obtenidas
                }


                adapter = new CategoryAdapter((ArrayList<CategoryDomain>) listCategoria);
                recyclerViewCategotyList.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<CategoryDomain>> call, Throwable t) {
                Toast.makeText(getContext(),t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });*/




    }




    /*
        private void listarCategoria(String url) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
            recyclerViewCategotyList = binding.view1;
            recyclerViewCategotyList.setLayoutManager(linearLayoutManager);

            ArrayList<CategoryDomain> categoryList = new ArrayList<>();

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                JSONArray dataArray = response.getJSONArray("data");
                                for (int i = 0; i < dataArray.length(); i++) {
                                    JSONObject dataObject = dataArray.getJSONObject(i);
                                    String id = dataObject.getString("id");
                                    String name = dataObject.getString("name");
                                    String fot = dataObject.getString("image");
                                    categoryList.add(new CategoryDomain(id,name,fot));
                                }

                                adapter = new CategoryAdapter(categoryList);
                                recyclerViewCategotyList.setAdapter(adapter);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getContext(), error.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });

            RequestQueue requestQueue = Volley.newRequestQueue(getContext());
            requestQueue.add(jsonObjectRequest);
        }

    */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}