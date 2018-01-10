package com.ocr.john.omood.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ocr.john.omood.R;

/**
 * MainActivity class is the 1st screen of the application which uses fragments to display its content
 * It uses a layout manager defined in a file and launch the default fragment
 * @author : boy
 * @version : 1.0.1
 */
public class MainActivity extends AppCompatActivity {

    private final String BUNDLE_DOC = "Documentation";
    private final String BUNDLE_MAIN_ACT = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // start the Default fragment :
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.defaultFrg, new DefaultFragment())
                .commit();

        // Launch documentation throught fragment
        load(BUNDLE_DOC);
    }

    /**
     * Method to load second fragment : EmoFragment ...
     * @author boy
     * @param title : title of Fragment
     */
    public void load(String title) {

        if(findViewById(R.id.emoFrg) != null) {

            EmoFragment frg = EmoFragment.create(title);

            // Add support to older APIs before 11
            // so we can understand fragments instead of getFragmentManager
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.emoFrg, frg)
                    .addToBackStack(null)
                    .commit();

        } else if (!title.equals(BUNDLE_DOC)) {

            Log.i(BUNDLE_MAIN_ACT,"Calling second activity with historic fragment");
            // Now use activity to display the webview if not documentation
            Intent intent = new Intent(this,HistoricActivity.class);
            intent.putExtra("title",title);
            startActivity(intent);
        }
    }

}
