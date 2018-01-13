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
 * @version 1.0.2
 * infos in https://www.supinfo.com/articles/single/563-utiliser-recyclerview-android ?
 */
public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private ViewHolderOnClickListener vListener;

    private final String BUNDLE_ADAPTER = "MyAdpater";
    private Mood mMood;

    private Resources res;

    /**
     * Constructor class initialize dataset and listener
     * @param ct
     * @param listener
     */
    public MyAdapter(Context ct, ViewHolderOnClickListener listener) {

        // beware here if mood already created !
        mMood = new Mood();

        vListener = listener;
        // fetch the getResources from the context sent by Activity
        res = ct.getResources();

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

        //Drawable dr = mDatasetMap.get(position);
        Drawable dr = res.getDrawable(mMood.drawableLinks[position]);

        if(dr != null) {
            holder.mImageView.setImageDrawable(dr);

        } else {

            Log.i("Info","Error Drawable - position : " + position);
        }

        // Switch color depending on emoticon : -TODO
        holder.mCardView.setBackgroundColor(mMood.bgColors[position]);


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
        return mMood.drawableLinks.length;
    }

}