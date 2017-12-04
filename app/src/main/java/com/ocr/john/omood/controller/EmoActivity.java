package com.ocr.john.omood.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
/**
 *
 * Second activity for mobile use to display the choosen Emo and take action
 * loading another fragment into it :
 */
public class EmoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(getIntent().getStringExtra("emotag"));

        EmoFragment emoFrg = EmoFragment.create(getIntent().getStringExtra("emotag"));

        getSupportFragmentManager().beginTransaction()
                .add(android.R.id.content, emoFrg)
                .commit();
    }
}
