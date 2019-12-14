package br.com.applista;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView mRecyclerList;
    LineAdapter mLineAdapter;
    Button btnAdicionar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerList = findViewById(R.id.viewList);

        configurarRecyclerView();

        mLineAdapter.insertItem("Caneta Azul");
        mLineAdapter.insertItem("Apagador");

        btnAdicionar = findViewById(R.id.btnAdicionar);
        btnAdicionar.setOnClickListener(this);
    }

    protected void configurarRecyclerView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);

        mLineAdapter = new LineAdapter();
        mRecyclerList.setLayoutManager(layoutManager);
        mRecyclerList.setAdapter(mLineAdapter);

        // Configurando um dividr entre linhas, para uma melhor visualização.
        mRecyclerList.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAdicionar) {
            Bundle b = new Bundle();
            b.putInt("qtdElementos", mLineAdapter.getItemCount());

            Intent intent = new Intent(this,
                                       InserirItemActivity.class);
            intent.putExtras(b);

            startActivityForResult(intent, 1);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bundle bundle = data.getExtras();
        boolean sucesso = bundle.getBoolean("sucesso", false);

        if (sucesso == true){

            String nome = bundle.getString("nome", "");

            mLineAdapter.insertItem(nome);
        }


    }
}
