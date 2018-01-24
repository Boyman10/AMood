package com.ocr.john.omood.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Mood.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MoodDao moodDao();
}