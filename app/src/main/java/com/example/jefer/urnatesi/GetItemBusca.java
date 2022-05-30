package com.example.jefer.urnatesi;

import java.util.ArrayList;

/**
 * Created by Jefer on 15/09/2017.
 */

public class GetItemBusca {

    private static GetItemBusca  instance = null;

    private ArrayList<Lista> test;

    private GetItemBusca() {

    }

    public static GetItemBusca GetInstance(){

        if(instance == null){
            instance = new GetItemBusca();
        }
        return instance;
    }

    public ArrayList<Lista> getTest() {
        return test;
    }

    public void setTest(ArrayList<Lista> test) {
        this.test = test;
    }


}
