package com.ocr.john.omood.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * DAO Class to retrieve the Mood object
 * using the ROOM library
 * @author boy
 * @version 1.0.0
 */
@Dao
public interface MoodDao {

    @Query("SELECT * FROM mood")
    List<Mood> getAll();

    @Query("SELECT * FROM mood WHERE date_emo IN (:dates)")
    List<Mood> loadAllByDates(String[] dates);

    @Query("SELECT * FROM mood WHERE comment LIKE :comment LIMIT 1")
    Mood findByComment(String comment);

    @Insert
    void insertAll(Mood... moods);

    @Delete
    void delete(Mood mood);

}
