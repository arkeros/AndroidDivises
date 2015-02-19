package edu.ub.pis2015.rafaarquero.divises;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
    }
}
