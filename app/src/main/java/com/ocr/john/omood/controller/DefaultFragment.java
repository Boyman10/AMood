package com.ocr.john.omood.controller;

import android.content.Context;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ocr.john.omood.R;
import com.ocr.john.omood.model.MyAdapter;
import com.ocr.john.omood.model.MyViewHolder;
import com.ocr.john.omood.model.ViewHolderOnClickListener;


/**
 * The main fragment called first when activity Main created
 * launches the recyclerview
 */
public class DefaultFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    public DefaultFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_default, container, false);
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {

        super.onViewCreated(view,savedInstanceState);


        mRecyclerView = view.findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(getActivity(), new ViewHolderOnClickListener() {
            @Override
            public void onViewHolderClick(View itemView, String tag) {
                AlertDialog show = new AlertDialog.Builder(itemView.getContext())
                        .setTitle("Clicked on me!" + tag)
                        .setMessage("HOOO")
                        .show();
                Log.i("Info","Before calling fragment...");
            }
        });
        mRecyclerView.setAdapter(mAdapter);

    }

}
