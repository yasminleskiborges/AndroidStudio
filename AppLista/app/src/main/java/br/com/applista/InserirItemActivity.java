package br.com.applista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InserirItemActivity extends AppCompatActivity implements View.OnClickListener {
    TextView edtQtdElementos;
    EditText edtNome;
    Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_item);

        edtQtdElementos = findViewById(R.id.edtQtdElementos);

        Intent intent = getIntent();
        int qtdElementos = intent.getIntExtra("qtdElementos", 0);

        edtQtdElementos.setText(String.valueOf(qtdElementos));

        edtNome = findViewById(R.id.edtNome);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = getIntent();
        i.putExtra("nome", edtNome.getText().toString());
        i.putExtra("sucesso", true);

        setResult(1, i);
        finish();
    }
}
