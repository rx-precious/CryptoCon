package com.preccytech.cryptocon.model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.preccytech.cryptocon.R;

import java.util.List;

/**
 * Created by Rx-Precious on 10/18/2017.
 */

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.MyViewHolder> {

    private Context mContext;
    private List<currency> currencyList;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView Currency;
        public TextView PriceHigh;
        public TextView PriceLow;
        public TextView CurrentPrice;

        public MyViewHolder(View ItemView){
            super(ItemView);

            Currency = (TextView) ItemView.findViewById(R.id.currency_from);
            CurrentPrice = (TextView) ItemView.findViewById(R.id.current_exchange);


        }

    }

    public CurrencyAdapter( List<currency> currencyList, Context mContext){
        this.mContext = mContext;
        this.currencyList = currencyList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View CurrencyView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.currency_card, parent, false);
        return new MyViewHolder(CurrencyView);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder,  int position){
        currency currency = currencyList.get(position);
       // holder.Currency.setText(currency.getConvertFrom() + "/" + currency.getConvertTo());
        holder.CurrentPrice.setText(currency.getCurrentExchange());
       // holder.PriceHigh.setText(currency.getHourHigh());
       // holder.PriceLow.setText(currency.getHourLow());
    }

    @Override
    public int getItemCount(){
        return currencyList.size();

    }
}
