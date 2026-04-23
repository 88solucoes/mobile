package com.example.ava1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    Button btnProximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        btnProximo = findViewById(R.id.btnProximo);

        btnProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int pontos = 0;

                int selecionado = radioGroup.getCheckedRadioButtonId();

                // validação obrigatória
                if (selecionado == -1) {
                    Toast.makeText(MainActivity.this,
                            "Selecione uma opção",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                // resposta correta: Uganda (rb3)
                if (selecionado == R.id.rb3) {
                    pontos = 3;
                } else {
                    pontos = -1;
                }

                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                intent.putExtra("pontos", pontos);
                startActivity(intent);
            }
        });
    }
}