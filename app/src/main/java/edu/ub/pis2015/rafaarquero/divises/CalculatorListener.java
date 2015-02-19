package edu.ub.pis2015.rafaarquero.divises;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Created by rarquegi7.alumnes on 18/02/15.
 */
public class CalculatorListener implements TextWatcher {
    private EditText txtTipus;
    private EditText txtCommission;
    private EditText txtFrom;
    private EditText txtTo;
    private boolean eur2usd;

    public CalculatorListener(EditText txtTipus, EditText txtCommission, EditText txtFrom, EditText txtTo) {
        this.txtTipus = txtTipus;
        this.txtCommission = txtCommission;
        this.txtFrom = txtFrom;
        this.txtTo = txtTo;
        eur2usd = true;
        txtTipus.addTextChangedListener(this);
        txtCommission.addTextChangedListener(this);
        txtFrom.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        try {
            calc();
        } catch(NumberFormatException ignored) {
        }
    }

    public float getInput() {
        return Float.parseFloat(txtFrom.getText().toString());
    }

    public float getTipus() {
        float value = Float.parseFloat(txtTipus.getText().toString());
        if (eur2usd)
            return value;
        else
            return 1.0f / value;
    }

    public float calc() {
        float output;
        output =  getInput() * (1.0f - getCommission()) * getTipus();
        txtTo.setText(Float.toString(output));
        return output;
    }

    public float getCommission() {
        return Float.parseFloat(txtCommission.getText().toString()) / 100.0f;
    }

    public void toggle() {
        this.eur2usd ^= true;
    }

    public boolean isEurToUsd() {
        return eur2usd;
    }
}
