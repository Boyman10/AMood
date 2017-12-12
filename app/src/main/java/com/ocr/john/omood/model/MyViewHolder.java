package com.ocr.john.omood.model;


import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.ocr.john.omood.R;


/**
 * Created by hackme on 03/12/2017.
 */

// Provide a reference to the views for each data item
// Complex data items may need more than one view per item, and
// you provide access to all the views for a data item in a view holder
public  class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    // each data item is just an image in this case
    public static ImageView mImageView;
    public static CardView mCardView;

    // holde instance of interface here :
    private ViewHolderOnClickListener vhListener;

    public MyViewHolder(View itemView, ViewHolderOnClickListener listener) {
        super(itemView);

        vhListener = listener;
        mImageView = (ImageView) itemView.findViewById(R.id.imageView);
        mCardView = (CardView) itemView.findViewById(R.id.card_view);
        mImageView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view){
        vhListener.onViewHolderClick(view,mImageView.getTag().toString());
    }

}