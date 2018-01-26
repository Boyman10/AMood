package com.ocr.john.omood.model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

/**
 * Class handling Mood save
 * https://codelabs.developers.google.com/codelabs/android-room-with-a-view/#2
 * @author boy
 * @version 1.0.2
 */
public class MoodManager {

    private static final String BUNDLE_MOOD_MANAGER = "MoodManager";

    private MoodViewModel mMoodViewModel;
    /**
     * Class Constructor passing ...
     */
    public MoodManager() {

        Log.i(BUNDLE_MOOD_MANAGER,"Starting MoodManager constructor");
    }

    /**
     * TODO implementing DAO pattern & Factory ... to save the Object independently of the method for saving data...
     * <ul>
     *  <li>Key Value sets - SharedPreferences</li>
     *  <li>Files</li>
     *  <li>Room Persistence library</li>
     *  <li>SQLite</li>
     * </ul>
     * @see <a href="https://developer.android.com/training/data-storage/index.html">Dev Android</a>
      */

    public void setRoom(Context context) {

    }


    /**
     * Method to add new Mood to Database
     */
    public void addMood(Mood mood) {

        Log.i(BUNDLE_MOOD_MANAGER,"Adding Mood");

        if (mMoodViewModel != null) {

            Log.i(BUNDLE_MOOD_MANAGER,"Starting thread to add our mood to DB");

            mMoodViewModel.insert(mood);

            Log.i(BUNDLE_MOOD_MANAGER,"Mood added to database");
        }

    }

    /**
     * Method to get Mood from Database
     */
    public LiveData<List<Mood>> listMoods() {

        if (mMoodViewModel != null) {
           return mMoodViewModel.getAllMoods();
        }

        return null;

    }

}
