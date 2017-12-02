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

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Drawable> mDataset = new ArrayList<Drawable>();

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just an image in this case
        public ImageView mImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.imageView);

            mImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog show = new AlertDialog.Builder(mImageView.getContext())
                            .setTitle("Clicked on me!" + mImageView.getContext().toString())
                            .setMessage("HOOO")
                            .show();
                }
            });
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(Context ct) {

        // fetch the getResources from the context sent by Activity
        Resources res = ct.getResources();

        // adding our images to the list :
        mDataset.add(res.getDrawable(R.mipmap.smiley_happy));
        mDataset.add(res.getDrawable(R.mipmap.smiley_normal));
        mDataset.add(res.getDrawable(R.mipmap.smiley_super_happy));
        mDataset.add(res.getDrawable(R.mipmap.smiley_sad));
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_cell, parent, false);
        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mImageView.setImageDrawable(mDataset.get(position));

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }



}