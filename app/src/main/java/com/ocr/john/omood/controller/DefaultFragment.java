package com.ocr.john.omood.controller;

import android.content.Context;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.ocr.john.omood.R;
import com.ocr.john.omood.model.Emo;
import com.ocr.john.omood.model.Mood;
import com.ocr.john.omood.model.MyAdapter;
import com.ocr.john.omood.model.ViewHolderOnClickListener;
import com.ocr.john.omood.model.exception.InvalidDataException;

import java.text.SimpleDateFormat;
import java.util.Date;

//https://developer.android.com/reference/android/app/Fragment.html
/**
 * The main fragment called first when activity Main created
 * launches the recyclerview
 * @author boy
 * @version 1.0.1
 */
public class DefaultFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Emo emos = new Emo();

    // the 2 buttons at the bottom of the layout
    private ImageView mPlusButton;
    private ImageView mHistoricButton;

    @Deprecated
    private int selectedEmo;

    private Mood mMood;

    SharedPreferences storedMood ;

    public static final String TODAY_MOOD = "MyMoodFile";

    private static final String BUNDLE_MOOD_POS = "mood";
    private static final String BUNDLE_MOOD_DATE = "date";
    private static final String BUNDLE_MOOD_COMMENT = "comment";

    private static final String BUNDLE_DFT_FRG = "DefaultFragment";

    private String todayDate;
    private MediaPlayer catSound;

    /**
     * Constructor Default Fragment
     */
    public DefaultFragment() {
        // Required empty public constructor

        // default Emoticon :
        selectedEmo = 0;

        Log.i(BUNDLE_DFT_FRG,"Calling default Fragment");

        // Today s date
        Date today = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        todayDate = format.format(today);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Use the system to be able to retrieve and saved data
        storedMood = getActivity().getSharedPreferences(TODAY_MOOD, 0);

        Log.i(BUNDLE_DFT_FRG,"Here is the saved emoticon position : " + storedMood.getInt(BUNDLE_MOOD_POS, 0));

        try {
            selectedEmo = storedMood.getInt(BUNDLE_MOOD_POS, 0);
            mMood = new Mood(storedMood.getString(BUNDLE_MOOD_DATE, todayDate),
                    storedMood.getString(BUNDLE_MOOD_COMMENT,""),
                    storedMood.getInt(BUNDLE_MOOD_POS,0));

        } catch(Exception e) {

            Log.i(BUNDLE_DFT_FRG,"invalid stored data" + e.getMessage());
            selectedEmo = 0;
        }

        Log.i(BUNDLE_DFT_FRG,"Retrieving app with selected emo : " + selectedEmo);

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
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        // specify an adapter (see also next example) and instantiate ViewHolderOnClickListener as a parameter
        mAdapter = new MyAdapter(getActivity(), new ViewHolderOnClickListener() {
            @Override
            public void onViewHolderClick(View itemView, short position) {

                // Emo selected for the current day !!
                AlertDialog show = new AlertDialog.Builder(itemView.getContext())
                        .setTitle("Clicked on me! " + emos.emos.get(position))
                        .setMessage("HOOO")
                        .show();
                Log.i(BUNDLE_DFT_FRG,"New Emo selected : " + emos.emos.get(position));

                // Now save a value so we can retrieve the selected element :
                selectedEmo = position;
                try {

                    mMood.setPosition(position);

                } catch (InvalidDataException e) {

                    Log.i(BUNDLE_DFT_FRG,"Check position in array !!");
                }

                // We play a sound just for fun on application launch :
                // TODO refer to Mood :
                //catSound = MediaPlayer.create(this,);
                //catSound.start();

            }
        });

        // Suppress casting object - find another way here !! -- TODO
        // set default position of recyclerView
        mRecyclerView.scrollToPosition(selectedEmo);

        mRecyclerView.setAdapter(mAdapter);



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
    public void onPause() {

        super.onPause();
        savingPref();
        Log.i(BUNDLE_DFT_FRG,"Pausing app with selected emo : " + selectedEmo);
    }
    @Override
    public void onDestroy() {

        super.onDestroy();
        savingPref();
        Log.i(BUNDLE_DFT_FRG,"Destroying app with selected emo : " + selectedEmo);
    }

    /**
     * Saving EMO in file
     * TODO: saving as JSON file OR using sharedpreferences to store today's mood and Room
     * for all historic data
     */
    public void savingPref() {

        // Save Preferences here :
        SharedPreferences.Editor editor = storedMood.edit();

        editor.putInt(BUNDLE_MOOD_POS, mMood.getPosition());
        editor.putString(BUNDLE_MOOD_DATE,mMood.getDate());
        editor.putString(BUNDLE_MOOD_COMMENT,mMood.getComment());

        // Commit the edits!
        editor.apply();



    }
}


