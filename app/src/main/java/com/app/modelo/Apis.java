package com.app.modelo;


import com.app.controlador.CategoriaService;
import com.app.controlador.ProductoService;

public class Apis {
    public    String URl_000 ="http://192.168.6.105/digitaltei/public/storage/";
    public  String getURl_000() {
        return URl_000;
    }

    public static final String URL_001= "http://192.168.6.105/digitaltei/public/api/";

    public static CategoriaService getCategoriaService(){
        return  Cliente.getClient(URL_001).create(CategoriaService.class);
    }

    public static ProductoService getProducto(){
        return  Cliente.getClient(URL_001).create(ProductoService.class);

    }







}
