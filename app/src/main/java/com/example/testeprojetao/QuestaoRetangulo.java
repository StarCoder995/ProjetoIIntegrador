package com.example.testeprojetao;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
// Imports Utilizados
import android.view.View;
import android.widget.TextView;
import android.widget.RadioGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.content.Intent;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class QuestaoRetangulo extends AppCompatActivity {

    private TextView questionTextView;
    private RadioGroup answersRadioGroup;
    private Button submitButton;
    private TextView resultTextView;

    Intent TelaConteudo;
    private Button voltarAoConteudo;

    private List<Question> questions;
    private int currentQuestionIndex = 0;   //Número da questão atual na lista
    private List<Question> correctAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_questao_retangulo);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        questionTextView = findViewById(R.id.questionTextView);     // comando da questao
        answersRadioGroup = findViewById(R.id.answersRadioGroup);   // lista de respostas
        submitButton = findViewById(R.id.submitButton);             // botao de enviar
        resultTextView = findViewById(R.id.resultTextView);         // caixa de resultado

        questions = new ArrayList<>(); //Lista das perguntas

        // Prox 3 linhas: Cria perguntas na lista de perguntas
        questions.add(new Question("Quantos lados possui um retângulo?", Arrays.asList("2", "3", "4", "5"), "4"));
        questions.add(new Question("Marque uma característica correta de um retângulo:", Arrays.asList("4 lados iguais", "Tem apenas 3 lados", "Tem 2 pares de lados iguais", "Todos os lados são diferentes"), "Tem 2 pares de lados iguais"));
        questions.add(new Question("Um retângulo tem 10 cm de comprimento e 5 cm de largura. Qual é o seu perímetro?", Arrays.asList("17cm", "24cm", "30cm", "34cm"), "30cm"));
        questions.add(new Question("No jogo Ampe, o espaço delimitado no chão é formado por dois retângulos. Qual das opções abaixo é verdadeira sobre os lados opostos de um retângulo?", Arrays.asList("Eles têm tamanhos diferentes.", "Eles têm o mesmo tamanho", "São sempre menores que o comprimento do retângulo.", "Os lados opostos formam um triângulo."), "Eles têm o mesmo tamanho"));
        questions.add(new Question("No Ampe, um retângulo no chão tem 4 metros de comprimento e 2 metros de largura. Qual é o perímetro desse retângulo?", Arrays.asList("8m", "12m", "14m", "16m"), "12m"));

        correctAnswers = new ArrayList<>();

        loadQuestion();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = answersRadioGroup.getCheckedRadioButtonId();         // Essa varável armazena o id(posiça) da resposta marcada no momento que se aperta o botao
                if (selectedId != -1) {                                               //Testa para ver se há uma escolha feita
                    RadioButton botaoMarcado = findViewById(selectedId);              // Cria um objeto ligado a resposta selecionada, usando o id armazenado antes
                    String respostaMarcada = botaoMarcado.getText().toString();       // transforma o texto da botaoMarcadao em uma string
                    Question currentQuestion = questions.get(currentQuestionIndex);   //extrai a questão da lista , para ser usada Obs : Isso não entra em conflito com aquela do loadQuestion(), pois são objetos dentro de métodos, limitados a eles

                    if (respostaMarcada.equals(currentQuestion.getCorrectAnswer())) { //testa se a resposta escolhida é igual à correta
                        correctAnswers.add(currentQuestion);  
                        resultTextView.setText("Que Giro!");                                //Se sim, Afirma isso na caixa de resultado
                    } 
                    else {
                        resultTextView.setText("Errou, mano");
                    }
                    currentQuestionIndex++;                           //Aumenta o número da questão a ser usada
                    if (currentQuestionIndex < questions.size()) {  //Testa para ver se ainda estamos dentro da quantia de questões
                        loadQuestion();                             //Se sim, carrega a próxima
                    } else {
                        showCorrectAnswers();                       //Se não, mostra as que foram acertadas
                    }
                } else {
                    resultTextView.setText("Por favor, selecione uma resposta.");      //Resposta caso o user não tenha escolhido nada
                }
            }
        });

        voltarAoConteudo = findViewById(R.id.voltarAoConteudo);
        TelaConteudo = new Intent(this, TelaRetangulo.class);
        voltarAoConteudo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(TelaConteudo);
            }
        });
    }
    private void loadQuestion(){
        //Linha a seguir: Carrega a questão atual, extraindo ela da lista com base no número dela
        Question currentQuestion = questions.get(currentQuestionIndex);
        questionTextView.setText(currentQuestion.getQuestion()); // importa o titulo da questão
        answersRadioGroup.clearCheck();
            /*
            Descriçao do loop a seguir:
            - Cria uma Váriavel de navegaçao
            - Essa variável vai de zero até o último elemento da lista de respostas
            - Para cada posição, é criado um objeto pro botao das respostas, criado com o texto de resposta extraído
             */
        for (int i = 0; i < currentQuestion.getAnswers().size(); i++) {
            RadioButton radioButton = (RadioButton) answersRadioGroup.getChildAt(i);
            radioButton.setText(currentQuestion.getAnswers().get(i));
        }
      new Handler().postDelayed(() -> resultTextView.setText(""), 2000); 
    }

    private void showCorrectAnswers() {
        StringBuilder questoesAcertadas = new StringBuilder("Você respondeu corretamente as seguintes perguntas:\n");
        for (Question question : correctAnswers) {
            questoesAcertadas.append(question.getQuestion()).append(" - Resposta correta: ").append(question.getCorrectAnswer()).append("\n");
        }
        resultTextView.setText(questoesAcertadas);
    }
}
