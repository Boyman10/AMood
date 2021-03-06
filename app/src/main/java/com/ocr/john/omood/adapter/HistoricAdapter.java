package com.ocr.john.omood.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ocr.john.omood.R;
import com.ocr.john.omood.model.Mood;
import com.ocr.john.omood.model.ViewHolderOnClickListener;

import java.util.List;

/**
 * Adapter class to handle the data accross the recyclerview belonging to the historic activity and its fragment
 * @author boy
 * @version 1.0.1
 * @see <a href="https://codelabs.developers.google.com/codelabs/android-room-with-a-view/#10">Code labs</a>
 */
public class  HistoricAdapter extends RecyclerView.Adapter<HistoricAdapter.HistoricViewHolder> {


    // hold instance of interface here :
    private ViewHolderOnClickListener vhListener;
    private final static String BUNDLE_FR_INFO = "historic-adapter";

// WE hold the cached moods
    private List<Mood> mMoods; // Cached copy of moods
    private final LayoutInflater mInflater;



    class HistoricViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private CardView historicItemView;
        private TextView mTextView;
        private ImageView mImageView;


        public HistoricViewHolder(View itemView) {
            super(itemView);
            Log.i(BUNDLE_FR_INFO,"Calling HistoricViewHolder - card view + set on click" );

            historicItemView = itemView.findViewById(R.id.card_view);
            historicItemView.setOnClickListener(this);
            mImageView = (ImageView) itemView.findViewById(R.id.imageView);
            mTextView = (TextView) itemView.findViewById(R.id.txtView);
            Log.i(BUNDLE_FR_INFO,"Calling HistoricViewHolder end of method" );
        }


        @Override
        public void onClick(View view){

            Log.i(BUNDLE_FR_INFO,"Apply click on item : " + getAdapterPosition() );

            vhListener.onViewHolderClick(view,(short)getAdapterPosition());
        }
    }


    public HistoricAdapter(Context context, ViewHolderOnClickListener listener) {

        mInflater = LayoutInflater.from(context);
        vhListener = listener;

        Log.i(BUNDLE_FR_INFO, "Get the historic adapter");

    }

    @Override
    public HistoricViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.historic_view_item, parent, false);

        Log.i(BUNDLE_FR_INFO, "onCreateViewHolder get an histtoric view item");


        return new HistoricViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HistoricViewHolder holder, int position) {

        Log.i(BUNDLE_FR_INFO, "onBindViewHolder...");
        if (mMoods != null) {
            Mood current = mMoods.get(position);

            // Create textView under Cardview
            holder.mTextView.setText(current.getComment());

        } else {
            // Covers the case of data not being ready yet.
            holder.mTextView.setText("No mood defined");
        }

    }
    public void setMoods(List<Mood> moods){

        Log.i(BUNDLE_FR_INFO, "Setting up moods inside Adapter");
        mMoods = moods;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mMoods has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        Log.i(BUNDLE_FR_INFO, "Get Item count");
        if(mMoods != null)
        return mMoods.size();
        else return 0;
    }

}
