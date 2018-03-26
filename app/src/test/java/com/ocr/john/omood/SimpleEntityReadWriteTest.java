package com.ocr.john.omood;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.ocr.john.omood.model.Mood;
import com.ocr.john.omood.model.MoodDao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

/**
 * JUnit test of the Room Database
 * https://developer.android.com/training/data-storage/room/testing-db.html#android
 * @version 1.0.0
 * @author boy
 */
@RunWith(AndroidJUnit4.class)
public class SimpleEntityReadWriteTest {
    private MoodDao mMoodDao;
    private TestDatabase mDb;

    @Before
    public void createDb() {
        Context context = InstrumentationRegistry.getTargetContext();
        mDb = Room.inMemoryDatabaseBuilder(context, TestDatabase.class).build();
        mMoodDao = mDb.getMoodDao();
    }

    @After
    public void closeDb() throws IOException {
        mDb.close();
    }

    @Test
    public void writeUserAndReadInList() throws Exception {
        Mood mood = TestUtil.createUser(3);
        mood.setName("george");
        mMoodDao.insert(mood);
        List<Mood> byName = mMoodDao.findMoodByName("george");
        assertThat(byName.get(0), equalTo(mood));
    }
}