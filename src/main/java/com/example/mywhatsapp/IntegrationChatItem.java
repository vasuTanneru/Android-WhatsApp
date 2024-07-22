package com.example.mywhatsapp;

import android.app.Application;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
public class IntegrationChatItem extends Application {
    public static IntegrationChatItem instance;
    public RequestQueue requestQueue;

    @Override
    public void onCreate( ) {
        super.onCreate();
        instance = this;
        requestQueue = Volley.newRequestQueue(getApplicationContext());
    }

    public static synchronized IntegrationChatItem getInstance() {
        return instance;
    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }
}


