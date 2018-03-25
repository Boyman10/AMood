package com.ocr.john.omood.model;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

/**
 * Repository class
 * A Repository is a class that abstracts access to multiple data sources.
 * The Repository is not part of the Architecture Components libraries,
 * but is a suggested best practice for code separation and architecture.
 * A Repository class handles data operations. It provides a clean API to the rest of the app for app data.
 * @see <a href="https://codelabs.developers.google.com/codelabs/android-room-with-a-view/">Codelabs</a>
 */

public class MoodRepository {

    private MoodDao mMoodDao;
    private LiveData<List<Mood>> mAllMoods;

    /**
     * Add a constructor that gets a handle to the database and initializes the member variables.
     * @param application
     */
    MoodRepository(Application application) {
        MoodRoomDatabase db = MoodRoomDatabase.getDatabase(application);
        mMoodDao = db.moodDao();
        mAllMoods = mMoodDao.getAll();
    }


    LiveData<List<Mood>> getAllMoods() {
        return mAllMoods;
    }


    public void insert(Mood mood) {
        new insertAsyncTask(mMoodDao).execute(mood);
    }

    private static class insertAsyncTask extends AsyncTask<Mood, Void, Void> {

        private MoodDao mAsyncTaskDao;

        insertAsyncTask(MoodDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Mood... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
