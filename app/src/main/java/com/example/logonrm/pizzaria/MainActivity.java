package com.example.logonrm.pizzaria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.logonrm.pizzaria.Model.Pedido;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.ckb_b)
    CheckBox ckbBacon;

    @BindView(R.id.ckb_c)
    CheckBox ckbCalabresa;

    @BindView(R.id.ckb_cm)
    CheckBox ckbCamarao;

    @BindView(R.id.ckb_cho)
    CheckBox ckbChocolate;


    @BindView(R.id.rg_tamanho)
    RadioGroup rg_tamanho;


    @BindView(R.id.spPagamentos)
    Spinner sp;

    Pedido pedido = null;
    String user;
    private String tamanho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pedido = new Pedido();

        ButterKnife.bind(this);

        if (getIntent() != null) {
            user = getIntent().getStringExtra(Constantes.LOGIN);
        }


        ckbBacon.setOnCheckedChangeListener(this);
        ckbCalabresa.setOnCheckedChangeListener(this);
        ckbCamarao.setOnCheckedChangeListener(this);
        ckbChocolate.setOnCheckedChangeListener(this);

        rg_tamanho.setOnCheckedChangeListener(this);

    }

    @OnClick(R.id.btFecharPedido)
    public void fecharPedido() {
        pedido.setUsuario(user);
        pedido.setTamanho(tamanho);
        pedido.setFormaPagamento(sp.getSelectedItem().toString());


        Intent it = new Intent(this, ConfirmarPedidoActivity.class);
        it.putExtra(Constantes.LOGIN, pedido);
        startActivity(it);
        finish();

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            pedido.addSabor(buttonView.getText().toString());
        } else {
            pedido.removerSabor(buttonView.getText().toString());
        }


    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        tamanho = ((RadioButton) findViewById(checkedId)).getText().toString();
    }
}
