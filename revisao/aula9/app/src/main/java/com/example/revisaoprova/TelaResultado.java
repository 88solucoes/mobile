package com.example.revisaoprova;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TelaResultado extends AppCompatActivity {
    private TextView acertos;
    private TextView mensagem;
    private ImageView neymar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_resultado);
        acertos = findViewById(R.id.textViewQtdAcertos);
        mensagem = findViewById(R.id.textViewMensagem);
        neymar = findViewById(R.id.imageViewNeymar);

        String resposta1 = getIntent().getStringExtra("chaveResposta1");
        String resposta2 = getIntent().getStringExtra("chaveResposta2");
        String resposta3 = getIntent().getStringExtra("chaveResposta3");
        int qtdAcertos = 0;
        if(resposta1.equalsIgnoreCase("Não")){
            qtdAcertos++;
        }
        if(resposta2.equalsIgnoreCase("Não")){
            qtdAcertos++;
        }
        if(resposta3.equalsIgnoreCase("Sim")){
            qtdAcertos++;
        }
        if(qtdAcertos == 3){
            //neymar.setImageResource(R.drawable.neymar1); -- EXEMPLO DE DEFINIÇÃO DE IMAGEM EM CÓDIGO
            acertos.setText("Quantidade de acertos: 3");
            mensagem.setText("Você é um verdadeiro fã do Neymar!");
        }else if(qtdAcertos == 2){
            acertos.setText("Quantidade de acertos: 2");
            mensagem.setText("Você precisa estudar mais sobre Neymar");
        }else if(qtdAcertos == 1){
            acertos.setText("Quantidade de acertos: 1");
            mensagem.setText("Neymar não está satisfeito com seu desempenho");
        }else{
            acertos.setText("Quantidade de acertos: 0");
            mensagem.setText("Neymar e o Brasil estão tristes com você");
        }
    }
}