package com.preccytech.cryptocon.model;

/**
 * Created by Rx-Precious on 10/10/2017.
 */

public class currency {
    //private String convertFrom;
   // private String convertTo;
    private String currentExchange;


    public  currency(String currentExchange){
       // this.convertFrom = convertFrom;
       // this.convertTo = convertTo;
        this.currentExchange = currentExchange;
    }

   // public String getConvertFrom(){return convertFrom;}

   // public void setConvertFrom(String convertFrom){       this.convertFrom = convertFrom;}

  //  public String getConvertTo(){     return convertTo;}

   // public void setConvertTo(String convertTo){this.convertTo = convertTo; }

    public String getCurrentExchange(){
        return currentExchange;
    }

    public void setCurrentExchange(String currentExchange){
        this.currentExchange = currentExchange;
    }
}
