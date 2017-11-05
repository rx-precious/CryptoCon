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

    private static final String URL_DATA = "https://min-api.cryptocompare.com/data/pricemulti?fsyms=BTC,ETH&tsyms=USD,EUR,GBP,NGN,XOF,CAD,CNY,XAF,INR,HRK,BYR,AED,AFN,TND,ARS,AUD,ZAR,BDT,KHR,DZD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                    String btcCurrency3 = cryptoBtc.get("EUR");
                    String btcCurrency4 = cryptoBtc.get("GBP");
                    String btcCurrency5 = cryptoBtc.get("XOF");
                    String btcCurrency6 = cryptoBtc.get("CAD");
                     String btcCurrency7 = cryptoBtc.get("KHR");
                    String btcCurrency8 = cryptoBtc.get("CNY");
                    String btcCurrency9 = cryptoBtc.get("XAF");
                    String btcCurrency10 = cryptoBtc.get("DZD");
                    String btcCurrency11 = cryptoBtc.get("INR");
                    String btcCurrency12 = cryptoBtc.get("HRK");
                    String btcCurrency13 = cryptoBtc.get("BYR");
                    String btcCurrency14 = cryptoBtc.get("AED");
                    String btcCurrency15 = cryptoBtc.get("AFN");
                    String btcCurrency16 = cryptoBtc.get("TND");
                    String btcCurrency17 = cryptoBtc.get("ARS");
                    String btcCurrency18 = cryptoBtc.get("AUD");
                    String btcCurrency19 = cryptoBtc.get("ZAR");
                    String btcCurrency20 = cryptoBtc.get("BDT");
                    String ethCurrency1 = cryptoEth.get("USD");
                    String ethCurrency2 = cryptoEth.get("NGN");
                    String ethCurrency3 = cryptoEth.get("EUR");
                    String ethCurrency4 = cryptoEth.get("GBP");
                    String ethCurrency5 = cryptoEth.get("XOF");
                    String ethCurrency6 = cryptoEth.get("CAD");
                    String ethCurrency7 = cryptoEth.get("KHR");
                    String ethCurrency8 = cryptoEth.get("CNY");
                    String ethCurrency9 = cryptoEth.get("XAF");
                    String ethCurrency10 = cryptoEth.get("DZD");
                    String ethCurrency11 = cryptoEth.get("INR");
                    String ethCurrency12 = cryptoEth.get("HRK");
                    String ethCurrency13 = cryptoEth.get("BYR");
                    String ethCurrency14 = cryptoEth.get("AED");
                    String ethCurrency15 = cryptoEth.get("AFN");
                    String ethCurrency16 = cryptoEth.get("TND");
                    String ethCurrency17 = cryptoEth.get("ARS");
                    String ethCurrency18 = cryptoEth.get("AUD");
                    String ethCurrency19 = cryptoEth.get("ZAR");
                    String ethCurrency20 = cryptoEth.get("BDT");


                    currency currencylist = new currency(btcCurrency1, "BTC","USD");
                    currencyList.add(currencylist);

                    currencylist = new currency(btcCurrency2, "BTC", "NGN");
                    currencyList.add(currencylist);

                    currencylist = new currency(btcCurrency3, "BTC", "EUR");
                    currencyList.add(currencylist);

                    currencylist = new currency(btcCurrency4, "BTC", "GBP");
                    currencyList.add(currencylist);

                    currencylist = new currency(btcCurrency5, "BTC", "XOF");
                    currencyList.add(currencylist);

                    currencylist = new currency(btcCurrency6, "BTC", "CAD");
                    currencyList.add(currencylist);

                    currencylist = new currency(btcCurrency7, "BTC", "KHR");
                    currencyList.add(currencylist);

                    currencylist = new currency(btcCurrency8, "BTC", "CNY");
                    currencyList.add(currencylist);

                    currencylist = new currency(btcCurrency9, "BTC", "ZAF");
                    currencyList.add(currencylist);

                    currencylist = new currency(btcCurrency10, "BTC", "DZD");
                    currencyList.add(currencylist);

                    currencylist = new currency(btcCurrency11, "BTC", "INR");
                    currencyList.add(currencylist);

                    currencylist = new currency(btcCurrency12, "BTC", "HRK");
                    currencyList.add(currencylist);

                    currencylist = new currency(btcCurrency13, "BTC", "BYR");
                    currencyList.add(currencylist);

                    currencylist = new currency(btcCurrency14, "BTC", "AED");
                    currencyList.add(currencylist);

                    currencylist = new currency(btcCurrency15, "BTC", "AFN");
                    currencyList.add(currencylist);

                    currencylist = new currency(btcCurrency16, "BTC", "TND");
                    currencyList.add(currencylist);

                    currencylist = new currency(btcCurrency17, "BTC", "ARS");
                    currencyList.add(currencylist);

                    currencylist = new currency(btcCurrency18, "BTC", "AUD");
                    currencyList.add(currencylist);

                    currencylist = new currency(btcCurrency19, "BTC", "ZAR");
                    currencyList.add(currencylist);

                    currencylist = new currency(btcCurrency20, "BTC", "BDT");
                    currencyList.add(currencylist);

                    currencylist = new currency(ethCurrency1, "ETH","USD");
                    currencyList.add(currencylist);

                    currencylist = new currency(ethCurrency2, "ETH", "NGN");
                    currencyList.add(currencylist);

                    currencylist = new currency(ethCurrency3, "ETH", "EUR");
                    currencyList.add(currencylist);

                    currencylist = new currency(ethCurrency4, "ETH", "GBP");
                    currencyList.add(currencylist);

                    currencylist = new currency(ethCurrency5, "ETH", "XOF");
                    currencyList.add(currencylist);

                    currencylist = new currency(ethCurrency6, "ETH", "CAD");
                    currencyList.add(currencylist);

                    currencylist = new currency(ethCurrency7, "ETH", "KHR");
                    currencyList.add(currencylist);

                    currencylist = new currency(ethCurrency8, "ETH", "CNY");
                    currencyList.add(currencylist);

                    currencylist = new currency(ethCurrency9, "ETH", "ZAF");
                    currencyList.add(currencylist);

                    currencylist = new currency(ethCurrency10, "ETH", "DZD");
                    currencyList.add(currencylist);

                    currencylist = new currency(ethCurrency11, "ETH", "INR");
                    currencyList.add(currencylist);

                    currencylist = new currency(ethCurrency12, "ETH", "HRK");
                    currencyList.add(currencylist);

                    currencylist = new currency(ethCurrency13, "ETH", "BYR");
                    currencyList.add(currencylist);

                    currencylist = new currency(ethCurrency14, "ETH", "AED");
                    currencyList.add(currencylist);

                    currencylist = new currency(ethCurrency15, "ETH", "AFN");
                    currencyList.add(currencylist);

                    currencylist = new currency(ethCurrency16, "ETH", "TND");
                    currencyList.add(currencylist);

                    currencylist = new currency(ethCurrency17, "ETH", "ARS");
                    currencyList.add(currencylist);

                    currencylist = new currency(ethCurrency18, "ETH", "AUD");
                    currencyList.add(currencylist);

                    currencylist = new currency(ethCurrency19, "ETH", "ZAR");
                    currencyList.add(currencylist);

                    currencylist = new currency(ethCurrency20, "ETH", "BDT");
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
                Toast.makeText(MainActivity.this, "Error " + error.toString(), Toast.LENGTH_LONG).show();
            }
        });

        Volley.newRequestQueue(this).add(stringRequest);
    }


    //Leave this method here.
    public static HashMap<String, String> getValue(Object content) throws IOException, JSONException {
        HashMap<String, String> hashMap = null;

        if (content instanceof JSONObject) {
            JSONObject jsonObject = (JSONObject) content;  //Cast the object to JSONObject just for formality its already in jsonObject
            hashMap = new HashMap<>();

            //Iterate through and get all the currency names in the object e.g USD, NGN etc
            Iterator<String> iterator = jsonObject.keys();
            while (iterator.hasNext()) {
                String key = iterator.next();    //key here is the currency name e.g USD
                Object value = jsonObject.get(key); //value here is the amount e.g 6365.12               key   value
                hashMap.put(key, value.toString());  //put it in d hashmap: HashMap<String, String> === [USD, 6365.12]
            }
        }
        return hashMap;
    }


}
