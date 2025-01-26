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

public class TelaRetangulo extends AppCompatActivity {
    Button trocaAssuntos;
    Intent TelaAssuntos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_retangulo);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        trocaAssuntos = findViewById(R.id.trocaassuntos);
        TelaAssuntos = new Intent(this, MainScreen.class);
        trocaAssuntos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(TelaAssuntos);
            }
        });

    }
}