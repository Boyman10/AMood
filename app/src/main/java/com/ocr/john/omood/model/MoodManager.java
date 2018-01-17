package com.ocr.john.omood.model;

/**
 * Class handling Mood save
 * @author boy
 * @version 1.0.1
 */
public class MoodManager {

    private Mood mood;

    /**
     * Class Constructor passing mood as parameter
     * @param mood
     */
    public MoodManager(Mood mood) {

        this.mood = mood;
    }

// TODO implementing DAO pattern & Factory ... to save the Object independantly of the method for saving data...

}
