package br.com.applista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtLogin;
    EditText edtSenha;
    Button btnLogin;
    Button btnSair;

    final String login = "leskiyasmin@gmail.com";
    final String password = "yasmin12";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtLogin = findViewById(R.id.edtLogin);
        edtSenha = findViewById(R.id.edtSenha);
        btnLogin = findViewById(R.id.btnLogin);
        btnSair = findViewById(R.id.btnSair);

        btnLogin.setOnClickListener(this);
        btnSair.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        //efetuar login
        if (view.getId() == R.id.btnLogin){
            String usuarioDigitado = edtLogin.getText().toString().toLowerCase();
            String senhaDigitado = edtSenha.getText().toString();

            if (usuarioDigitado.equals(login) && senhaDigitado.equals(password)){


                Intent i = new Intent(this, MainActivity.class);
                i.putExtra("login", usuarioDigitado);
                i.putExtra("senha", senhaDigitado);

                startActivity(i);

            } else {
                Toast.makeText(this, "Usuário ou senha inválidos", Toast.LENGTH_LONG).show;
            }
        }

        else if (view.getId() == R.id.btnSair){
            System.exit(0);
        }
    }
}
