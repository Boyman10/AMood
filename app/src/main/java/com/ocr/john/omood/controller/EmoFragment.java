package com.ocr.john.omood.controller;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.ocr.john.omood.R;
import com.ocr.john.omood.model.HistoricAdapter;

/**
 * EmoFragment class to display the description of the application on app launch
 * And the historic of the selected emos in a recyclerView once clicked on Historic button
 * @author boy
 * @version 1.0.1
 */
public class EmoFragment extends Fragment {

    private final String BUNDLE_EMO_FRG = "EmoFragment";

    public EmoFragment() {
        // Required empty public constructor
    }

    /**
     * static factory method to pass arguments on create instance
     * @param title
     * @return {@link EmoFragment}
     */
    public static EmoFragment create(String title) {
        Bundle args = new Bundle();
        args.putString("emotag", title);
        // singleton :
        EmoFragment emofrg = new EmoFragment();
        emofrg.setArguments(args);
        return emofrg;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_emo, container, false);
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {

        super.onViewCreated(view,savedInstanceState);

        Log.i(BUNDLE_EMO_FRG,"Calling onViewCreated - WEB View ");
        WebView webView = (WebView) view.findViewById(R.id.webView);

        webView.getSettings().setJavaScriptEnabled(true);

        // OR, you can also load from an HTML string:
        String summary = "<html><body><h1>Track your mood !</h1>" +
                "         Click on an emoticon to indicate your daily mood." +
                "         <p>You will be able to access your historic at any time.</p></body></html>";
        webView.loadData(summary, "text/html", null);

        Log.i(BUNDLE_EMO_FRG,"End of onViewCreated - WEB View ");


        /**
         * Alternative content once clicked on Historic Button

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final HistoricAdapter adapter = new HistoricAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
         */
    }

}
