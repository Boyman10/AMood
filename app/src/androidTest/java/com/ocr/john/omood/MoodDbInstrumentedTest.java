package com.ocr.john.omood;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.ocr.john.omood.model.Mood;
import com.ocr.john.omood.model.MoodDao;
import com.ocr.john.omood.model.MoodRoomDatabase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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

    // save our class name as bundle for logging
    private static final String BUNDLE_INST_TEST = MoodDbInstrumentedTest.class.getSimpleName();

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

    /**
     * Testing writing and reading unique mood object
     * Room DB
     * @throws Exception
     */
    @Test
    public void writeMoodAndReadIn() throws Exception {

        // Instantiate new Mood object
        Mood mood = new Mood();
        mood.setComment("george comment");

        // save it to DB
        mMoodDao.insert(mood);

        // Get back the object from DB
        Mood byComment = mMoodDao.findByComment("george comment");

        Log.d(BUNDLE_INST_TEST,"Find mood by comment - date : " + byComment.getDateEmo() + " Emo position : " + byComment.getEmoPos());
        // Compare those Object
        assertThat(byComment.getComment(), equalTo(mood.getComment()));

    }

    /**
     * Writing and reading whole list of moods
     * to/from Room DB
     * @throws Exception
     */
    @Test
    public void writeMoodAndReadInList() throws Exception {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now();

        // Instantiate new Mood objects
        ArrayList<Mood> moods = new ArrayList<Mood>();

        Mood mood;

        for(short i = 0;i < 3;i++) {

            //String date, String comment, short position)
            mood = new Mood(dtf.format(localDate),"Comment number " + i,i);
            moods.add(mood);

            // save it to DB
            mMoodDao.insert(mood);

        }

        // Get the list of moods from the DB
        LiveData<List<Mood>> moodsBack = mMoodDao.getAll();

        short i = 0;
        for (Mood aMood: moodsBack.getValue()) {

            assertThat(aMood.getComment(), equalTo(moods.get(i).getComment()));
            i++;
        }

    }

}