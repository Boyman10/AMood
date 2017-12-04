package com.ocr.john.omood.model;

import android.support.v7.app.AlertDialog;
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
public  class MyViewHolder extends RecyclerView.ViewHolder {
    // each data item is just an image in this case
    public static ImageView mImageView;

    public MyViewHolder(View itemView) {
        super(itemView);
        mImageView = (ImageView) itemView.findViewById(R.id.imageView);

        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO add intent or launch fragment here with name of tag for the imageview
                AlertDialog show = new AlertDialog.Builder(mImageView.getContext())
                        .setTitle("Clicked on me!" + mImageView.getTag())
                        .setMessage("HOOO")
                        .show();

            }
        });
    }
}