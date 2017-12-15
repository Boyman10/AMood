package com.ocr.john.omood.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bob on 15/12/17.
 */

public class Emo {

    public final Map<Integer,String> hashemos = new HashMap<>();
    public final ArrayList<String> emos = new ArrayList<String>(Arrays.asList("Happy","Normal","Super Happy","Sad","Disappointed"));

    // Initialization of HashMap :
    public Emo () {

        hashemos.put(0,"Happy");
        hashemos.put(1,"Normal");
        hashemos.put(2,"Super Happy");
        hashemos.put(3,"Sad");
        hashemos.put(4,"Disappointed");

    }
}
