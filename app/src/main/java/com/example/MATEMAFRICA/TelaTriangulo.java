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

public class TelaTriangulo extends AppCompatActivity {
    ImageButton trocaAssuntos, trocaQuestaoTriangulo;
    Intent TelaAssuntos,  telaQuestaoTriangulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_triangulo);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

        public void trocaAssuntos(View v) {
            Intent in = new Intent(TelaTriangulo.this, MainScreen.class);
            startActivity(in);
        }

    public void trocaQuestaoTriangulo(View v) {
        Intent in = new Intent(TelaTriangulo.this, QuestaoTriangulo.class);
        startActivity(in);
    }
}