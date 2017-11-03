package com.preccytech.cryptocon;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonParser;
import com.preccytech.cryptocon.model.CurrencyAdapter;
import com.preccytech.cryptocon.model.currency;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<currency> currencyList;
    private RecyclerView.Adapter adapter;
    private RecyclerView mRecyclerView;

    private static final String URL_DATA = "https://min-api.cryptocompare.com/data/pricemulti?fsyms=BTC&tsyms=USD,EUR,GBP,ETH,NGN,XOF," +
            "CAD,KYD,CNY,XAF,LYD,INR,HRK,BYR,AED,AFN,TND,ARS,AUD,ZAR,BDT,KHR,DZD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.currency_card);

         mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        currencyList = new ArrayList<>();

        CurrencyRequest();
    }

    public void CurrencyRequest() {
        final ProgressDialog refresh = new ProgressDialog(this);
        refresh.setMessage("Refreshing...");
        refresh.show();

        //Request a String response
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_DATA, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                refresh.dismiss();

                try {
                    JSONObject root = new JSONObject(response);
                    JSONObject btc = root.getJSONObject("BTC");
                    HashMap<String, String> cryptoBtc = getValue(btc);
                    JSONObject eth = root.getJSONObject("ETH");
                    HashMap<String, String> cryptoEth = getValue(eth);
                    String btcCurrency1 = cryptoBtc.get("USD");
                    String btcCurrency2 = cryptoBtc.get("NGN");
                    String ethCurrency1 = cryptoEth.get("NGN");


                    currency currencylist = new currency(btcCurrency1);
                    currencyList.add(currencylist);

                    currencylist = new currency(btcCurrency2);
                    currencyList.add(currencylist);

                    adapter = new CurrencyAdapter(currencyList, getApplicationContext());
                    mRecyclerView.setAdapter(adapter);



                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error" + error.toString(), Toast.LENGTH_LONG).show();
            }
        });

        Volley.newRequestQueue(this).add(stringRequest);
    }


    //Leave this method here.
    public static HashMap<String, String> getValue(Object content) throws IOException, JSONException {
        HashMap<String, String> hashMap = null;

        if (content instanceof JSONObject) {
            JSONObject jsonObject = (JSONObject) content;  //Cast the object to JSONObject just for formality its alreay in jsonObject
            hashMap = new HashMap<>();

            Iterator<String> iterator = jsonObject.keys();  //Iterate thru and get all the currency names in the object e.g USD, NGN etc
            while (iterator.hasNext()) {
                String key = iterator.next();    //key here is the currency name e.g USD
                Object value = jsonObject.get(key); //value here is the amount e.g 6365.12               key   value
                hashMap.put(key, value.toString());  //put it in d hashmap: HashMap<String, String> === [USD, 6365.12]
            }
        }
        return hashMap;
    }


}
