package com.ocr.john.omood.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ocr.john.omood.R;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // start the Default fragment :
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.defaultFrg, new DefaultFragment())
                .commit();
    }

    public void load(String title, String emotag) {

        if(findViewById(R.id.emoFrg) != null) {

            EmoFragment frg = EmoFragment.create(emotag);

            // Add support to older APIs before 11
            // so we can understand fragments instead of getFragmentManager
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.emoFrg, frg)
                    .addToBackStack(null)
                    .commit();

        }
    }

}
