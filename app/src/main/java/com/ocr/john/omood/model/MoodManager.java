package com.ocr.john.omood.model;

import android.arch.persistence.room.Room;
import android.content.Context;

import java.util.List;

/**
 * Class handling Mood save
 * @author boy
 * @version 1.0.2
 */
public class MoodManager {

    // Our Room DB
    private AppDatabase appDb;
    /**
     * Class Constructor passing ...
     */
    public MoodManager() {

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

        appDb = Room.databaseBuilder(context,
                AppDatabase.class, "mood_db").build();
    }


    /**
     * Method to add new Mood to Database
     */
    public void addMood(Mood mood) {

        if (appDb != null) {
            appDb.moodDao().insertAll(mood);
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
