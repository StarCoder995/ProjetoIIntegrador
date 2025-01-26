package com.example.testeprojetao;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class TelaQuadrado extends AppCompatActivity {
Button trocaAssuntos,trocaQuestao;
Intent TelaAssuntos,TelaQuestao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_quadrado);
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

        trocaQuestao = findViewById(R.id.trocaQuestao);
        TelaQuestao = new Intent(this, QuestaoQuadrado.class);
        trocaQuestao.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(TelaQuestao);
            }
        });

    }
}