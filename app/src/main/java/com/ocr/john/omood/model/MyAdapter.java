package com.ocr.john.omood.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ocr.john.omood.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by John on 11/27/2017.
 * infos in https://www.supinfo.com/articles/single/563-utiliser-recyclerview-android ?
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<Drawable> mDataset = new ArrayList<Drawable>();
    private List<String> mDatasetStr = new ArrayList<String>();


    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(Context ct) {

        // fetch the getResources from the context sent by Activity
        Resources res = ct.getResources();

        // adding our images to the list :

        mDataset.add(res.getDrawable(R.mipmap.smiley_happy));
        mDatasetStr.add("Happy");
        mDataset.add(res.getDrawable(R.mipmap.smiley_normal));
        mDatasetStr.add("Normal");
        mDataset.add(res.getDrawable(R.mipmap.smiley_super_happy));
        mDatasetStr.add("Super");
        mDataset.add(res.getDrawable(R.mipmap.smiley_sad));
        mDatasetStr.add("Sad");
        mDataset.add(res.getDrawable(R.mipmap.smiley_disappointed));
        mDatasetStr.add("Disappointed");

    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_cell, parent, false);
        return new MyViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mImageView.setTag(mDatasetStr.get(position));
        holder.mImageView.setImageDrawable(mDataset.get(position));

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }



}