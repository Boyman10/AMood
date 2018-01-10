package com.ocr.john.omood.model;

import android.graphics.Color;

import java.text.SimpleDateFormat;

/**
 * Class intend to hold mood object
 * @author john
 * @version 1.0.0
 * @param
 */
public class Mood {

    // Constants :
    public final static String[] emo = {"Happy","Normal","Super Happy","Sad","Disappointed"};
    public final static String[] drawableLinks = {"smiley_happy","smiley_normal","smiley_super_happy","smiley_sad","smiley_disappointed"};
    public final static int[] bgColors = {Color.CYAN,Color.WHITE,Color.YELLOW,Color.GREEN,Color.MAGENTA};


    private String dateEmo;
    private String comment;
    private short emoPos;

    public Mood() {

        // Today s date
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        dateEmo = format.toString();
        emoPos = 0;
    }

    /**
     * Overriding constructor class
     */
    public Mood(String date, String comment, short position) {

        dateEmo = date;
        emoPos = position;
        this.comment = comment;
    }

    /**
     * Method to set a comment related to the object at a specific date
     * @param comment
     */
    public void setComment(String comment) {

        this.comment = comment;
    }

    /**
     * Retrieve position of emo in array for the current object
     * @return emo position
     */
    public short getPosition() {

        return emoPos;
    }


}
