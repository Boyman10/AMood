package com.ocr.john.omood;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.ocr.john.omood.model.Mood;
import com.ocr.john.omood.model.MoodDao;
import com.ocr.john.omood.model.MoodRoomDatabase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * JUnit instrumented test of the Room Database
 * https://developer.android.com/training/data-storage/room/testing-db.html#android
 * @version 1.0.0
 * @author boy
 */
@RunWith(AndroidJUnit4.class)
public class MoodDbInstrumentedTest {

    private MoodDao mMoodDao;
    private MoodRoomDatabase mDb;

    @Before
    public void createDb() {
        Context context = InstrumentationRegistry.getTargetContext();
        mDb = Room.inMemoryDatabaseBuilder(context, MoodRoomDatabase.class).build();
        mMoodDao = mDb.moodDao();
    }

    @After
    public void closeDb() throws IOException {
        mDb.close();
    }

    @Test
    public void writeMoodAndReadInList() throws Exception {
        Mood mood = new Mood();
        mood.setComment("george comment");
        mMoodDao.insert(mood);

        Mood byComment = mMoodDao.findByComment("george comment");

        assertThat(byComment, equalTo(mood));

    }
}