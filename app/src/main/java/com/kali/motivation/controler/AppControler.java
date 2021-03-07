package com.kali.motivation.controler;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


public class AppControler extends Application {
    public static final String TAG=AppControler.class.getSimpleName();
    private static AppControler mInstant;
    private RequestQueue mRequestQueue;


    public static synchronized AppControler getInstance(){
        return mInstant;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstant=this;
    }

    public RequestQueue getmRequestQueue(){
        if (mRequestQueue==null){
            mRequestQueue= Volley.newRequestQueue(getApplicationContext());
        }
        return mRequestQueue;
    }
    public <T> void addToRequestQueue(Request<T> req,String tag){
        req.setTag(TextUtils.isEmpty(tag)?TAG:tag);
        getmRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req){
        req.setTag(TAG);
        getmRequestQueue().add(req);
    }
    public void cancelPendingRequests(Object tag){
        if (mRequestQueue!=null){
            mRequestQueue.cancelAll(tag);
        }
    }

}
