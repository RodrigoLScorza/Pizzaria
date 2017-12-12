package com.example.logonrm.pizzaria;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.username)
    TextInputLayout username;

    @BindView(R.id.password)
    TextInputLayout password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        username.getEditText().addTextChangedListener(new MyWatcher(username));
        password.getEditText().addTextChangedListener(new MyWatcher(password));

    }

    @OnClick(R.id.bt_conectar)
    public void conectar() {
        if (username.getEditText().getText().toString().trim().length() == 0) {
            username.setError("Digite o Login!");
            return;
        }
        if (password.getEditText().getText().toString().trim().length() == 0) {
            password.setError("Digite o Senha!");
            return;
        }


        chamaMain();
    }


    private void chamaMain() {
        Intent it = new Intent(this, MainActivity.class);
        it.putExtra(Constantes.LOGIN, username.getEditText().getText().toString());
        it.putExtra(Constantes.PASSWORD, username.getEditText().getText().toString());
        startActivity(it);
        finish();
    }
}

