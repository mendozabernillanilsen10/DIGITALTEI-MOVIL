package com.app.controlador;

import com.app.modelo.CategoryResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoriaService {
    @GET("categorias")
    Call<List<CategoryResponse>> getCategorias();

}
