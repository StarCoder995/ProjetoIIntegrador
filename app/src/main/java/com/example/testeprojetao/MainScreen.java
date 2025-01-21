package com.example.testeprojetao;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.widget.Button;
import android.view.View;

public class MainScreen extends AppCompatActivity {
    Button trocaquadrado,trocaretangulo,trocacirculo,trocaTrapezio,trocatriangulo, trocahexagono;
    Intent TelaQuadrado,TelaRetangulo,TelaCirculo,TelaTrapezio,TelaTriangulo, TelaHexagono;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        trocaquadrado = findViewById(R.id.trocaquadrado);
        TelaQuadrado = new Intent(MainScreen.this, TelaQuadrado.class);
        trocaquadrado.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(TelaQuadrado);
            }
        });

        trocaretangulo = findViewById(R.id.trocaretangulo);
        TelaRetangulo = new Intent(MainScreen.this, TelaRetangulo.class);
        trocaretangulo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(TelaRetangulo);
            }
        });

        trocacirculo = findViewById(R.id.trocacirculo);
        TelaCirculo = new Intent(MainScreen.this, TelaCirculo.class);
        trocacirculo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(TelaCirculo);
            }
        });

        trocaTrapezio = findViewById(R.id.trocatrapezio);
        TelaTrapezio = new Intent(MainScreen.this, TelaTrapezio.class);
        trocaTrapezio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(TelaTrapezio);
            }
        });

        trocatriangulo = findViewById(R.id.trocatriangulo);
        TelaTriangulo = new Intent(MainScreen.this, TelaTriangulo.class);
        trocatriangulo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(TelaTriangulo);
            }
        });

        trocahexagono = findViewById(R.id.trocaExagono);
        TelaHexagono= new Intent(MainScreen.this, TelaHexagono.class);
        trocaheagono.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(TelaHexagono);
            }
        });




    }
}