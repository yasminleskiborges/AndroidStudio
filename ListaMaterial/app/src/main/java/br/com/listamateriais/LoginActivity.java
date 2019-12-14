package br.com.listamateriais;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder viewHolder;
    private String login = "teste@teste.com.br";
    private String password = "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        viewHolder = new ViewHolder(this);
        viewHolder.btnLogin.setOnClickListener(this);
        viewHolder.btnExit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnLogin)
        {
            String userDigitado = viewHolder.edtLogin
                                            .getText()
                                            .toString()
                                            .toLowerCase();

            String passowordDigitado = viewHolder.edtPassword.getText().toString();

            if (userDigitado.equals(login) && passowordDigitado.equals(password)){
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("login", userDigitado);
                intent.putExtra("password", passowordDigitado);
                startActivity(intent);

            } else {
                Toast.makeText(this, "Usuário ou senha inválidos", Toast.LENGTH_LONG);
                viewHolder.edtPassword.setText("");
            }
        } else if (v.getId() == R.id.btnExit) {
            System.exit(0);
        }
    }


    class ViewHolder {
        private EditText edtLogin;
        private EditText edtPassword;
        private Button btnLogin;
        private Button btnExit;

        public ViewHolder(LoginActivity loginActivity){
            edtLogin = loginActivity.findViewById(R.id.edtLogin);
            edtPassword = loginActivity.findViewById(R.id.edtPassword);
            btnLogin = loginActivity.findViewById(R.id.btnLogin);
            btnExit = loginActivity.findViewById(R.id.btnExit);
        }

        public EditText getEdtLogin() {
            return edtLogin;
        }

        public void setEdtLogin(EditText edtLogin) {
            this.edtLogin = edtLogin;
        }

        public EditText getEdtPassword() {
            return edtPassword;
        }

        public void setEdtPassword(EditText edtPassword) {
            this.edtPassword = edtPassword;
        }

        public Button getBtnLogin() {
            return btnLogin;
        }

        public void setBtnLogin(Button btnLogin) {
            this.btnLogin = btnLogin;
        }

        public Button getBtnExit() {
            return btnExit;
        }

        public void setBtnExit(Button btnPassoword) {
            this.btnExit = btnPassoword;
        }


    }
}
