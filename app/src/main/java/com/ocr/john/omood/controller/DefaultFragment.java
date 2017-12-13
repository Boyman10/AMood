package com.ocr.john.omood.controller;

import android.content.Context;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.ocr.john.omood.R;
import com.ocr.john.omood.model.MyAdapter;
import com.ocr.john.omood.model.ViewHolderOnClickListener;

import static android.content.Context.MODE_PRIVATE;


/**
 * The main fragment called first when activity Main created
 * launches the recyclerview
 */
public class DefaultFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    // the 2 buttons at the bottom of the layout
    private ImageView mPlusButton;
    private ImageView mHistoricButton;

    private String selectedEmo;

    SharedPreferences storedMood ;

    public static final String TODAY_MOOD = "MyMoodFile";
    private static final String BUNDLE_MOOD = "mood";

    public DefaultFragment() {
        // Required empty public constructor
        selectedEmo = "Happy";


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Use the system to be able to retrieve and save data
        storedMood = getActivity().getSharedPreferences(TODAY_MOOD, 0);

        selectedEmo = storedMood.getString(BUNDLE_MOOD, null);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_default, container, false);
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {

        super.onViewCreated(view,savedInstanceState);


        mRecyclerView = view.findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(getActivity(), new ViewHolderOnClickListener() {
            @Override
            public void onViewHolderClick(View itemView, String tag) {
                AlertDialog show = new AlertDialog.Builder(itemView.getContext())
                        .setTitle("Clicked on me!" + tag)
                        .setMessage("HOOO")
                        .show();
                Log.i("Info","Before calling fragment...");

                // Now save a value so we can retrieve the selected element :
                selectedEmo = tag;


            }
        });
        mRecyclerView.setAdapter(mAdapter);

        // Add current EMO id to recyclerview --TODO







        // Apply action to other buttons :
        mPlusButton = view.findViewById(R.id.plus_button);
        mPlusButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Context context = getActivity().getApplicationContext();

                CharSequence text = "Hello toast ! Clicked on Plus above " + selectedEmo;
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

            }
        });
    }


    @Override
    public void onDestroy() {

        super.onDestroy();

        // Save Preferences here :
        SharedPreferences.Editor editor = storedMood.edit();
        editor.putString(BUNDLE_MOOD, selectedEmo);

        // Commit the edits!
        editor.apply();

    }

}


