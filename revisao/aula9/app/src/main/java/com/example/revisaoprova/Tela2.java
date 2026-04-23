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

public class Tela2 extends AppCompatActivity {
    private RadioGroup pergunta2;
    private Button proximo2;
    private RadioButton resposta2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela2);
        pergunta2 = findViewById(R.id.radioGroupPergunta2);
        proximo2 = findViewById(R.id.buttonPergunta2);

        proximo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //VERIFICAR SE ELE MARCOU A RESPOSTA
                int idResposta2 = pergunta2.getCheckedRadioButtonId();
                if(idResposta2 == -1){
                    Toast.makeText(Tela2.this, "Selecione a resposta", Toast.LENGTH_SHORT).show();
                }else{
                    String resposta1Str = getIntent().getStringExtra("chaveResposta1");
                    resposta2 = findViewById(idResposta2);
                    String resposta2Str = resposta2.getText().toString();
                    Intent intent2 = new Intent(Tela2.this, Tela3.class);
                    intent2.putExtra("chaveResposta1", resposta1Str);
                    intent2.putExtra("chaveResposta2", resposta2Str);
                    startActivity(intent2);
                }
            }
        });
    }
}