package com.ocr.john.omood.model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ocr.john.omood.R;

import java.util.List;

/**
 * Adapter class to handle the data accross the recyclerview belonging to the historic activity and its fragment
 * @author boy
 * @version 1.0.1
 * @see <a href="https://codelabs.developers.google.com/codelabs/android-room-with-a-view/#10">Code labs</a>
 */
public class HistoricAdapter extends RecyclerView.Adapter<HistoricAdapter.HistoricViewHolder> {

    private final TextView historicItemView;

    class HistoricViewHolder(View itemView) {

        super(itemView);
        historicItemView = itemView.findViewById(R.id.textView)

    }

    private final LayoutInflater mInflater;
    private List<Mood> mMoods; // Cached copy of Moods

    HistoricAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public HistoricViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new HistoricViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HistoricViewHolder holder, int position) {
        if (mMoods != null) {
            Mood current = mMoods.get(position);
            holder.historicItemView.setText(current.getMood());
        } else {
            // Covers the case of data not being ready yet.
            holder.historicItemView.setText("No Word");
        }
    }

    void setMoods(List<Mood> moods){
        mMoods = moods;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mMoods has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mMoods != null)
            return mMoods.size();
        else return 0;
    }

}
