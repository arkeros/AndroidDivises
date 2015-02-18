package edu.ub.pis2015.rafaarquero.divises;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Created by rarquegi7.alumnes on 18/02/15.
 */
public class CalculatorListener implements TextWatcher {
    EditText txtTipus;
    EditText txtComission;
    EditText txtFrom;
    EditText txtTo;
    private boolean eur2usd;

    public CalculatorListener(EditText txtTipus, EditText txtComission, EditText txtFrom, EditText txtTo) {
        this.txtTipus = txtTipus;
        this.txtComission = txtComission;
        this.txtFrom = txtFrom;
        this.txtTo = txtTo;
        eur2usd = true;
        txtTipus.addTextChangedListener(this);
        txtComission.addTextChangedListener(this);
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
        txtTo.setText(Float.toString(calcOutput()));
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

    public float calcOutput() {
        return getInput() * (1.0f - getComission()) * getTipus();
    }

    public float getComission() {
        return Float.parseFloat(txtComission.getText().toString()) / 100.0f;
    }

    public void toggle() {
        this.eur2usd ^= true;
    }

    public boolean isEurToUsd() {
        return eur2usd;
    }
}
