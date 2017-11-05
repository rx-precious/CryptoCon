package com.preccytech.cryptocon;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.preccytech.cryptocon.model.CurrencyAdapter;


/**
 * Created by Rx-Precious on 11/5/2017.
 */

public class ConversionScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversion_screen);

        Button Convert = (Button) findViewById(R.id.convert);
        EditText BaseTextView = (EditText) findViewById(R.id.base_currency);
        EditText QuoteTextview = (EditText) findViewById(R.id.quote_currency);


        Intent intent = getIntent();
        final String currency_quote = intent.getStringExtra(CurrencyAdapter.KEY_CURRENCY_QUOTE);
        final String currency_base = intent.getStringExtra(CurrencyAdapter.KEY_CURRENCY_BASE);
        final String currency_priceS = intent.getStringExtra(CurrencyAdapter.KEY_CURRENT_EXCHANGE);
        Float currency_price = Float.parseFloat(String.valueOf(currency_priceS));

        String convert_baseS = BaseTextView.getText().toString();
        Float convert_base = Float.parseFloat(String.valueOf(convert_baseS));
        String convert_quoteS = QuoteTextview.getText().toString();
        Float convert_quote = Float.parseFloat(String.valueOf(convert_quoteS));


        BaseTextView.setHint(currency_base);
        QuoteTextview.setHint(currency_quote);

          Float conversionBaseToQuoteS = convert_base * currency_price;
        final String conversionBaseToQuote = Float.toString(conversionBaseToQuoteS);
        Float conversionQoteToBaseS = convert_quote / currency_price;
        final String conversionQoteToBase = Float.toString(conversionQoteToBaseS);


        Convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText BaseTextView = (EditText) findViewById(R.id.base_currency);
                EditText QuoteTextview = (EditText) findViewById(R.id.quote_currency);

                if (BaseTextView != null) {
                    QuoteTextview.setText(conversionBaseToQuote);
                }else{
                    BaseTextView.setText(conversionQoteToBase);

                }


            }
        });


    }
}

