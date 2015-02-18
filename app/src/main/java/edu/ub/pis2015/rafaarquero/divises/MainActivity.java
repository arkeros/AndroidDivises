package edu.ub.pis2015.rafaarquero.divises;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    EditText txtTipus;
    EditText txtComission;
    EditText txtFrom;
    EditText txtTo;
    TextView lblFrom;
    TextView lblTo;
    CalculatorListener calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTipus = (EditText) findViewById(R.id.txtTipus);
        txtComission = (EditText) findViewById(R.id.txtComission);
        txtFrom = (EditText) findViewById(R.id.txtFrom);
        txtTo = (EditText) findViewById(R.id.txtTo);
        lblFrom = (TextView) findViewById(R.id.lblFrom);
        lblTo = (TextView) findViewById(R.id.lblTo);

        calculator = new CalculatorListener(txtTipus, txtComission, txtFrom, txtTo);
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

    public void changeDivises(View v) {
        calculator.change();
        if (eur2usd) {
            lblFrom.setText(R.string.EUR);
            lblTo.setText(R.string.USD);
        } else {
            lblFrom.setText(R.string.USD);
            lblTo.setText(R.string.EUR);
        }
    }
}
