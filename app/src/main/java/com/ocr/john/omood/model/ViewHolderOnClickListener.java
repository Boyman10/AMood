package com.ocr.john.omood.model;

import android.view.View;

/**
 * Created by John on 12/4/2017.
 * https://piercezaifman.com/click-listener-for-recyclerview-adapter/
 */

public interface ViewHolderOnClickListener {

    //This method can be any parameters
    void onViewHolderClick(View itemView, int position);
}
