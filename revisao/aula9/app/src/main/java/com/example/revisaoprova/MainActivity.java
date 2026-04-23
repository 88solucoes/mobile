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

public class MainActivity extends AppCompatActivity {
    private RadioGroup pergunta1;
    private Button proximo;
    private RadioButton resposta1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        pergunta1 = findViewById(R.id.radioGroupPergunta1);
        proximo = findViewById(R.id.buttonPergunta1);

        proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idResposta1 = pergunta1.getCheckedRadioButtonId();
                if(idResposta1 == -1){
                    Toast.makeText(MainActivity.this, "Selecione a resposta!", Toast.LENGTH_SHORT).show();
                }else{
                    resposta1 = findViewById(idResposta1);
                    String resposta1Str = resposta1.getText().toString();
                    Intent intent1 = new Intent(MainActivity.this, Tela2.class);
                    intent1.putExtra("chaveResposta1", resposta1Str);
                    startActivity(intent1);
                }
            }
        });
    }
}