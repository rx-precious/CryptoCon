package com.preccytech.cryptocon.model;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.preccytech.cryptocon.ConversionScreen;
import com.preccytech.cryptocon.R;

import java.util.List;

/**
 * Created by Rx-Precious on 10/18/2017.
 */

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.MyViewHolder> {

    public static final String KEY_CURRENT_EXCHANGE = "current_exchange";
    public static final String KEY_CURRENCY_BASE= "currency_base";
    public static final String KEY_CURRENCY_QUOTE= "currency_quote";

    private Context mContext;
    private List<currency> currencyList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView Currency;
        public TextView CurrentPrice;
        public RelativeLayout CurrencyCard;

        public MyViewHolder(View ItemView) {
            super(ItemView);

            Currency = (TextView) ItemView.findViewById(R.id.currency_from);
            CurrentPrice = (TextView) ItemView.findViewById(R.id.current_exchange);
            CurrencyCard = (RelativeLayout) ItemView.findViewById(R.id.currency_card);
        }

    }

    public CurrencyAdapter(List<currency> currencyList, Context mContext) {
        this.mContext = mContext;
        this.currencyList = currencyList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View CurrencyView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.currency_card, parent, false);
        return new MyViewHolder(CurrencyView);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        currency currency = currencyList.get(position);
       holder.Currency.setText(currency.getConvertFrom() + "/" + currency.getConvertTo());
        holder.CurrentPrice.setText(currency.getCurrentExchange());
        // holder.PriceHigh.setText(currency.getHourHigh());
        // holder.PriceLow.setText(currency.getHourLow());

        holder.CurrencyCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                currency Currencycard = currencyList.get(position);

                Intent skipIntent = new Intent(v.getContext(), ConversionScreen.class);
                skipIntent.putExtra(KEY_CURRENT_EXCHANGE, Currencycard.getCurrentExchange());
                skipIntent.putExtra(KEY_CURRENCY_BASE, Currencycard.getConvertFrom());
                skipIntent.putExtra(KEY_CURRENCY_QUOTE, Currencycard.getConvertTo());
                v.getContext().startActivity(skipIntent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return currencyList.size();

    }
}
