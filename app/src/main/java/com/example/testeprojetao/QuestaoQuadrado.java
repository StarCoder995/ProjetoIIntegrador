package com.example.testeprojetao;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestaoQuadrado extends AppCompatActivity {

    private TextView questionTextView;
    private RadioGroup answersRadioGroup;
    private Button submitButton;
    private TextView resultTextView;

    private List<Question> questions;
    private int currentQuestionIndex = 0;
    private List<Question> correctAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao_quadrado);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        questionTextView = findViewById(R.id.questionTextView);
        answersRadioGroup = findViewById(R.id.answersRadioGroup);
        submitButton = findViewById(R.id.submitButton);
        resultTextView = findViewById(R.id.resultTextView);

        // Inicializar perguntas
        questions = new ArrayList<>();
        questions.add(new Question("Qual é a capital da França?", Arrays.asList("Berlim", "Madri", "Paris", "Lisboa"), "Paris"));
        questions.add(new Question("Qual é a capital da Espanha?", Arrays.asList("Berlim", "Madri", "Paris", "Lisboa"), "Madri"));
        questions.add(new Question("Qual é a capital de Portugal?", Arrays.asList("Berlim", "Madri", "Paris", "Lisboa"), "Lisboa"));

        correctAnswers = new ArrayList<>();
        loadQuestion();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = answersRadioGroup.getCheckedRadioButtonId();
                if (selectedId != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    String selectedAnswer = selectedRadioButton.getText().toString();
                    Question currentQuestion = questions.get(currentQuestionIndex);

                    if (selectedAnswer.equals(currentQuestion.getCorrectAnswer())) {
                        resultTextView.setText("Correto!");
                        correctAnswers.add(currentQuestion);
                    } else {
                        resultTextView.setText("Incorreto! A resposta correta é " + currentQuestion.getCorrectAnswer() + ".");
                    }

                    currentQuestionIndex++;
                    if (currentQuestionIndex < questions.size()) {
                        loadQuestion();
                    } else {
                        showCorrectAnswers();
                    }
                } else {
                    resultTextView.setText("Por favor, selecione uma resposta.");
                }
            }
        });
    }

    private void loadQuestion() {
        Question currentQuestion = questions.get(currentQuestionIndex);
        questionTextView.setText(currentQuestion.getQuestion());
        answersRadioGroup.clearCheck();
        for (int i = 0; i < currentQuestion.getAnswers().size(); i++) {
            RadioButton radioButton = (RadioButton) answersRadioGroup.getChildAt(i);
            radioButton.setText(currentQuestion.getAnswers().get(i));
        }
        resultTextView.setText("");
    }

    private void showCorrectAnswers() {
        StringBuilder correctAnswersText = new StringBuilder("Você respondeu corretamente as seguintes perguntas:\n");
        for (Question question : correctAnswers) {
            correctAnswersText.append(question.getQuestion()).append(" - Resposta correta: ").append(question.getCorrectAnswer()).append("\n");
        }
        resultTextView.setText(correctAnswersText.toString());
    }
}