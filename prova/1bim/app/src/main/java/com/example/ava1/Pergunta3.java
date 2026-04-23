package com.example.ava1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Pergunta3 extends AppCompatActivity {

    RadioGroup radioGroup;
    Button btnProximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta3);

        radioGroup = findViewById(R.id.radioGroup);
        btnProximo = findViewById(R.id.btnProximo);

        int pontosAnteriores = getIntent().getIntExtra("pontos", 0);

        btnProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selecionado = radioGroup.getCheckedRadioButtonId();

                if (selecionado == -1) {
                    Toast.makeText(Pergunta3.this,
                            "Selecione uma opção",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                int pontos = pontosAnteriores;

                // CORRETA: Andorra (rb1)
                if (selecionado == R.id.rb1) {
                    pontos = pontos + 3;
                } else {
                    pontos = pontos - 1;
                }

                Intent intent = new Intent(Pergunta3.this, Pergunta3.class);
                intent.putExtra("pontos", pontos);
                startActivity(intent);
            }
        });
    }
}