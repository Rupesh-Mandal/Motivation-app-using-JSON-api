package com.kali.motivation.data;


import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.kali.motivation.controler.AppControler;
import com.kali.motivation.inteface.QuoteListAsyncResponse;
import com.kali.motivation.modle.Quoet;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class QuoteData {
    ArrayList<Quoet> quoetArrayList = new ArrayList<>();

    public void getQuote(QuoteListAsyncResponse callback) {
        String url = "https://raw.githubusercontent.com/pdichone/UIUX-Android-Course/master/Quotes.json%20";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i=0; i<response.length();i++){
                            try {
                                JSONObject quoteObject=response.getJSONObject(i);
                                Quoet quoet=new Quoet();
                                quoet.setQuote(quoteObject.getString("quote"));
                                quoet.setAuthor(quoteObject.getString("name"));
                                quoetArrayList.add(quoet);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        if (null!=callback){
                            callback.processFinished(quoetArrayList);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        AppControler.getInstance().addToRequestQueue(jsonArrayRequest);
    }

}
