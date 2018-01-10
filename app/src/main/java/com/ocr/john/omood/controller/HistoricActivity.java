package com.ocr.john.omood.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ocr.john.omood.R;

/**
 * HistoricActivity class to load fragment
 * by default display the documentation and on click launches
 * the historic of the emoticons
 * @author boy
 * @version 1.0.0
 */
public class HistoricActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_historic);

        EmoFragment frg = EmoFragment.create("Historic...");

        // start the historic fragment :
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.emoFrg, frg)
                .commit();

    }
}
