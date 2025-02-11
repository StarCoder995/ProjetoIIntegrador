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
import android.widget.ImageButton;

public class MainScreen extends AppCompatActivity {
    ImageButton trocaquadrado,trocaretangulo,trocacirculo,trocatriangulo;
    Intent TelaQuadrado,TelaRetangulo,TelaCirculo,TelaTriangulo;
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
    }
    public void trocatriangulo(View v) {
        Intent in = new Intent(MainScreen.this, TelaTriangulo.class);
        startActivity(in);
    }

    public void trocaquadrado(View v) {
        Intent in = new Intent(MainScreen.this, TelaQuadrado.class);
        startActivity(in);
    }

    public void trocaretangulo(View v) {
        Intent in = new Intent(MainScreen.this, TelaRetangulo.class);
        startActivity(in);
    }

    public void trocacirculo(View v) {
        Intent in = new Intent(MainScreen.this, TelaCirculo.class);
        startActivity(in);
    }
}