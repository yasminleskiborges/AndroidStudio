package br.com.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    EditText painel;
    float valor1;
    float valor2;
    float resultado;
    String operacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View.OnClickListener clickNumero = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = findViewById(v.getId());
                painel.setText(painel.getText().toString() + btn.getText().toString());
            }

        };

        View.OnClickListener clickOperacao = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = findViewById(v.getId());
                valor1 = Float.parseFloat(painel.getText().toString());
                operacao = btn.getText().toString();
                painel.setText("");
            }
        };

        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);
        Button btn0 = findViewById(R.id.btn0);

        Button btnPonto = findViewById(R.id.btnPonto);
        Button btnIgual = findViewById(R.id.btnIgual);

        Button btnMais = findViewById(R.id.btnMais);
        Button btnMenos = findViewById(R.id.btnMenos);
        Button btnMultiplicacao = findViewById(R.id.btnMultiplicacao);
        Button btnDivisao = findViewById(R.id.btnDivisao);


        painel = findViewById(R.id.painel);

        btn1.setOnClickListener(clickNumero);
        btn2.setOnClickListener(clickNumero);
        btn3.setOnClickListener(clickNumero);
        btn4.setOnClickListener(clickNumero);
        btn5.setOnClickListener(clickNumero);
        btn6.setOnClickListener(clickNumero);
        btn7.setOnClickListener(clickNumero);
        btn8.setOnClickListener(clickNumero);
        btn9.setOnClickListener(clickNumero);
        btn0.setOnClickListener(clickNumero);

        btnMais.setOnClickListener(clickOperacao);
        btnMenos.setOnClickListener(clickOperacao);
        btnMultiplicacao.setOnClickListener(clickOperacao);
        btnDivisao.setOnClickListener(clickOperacao);

        btnIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valor2 = Float.parseFloat(painel.getText().toString());


                if (operacao.equals("+"))
                {
                    resultado = valor1 + valor2;
                }

                if (operacao.equals("-"))
                {
                    resultado = valor1 - valor2;
                }

                if (operacao.equals("*"))
                {
                    resultado = valor1 * valor2;
                }

                if (operacao.equals("/"))
                {
                    resultado = valor1 / valor2;
                }

                painel.setText(String.valueOf(resultado));
            }
        });
    }

}
