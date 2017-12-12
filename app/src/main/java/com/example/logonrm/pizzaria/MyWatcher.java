package com.example.logonrm.pizzaria;

import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by logonrm on 11/12/2017.
 */

public class MyWatcher implements TextWatcher {
    TextInputLayout editText;


    public MyWatcher(TextInputLayout editText) {
        this.editText = editText;

    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (editText.getEditText().getText().toString().trim().length() != 0){
            editText.setError(null);
        }

    }
}
