package com.example.testeprojetao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TelaCirculo extends AppCompatActivity {
    ImageButton trocaAssuntos,questaoCirculo;
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
    }

    public void trocaAssuntos(View v) {
        Intent in = new Intent(TelaCirculo.this, MainScreen.class);
        startActivity(in);
    }

    public void questaoCirculo(View v) {
        Intent in = new Intent(TelaCirculo.this, QuestaoCirculo.class);
        startActivity(in);
    }
}