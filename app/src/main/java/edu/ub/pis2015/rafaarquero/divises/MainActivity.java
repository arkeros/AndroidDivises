package edu.ub.pis2015.rafaarquero.divises;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {
    private TextView lblFrom;
    private TextView lblTo;
    private CalculatorListener calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblFrom = (TextView) findViewById(R.id.lblFrom);
        lblTo = (TextView) findViewById(R.id.lblTo);

        calculator = new CalculatorListener(
            (EditText) findViewById(R.id.txtTipus),
            (EditText) findViewById(R.id.txtCommission),
            (EditText) findViewById(R.id.txtFrom),
            (EditText) findViewById(R.id.txtTo)
        );
    }

    public void toggleDivises(View v) {
        calculator.toggle();
        if (calculator.isEurToUsd()) {
            lblFrom.setText(R.string.EUR);
            lblTo.setText(R.string.USD);
        } else {
            lblFrom.setText(R.string.USD);
            lblTo.setText(R.string.EUR);
        }
        calculator.calc();
    }
}
