package com.ocr.john.omood.model;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

/**
 * Repository class
 * @see <a href="https://codelabs.developers.google.com/codelabs/android-room-with-a-view/">Codelabs</a>
 */

public class MoodRepository {

    private MoodDao mMoodDao;
    private LiveData<List<Mood>> mAllMoods;

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
