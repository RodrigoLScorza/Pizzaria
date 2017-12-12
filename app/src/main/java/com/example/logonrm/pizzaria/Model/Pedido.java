package com.example.logonrm.pizzaria.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by logonrm on 11/12/2017.
 */

public class Pedido implements Parcelable {
    private String usuario;
    private List<String> listaPizzas;
    private String tamanho;
    private String formaPagamento;


    public Pedido() {
    }

    protected Pedido(Parcel in) {
        usuario = in.readString();
        listaPizzas = in.createStringArrayList();
        tamanho = in.readString();
        formaPagamento = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(usuario);
        dest.writeStringList(listaPizzas);
        dest.writeString(tamanho);
        dest.writeString(formaPagamento);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Pedido> CREATOR = new Creator<Pedido>() {
        @Override
        public Pedido createFromParcel(Parcel in) {
            return new Pedido(in);
        }

        @Override
        public Pedido[] newArray(int size) {
            return new Pedido[size];
        }
    };

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public List<String> getListaPizzas() {
        return listaPizzas;
    }

    public void setListaPizzas(List<String> listaPizzas) {
        this.listaPizzas = listaPizzas;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public void addSabor(String sabor) {
        if (listaPizzas == null) {
            listaPizzas = new ArrayList<>();
        }
    }

    public void removerSabor(String removerSabor) {
        if (listaPizzas != null) {
            listaPizzas.remove(removerSabor);
        }
    }


}
