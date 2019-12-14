package br.com.listamateriais;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView mRecyclerView;
    LineAdapter mAdapter;
    Button btnAdicionar;

    private void setupRecycler() {

        // Configurando o gerenciador de layout para ser uma lista.
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);

        mRecyclerView.setLayoutManager(layoutManager);

        // Adiciona o adapter que irá anexar os objetos à lista.
        // Está sendo criado com lista vazia, pois será preenchida posteriormente.

        mAdapter = new LineAdapter(new ArrayList(0));
        mRecyclerView.setAdapter(mAdapter);

        MaterialModel m1 = new MaterialModel();
        m1.setNome("Lapis");
        mAdapter.updateList(m1);
        MaterialModel m2 = new MaterialModel();
        m2.setNome("Borracha");
        mAdapter.updateList(m2);

        // Configurando um dividr entre linhas, para uma melhor visualização.
        mRecyclerView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));


        btnAdicionar = findViewById(R.id.btnAdicionar);
        btnAdicionar.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.viewList);
        setupRecycler();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAdicionar
            || v.getId() == R.id.main_line_more){
            Intent intent = new Intent(this, IncluirItemActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("qtdElementos", 10);
            intent.putExtras(bundle);

            startActivityForResult(intent, 1);
        }
    }

    protected void onActivityResult(int codigoTela, int resultado, Intent intent){
        if (codigoTela == 1) {
            Bundle bundle = intent.getExtras();

            if (bundle != null)
            {
                boolean sucesso = bundle.getBoolean("sucesso", false);

                if (sucesso){
                    String nome = bundle.getString("nome", "");
                    mAdapter.updateList(nome);
                }
            }
        }
    }
}
