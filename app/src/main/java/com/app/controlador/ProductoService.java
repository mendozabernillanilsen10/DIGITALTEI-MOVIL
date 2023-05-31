package com.app.controlador;

import com.app.modelo.Productos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProductoService {
    @GET("productos")
    Call<List<Productos>> getProductos();
    @GET("products/category/{id}")
    Call<List<Productos>> getproducto_categoria(@Path("id") String id);
    @GET("products/subcategory/{id}")
    Call<List<Productos>> getproducto_SubCategoria(@Path("id") String id);
    @GET("productos")
    Call<List<Productos>> getProductosRecomentado();

}
