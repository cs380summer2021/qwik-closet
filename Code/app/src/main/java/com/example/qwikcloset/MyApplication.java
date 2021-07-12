package com.example.qwikcloset;

import android.app.Application;

public class MyApplication extends Application {

    private String recyclerState;

    public String getRecyclerState(){
        return recyclerState;
    }

    public void setRecyclerState(String newState){
        recyclerState = newState;
    }
}
