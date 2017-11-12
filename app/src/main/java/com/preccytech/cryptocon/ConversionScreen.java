package com.preccytech.cryptocon;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.preccytech.cryptocon.model.CurrencyAdapter;


/**
 * Created by Rx-Precious on 11/5/2017.
 */

public class ConversionScreen extends AppCompatActivity {

    Double currency_price;
    TextView BaseTextView;
    EditText QuoteTextview;
    Double conversion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversion_screen);

        Button Convert = (Button) findViewById(R.id.convert);
        BaseTextView = (TextView) findViewById(R.id.base_currency);
        QuoteTextview = (EditText) findViewById(R.id.quote_currency);


        Intent intent = getIntent();
        final String currency_quote = intent.getStringExtra(CurrencyAdapter.KEY_CURRENCY_QUOTE);
        final String currency_base = intent.getStringExtra(CurrencyAdapter.KEY_CURRENCY_BASE);
        final String currency_priceS = intent.getStringExtra(CurrencyAdapter.KEY_CURRENT_EXCHANGE);
        final Double currency_price = Double.parseDouble(currency_priceS);


        BaseTextView.setHint(currency_price.toString() + " " + currency_quote);
        QuoteTextview.setHint("1 " + currency_base);

        Convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double inputPrice = Double.parseDouble(QuoteTextview.getText().toString());

                conversion = inputPrice * currency_price;


                BaseTextView.setText(conversion.toString() + " " + currency_quote);


            }
        });
    }


}


