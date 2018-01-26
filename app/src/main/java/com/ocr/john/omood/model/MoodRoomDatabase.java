package com.ocr.john.omood.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Singleton class to DB restriction : only need one instance of the Room database for the whole app
 * @see <a href="https://codelabs.developers.google.com/codelabs/android-room-with-a-view/">Codelabs</a>
 */
@Database(entities = {Mood.class}, version = 1)
public abstract class MoodRoomDatabase extends RoomDatabase{

    public abstract MoodDao moodDao();

    private static MoodRoomDatabase INSTANCE;

    public static MoodRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MoodRoomDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MoodRoomDatabase.class, "mood_db")
                            .build();                }
            }
        }
        return INSTANCE;
    }

}
