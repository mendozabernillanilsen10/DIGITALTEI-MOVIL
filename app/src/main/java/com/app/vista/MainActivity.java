package com.app.vista;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.app.myapplication.R;
import com.app.myapplication.RegistrarUsuarioActivity;

public class MainActivity extends AppCompatActivity {
 Button btn_loguin,Registrarse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        btn_loguin =findViewById(R.id.btn_loguin);
        Registrarse=findViewById(R.id.Registrarse);
        Registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivity = new Intent(getApplicationContext(), RegistrarUsuarioActivity.class );
                startActivity(mainActivity);
                finish();
            }
        });
        btn_loguin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivity = new Intent(getApplicationContext(), Dasboar.class );
                startActivity(mainActivity);
                finish();
            }
        });
    }
}