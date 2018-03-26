package com.ocr.john.omood.model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

/**
 * Mood View Model
 * holds your app's UI data in a lifecycle-conscious way that survives configuration changes.
 * Separating your app's UI data from your Activity and Fragment classes lets you better follow
 * the single responsibility principle
 * Your activities and fragments are responsible for drawing data to the screen,
 * while your ViewModel can take care of holding and processing all the data needed for the UI.
 * @see <a href="https://codelabs.developers.google.com/codelabs/android-room-with-a-view/#8">Code labs</a>
 */

public class MoodViewModel extends AndroidViewModel {


        private MoodRepository mRepository;

        /** @see <a href="https://developer.android.com/topic/libraries/architecture/livedata.html">Live data</a> */
        private LiveData<List<Mood>> mAllMoods;

        public MoodViewModel (Application application) {
            super(application);
            mRepository = new MoodRepository(application);
            mAllMoods = mRepository.getAllMoods();
        }

        public LiveData<List<Mood>> getAllMoods() { return mAllMoods; }

        public void insert(Mood mood) { mRepository.insert(mood); }
}


