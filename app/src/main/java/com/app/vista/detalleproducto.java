package com.app.vista;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.app.modelo.Apis;
import com.app.modelo.Productos;
import com.app.myapplication.R;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

public class detalleproducto extends AppCompatActivity {

     TextView addToCartBtn;
     TextView titleTxt, feeTxt, descriptionTxt, numberOrderTxt, totalPriceTxt;
     ImageView plusBtn, minusBtn, picFood;
     Productos object;
     int numberOrder=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalleproducto);
        iniView();
        getBundle();
    }

    private void iniView() {
        addToCartBtn = findViewById(R.id.addToCartBtn);
        titleTxt = findViewById(R.id.titleTxt);
        feeTxt = findViewById(R.id.priceTxt);
        descriptionTxt = findViewById(R.id.descriptionTxt);
        numberOrderTxt = findViewById(R.id.numberItemTxt);
        plusBtn = findViewById(R.id.plusCardBtn);
        minusBtn = findViewById(R.id.minusCardBtn);
        picFood = findViewById(R.id.foodPic);
        totalPriceTxt = findViewById(R.id.totalPriceTxt);
    }

    private void getBundle() {
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
             object = (Productos) bundle.getSerializable("producto");
            if (object != null) {

            mostrarData(object);






             } else {
                Toast.makeText(this, "No se encontró el objeto 'producto'", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "No se encontraron datos adicionales", Toast.LENGTH_SHORT).show();
        }

    }

    private void mostrarData(Productos object) {
        Apis apis= new Apis();
        Picasso.get().load(apis.URl_000+object.getImage()).networkPolicy(NetworkPolicy.NO_CACHE).memoryPolicy(MemoryPolicy.NO_CACHE).
                error(R.drawable.background_category).into(picFood);

        titleTxt.setText(object.getName());


        feeTxt.setText("S/" + object.getPrice());

        descriptionTxt.setText(object.getDescription());
        numberOrderTxt.setText(String.valueOf(object.getNumberOrder()));
        totalPriceTxt.setText("S/"+Math.round(numberOrder * object.getPrice()));


        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOrder = numberOrder + 1;
                numberOrderTxt.setText(String.valueOf(numberOrder));
                totalPriceTxt.setText("S/"+Math.round(numberOrder * object.getPrice()));
            }
        });
        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numberOrder > 1) {
                    numberOrder = numberOrder - 1;
                }
                numberOrderTxt.setText(String.valueOf(numberOrder));
                totalPriceTxt.setText("S/"+Math.round(numberOrder * object.getPrice()));
            }
        });
        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // object.setNumberOrder(numberOrder);

                /*persona p  = new persona();
                SharedPreferences sharedPreferences = getSharedPreferences("Sesion", Context.MODE_PRIVATE);
                p = DB.buscarPersona(sharedPreferences.getString("usuarioSE", ""));
                proceso(p);*/


            }
        });
    }



}