package com.example.testeprojetao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TelaCirculo extends AppCompatActivity {
    Button trocaAssuntos,questaoCirculo;
    Intent TelaAssuntos, telaQuestaoCirculo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_circulo);
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

        questaoCirculo = findViewById(R.id.questaoCirculo);
        telaQuestaoCirculo = new Intent(TelaCirculo.this, QuestaoCirculo.class);
        questaoCirculo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(telaQuestaoCirculo);
            }
        });

    }
}