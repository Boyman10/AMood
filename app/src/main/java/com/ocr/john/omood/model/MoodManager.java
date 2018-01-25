package com.ocr.john.omood.model;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

/**
 * Class handling Mood save
 * @author boy
 * @version 1.0.2
 */
public class MoodManager {

    private static final String BUNDLE_MOOD_MANAGER = "MoodManager";
    // Our Room DB
    private AppDatabase appDb;
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
     * @see https://developer.android.com/training/data-storage/index.html
      */

    public void setRoom(Context context) {

        Log.i(BUNDLE_MOOD_MANAGER,"Setting up room");
        appDb = Room.databaseBuilder(context,
                AppDatabase.class, "mood_db").build();
        Log.i(BUNDLE_MOOD_MANAGER,"Database initialized");
    }


    /**
     * Method to add new Mood to Database
     */
    public void addMood(Mood mood) {

        Log.i(BUNDLE_MOOD_MANAGER,"Adding Mood");

        if (appDb != null) {

            Log.i(BUNDLE_MOOD_MANAGER,"Starting thread to add our mood to DB");

            AsyncTask<Void, Void, Integer>() {
                @Override
                protected Integer doInBackground(Void... mood) {
                    return appDb.moodDao().insertAll(mood);
                }

                @Override
                protected void onPostExecute(Integer agentsCount) {
                    if (agentsCount > 0) {

                    }
                    else {


                    }
                }
            }.execute();





            appDb.moodDao().insertAll(mood);
            Log.i(BUNDLE_MOOD_MANAGER,"Mood added to database");
        }

    }

    /**
     * Method to get Mood from Database
     */
    public List<Mood> listMoods() {

        if (appDb != null) {
           return appDb.moodDao().getAll();
        }

        return null;

    }

}
