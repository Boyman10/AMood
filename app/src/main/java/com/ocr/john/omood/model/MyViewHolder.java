package com.ocr.john.omood.model;


import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.ocr.john.omood.R;


/**
 * Provide a reference to the views for each data item
 * Complex data items may need more than one view per item, and
 * you provide access to all the views for a data item in a view holder
 * @author boy
 * @version 1.0.1
 */
public  class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    // each data item is just an image in this case
    public static ImageView mImageView;
    public static CardView mCardView;

    private final String BUNDLE_VH_INFO = "MyViewHolder";

    // hold instance of interface here :
    private ViewHolderOnClickListener vhListener;

    /**
     * Constructor class initializing listener, card view below image view
     * Applying listener on Image View
     * @param itemView
     * @param listener
     */
    public MyViewHolder(View itemView, ViewHolderOnClickListener listener) {
        super(itemView);

        vhListener = listener;
        mImageView = (ImageView) itemView.findViewById(R.id.imageView);
        mCardView = (CardView) itemView.findViewById(R.id.card_view);

        mImageView.setOnClickListener(this);

        Log.i(BUNDLE_VH_INFO,"Calling MyViewHolder with Image and card " );

    }

    @Override
    public void onClick(View view){

        Log.i(BUNDLE_VH_INFO,"Apply click on image with tag and current position : " + getAdapterPosition() );

        vhListener.onViewHolderClick(view,(short)getAdapterPosition());
    }

}