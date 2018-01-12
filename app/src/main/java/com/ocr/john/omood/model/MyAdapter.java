package com.ocr.john.omood.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ocr.john.omood.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.ocr.john.omood.model.Emo.*;

/**
 * Class Adapter to deal with data
 * @author john
 * @version 1.0.1
 * infos in https://www.supinfo.com/articles/single/563-utiliser-recyclerview-android ?
 */
public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Map<Integer,Drawable> mDatasetMap = new LinkedHashMap<>();

    private ViewHolderOnClickListener vListener;

    private final String BUNDLE_ADAPTER = "MyAdpater";

    /**
     * Constructor class initialize dataset and listener
     * @param ct
     * @param listener
     */
    public MyAdapter(Context ct, ViewHolderOnClickListener listener) {

        vListener = listener;
        // fetch the getResources from the context sent by Activity
        Resources res = ct.getResources();

        // adding our images to the list :
        /**
         * TODO : implement Mood Object iteration here :
         */
        mDatasetMap.put(0,res.getDrawable(R.mipmap.smiley_happy));
        mDatasetMap.put(1,res.getDrawable(R.mipmap.smiley_normal));
        mDatasetMap.put(2,res.getDrawable(R.mipmap.smiley_super_happy));
        mDatasetMap.put(3,res.getDrawable(R.mipmap.smiley_sad));
        mDatasetMap.put(4,res.getDrawable(R.mipmap.smiley_disappointed));

    }

    /**
     * Create new views (invoked by the layout manager)
     * @param parent
     * @param position
     */
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int position) {

        Log.i(BUNDLE_ADAPTER,"Calling onCreateViewHolder - nouvelle vue créée : " );
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_cell, parent, false);
        return new MyViewHolder(view,vListener);
    }

    // Replace the contents of a view (invoked by the layout manager) - function being called by RecyclerView
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Log.i(BUNDLE_ADAPTER,"Calling onBindViewHolder - position : " + position);


        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        Drawable dr = mDatasetMap.get(position);

        if(dr != null) {
            holder.mImageView.setImageDrawable(dr);

        } else {

            Log.i("Info","Error Drawable - position : " + position);
        }

        // Switch color depending on emoticon : -TODO
       // holder.mCardView.setBackgroundColor(Color.CYAN);


        // center the emoticon relative to the parent area :
        // or change layout from within list_cell.xml resource file :
       /* LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        lp.gravity = Gravity.CENTER;
        lp.setMargins(0,0,0,0);


        holder.mImageView.setLayoutParams(lp);
        */

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDatasetMap.size();
    }

}