package com.example.ddurbin_currencycoversion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double conversionUStoUK = 0.77;
    double conversionUKtoUS = 1.30;
    double amountEntered = 0.0;
    double finalResult = 0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // set up logo in action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        //set up constants to get information from main screen
        final EditText amount = (EditText)findViewById(R.id.idAmtInput);
        final RadioButton dlrToPnd = (RadioButton)findViewById(R.id.idRadDlrToPnd);
        final RadioButton pndToDlr = (RadioButton)findViewById(R.id.idRadPndToDlr);
        final TextView displayResult = (TextView)findViewById(R.id.idTxtResult);
        Button convert = (Button)findViewById(R.id.idConvBtn);

        // run the conversion using listener
        convert.setOnClickListener(
            amountEntered = Double.parseDouble(amount.getText().toString());
            DecimalFormat currencyUS = new DecimalFormat("$##,###.##");
            DecimalFormat currencyUK = new DecimalFormat("£##,###.##");
            if (dlrToPnd.isChecked()) {
                if (amountEntered <= 10000) {
                    finalResult = amountEntered * conversionUStoUK;
                    displayResult.setText(currencyUK.format(finalResult));
                } else {
                    Toast.makeText(MainActivity.this, "Amount must be less than $10,000.",
                            Toast.LENGTH_LONG).show();
                }
            }
            if (pndToDlr.isChecked()) {
                if (amountEntered <= 13000) {
                    finalResult = amountEntered * conversionUKtoUS;
                    displayResult.setText(currencyUS.format(finalResult));
                } else {
                    Toast.makeText(MainActivity.this, "Amount must be less than £13,000.",
                            Toast.LENGTH_LONG).show();
                }
            }
        );
    }
}
