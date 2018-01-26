package com.ocr.john.omood.model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * DAO Class to retrieve the Mood object
 * using the ROOM library
 * @see <a href="https://codelabs.developers.google.com/codelabs/android-room-with-a-view/#4">Codelabs</a>
 * @author boy
 * @version 1.0.0
 */
@Dao
public interface MoodDao {

    //LiveData applies this rule by automatically running the query asynchronously on a background thread, when needed.
    @Query("SELECT * FROM mood")
    LiveData<List<Mood>> getAll();

    @Query("SELECT * FROM mood WHERE date_emo IN (:dates)")
    LiveData<List<Mood>> loadAllByDates(String[] dates);

    @Query("SELECT * FROM mood WHERE comment LIKE :comment LIMIT 1")
    Mood findByComment(String comment);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Mood... moods);

    @Delete
    void delete(Mood mood);

}
