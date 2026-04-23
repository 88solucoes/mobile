package com.example.ava1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Resultado extends AppCompatActivity {

    TextView txtResultado;
    Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        txtResultado = findViewById(R.id.txtResultado);
        btnFinalizar = findViewById(R.id.btnProximo);

        int pontos = getIntent().getIntExtra("pontos", 0);

        String mensagem;

        if (pontos == 12) {
            mensagem = getString(R.string.msg_mestre);
        } else if (pontos == 8) {
            mensagem = getString(R.string.msg_intermediario);
        } else if (pontos == 4) {
            mensagem = getString(R.string.msg_iniciante);
        } else {
            mensagem = getString(R.string.msg_ruim);
        }

        txtResultado.setText("Pontuação: " + pontos + "\n\n" + mensagem);

        btnFinalizar.setOnClickListener(v -> finish());
    }
}