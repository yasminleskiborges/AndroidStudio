package br.com.listamateriais;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class IncluirItemActivity extends AppCompatActivity {

    ViewHolder viewHolder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incluir_item);

        viewHolder = new ViewHolder(this);

        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        int qtdElementos = bundle.getInt("qtdElementos", 0);
        viewHolder.edtQuantidadeElementos.setText("Elementos da lista: " + qtdElementos);

        viewHolder.btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("nome", viewHolder.edtNome.getText().toString());
                intent.putExtra("sucesso", true);
                setResult(1, intent);
                finish();
            }
        });

        viewHolder.btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("sucesso", false);
                setResult(2, intent);
                finish();
            }
        });
    }



    class ViewHolder {
        public EditText edtNome;
        public TextView edtQuantidadeElementos;
        public Button btnSalvar;
        public Button btnCancelar;

        public ViewHolder(IncluirItemActivity activity)
        {
            edtNome = activity.findViewById(R.id.edtNome);
            edtQuantidadeElementos = activity.findViewById(R.id.edtQuantidadeElementos);
            btnSalvar = activity.findViewById(R.id.btnSalvar);
            btnCancelar = activity.findViewById(R.id.btnCancelar);

        }
    }
}
