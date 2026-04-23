package com.example.revisaoprova;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Tela3 extends AppCompatActivity {
    private RadioGroup pergunta3;
    private Button enviar3;
    private RadioButton resposta3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela3);
        pergunta3 = findViewById(R.id.radioGroupPergunta3);
        enviar3 = findViewById(R.id.buttonPergunta3);
        enviar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idResposta3 = pergunta3.getCheckedRadioButtonId();
                if(idResposta3 == -1){
                    Toast.makeText(Tela3.this, "Selecione uma opção!", Toast.LENGTH_SHORT).show();
                }else{
                    String resposta1Str = getIntent().getStringExtra("chaveResposta1");
                    String resposta2Str = getIntent().getStringExtra("chaveResposta2");
                    resposta3 = findViewById(idResposta3);
                    String resposta3Str = resposta3.getText().toString();
                    Intent intent3 = new Intent(Tela3.this, TelaResultado.class);
                    intent3.putExtra("chaveResposta1", resposta1Str);
                    intent3.putExtra("chaveResposta2", resposta2Str);
                    intent3.putExtra("chaveResposta3", resposta3Str);
                    startActivity(intent3);
                }
            }
        });
    }
}