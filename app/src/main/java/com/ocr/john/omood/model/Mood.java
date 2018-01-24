package com.ocr.john.omood.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.graphics.Color;
import android.support.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.ocr.john.omood.R;
import com.ocr.john.omood.model.exception.InvalidDataException;

/**
 * Class intend to hold mood object
 * @author john
 * @version 1.0.0
 * @param
 */
@Entity(primaryKeys = {"date_emo"})
public class Mood {

    // Constants :
    @Ignore
    public final static String[] emo = {"Happy","Normal","Super Happy","Sad","Disappointed"};
    @Ignore
    public final static int[] drawableLinks = {R.mipmap.smiley_happy,R.mipmap.smiley_normal,R.mipmap.smiley_super_happy,R.mipmap.smiley_sad,
            R.mipmap.smiley_disappointed};
    @Ignore
    public final static int[] bgColors = {Color.CYAN,Color.WHITE,Color.YELLOW,Color.GREEN,Color.MAGENTA};

    //https://www.freesoundeffects.com/
    @Ignore
    public final static int[] sounds = {R.raw.sad_cat,R.raw.long_dog,R.raw.attack,R.raw.boo,R.raw.scream};

    @NonNull
    @ColumnInfo(name = "date_emo")
    private String dateEmo;

    @ColumnInfo(name = "comment")
    private String comment;

    @ColumnInfo(name = "emo_position")
    private short emoPos;

    public Mood() {

        // Today s date
        Date today = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        dateEmo = format.format(today);
        emoPos = 0;
    }

    /**
     * Overriding constructor class
     */
    public Mood(String date, String comment, short position)
            //throws InvalidDataException
     {

        // Check date format
        dateEmo = date;

        /* Check position
        if (position > emo.length)
            throw new InvalidDataException();
        else*/
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
     * Retrieve comment of emo in array for the current object
     * @return emo comment
     */
    public String getComment() {

        return comment;
    }

    /**
     * Retrieve position of emo in array for the current object
     * @return emo position
     */
    public short getEmoPos() {

        return emoPos;
    }
    /**
     * Set position of emo
     * @param position
     */
    public void setEmoPos(short position)
            //throws InvalidDataException
    {

        /* Check position
        if (position > emo.length)
            throw new InvalidDataException();
        else*/
            emoPos = position;
    }
    /**
     * Retrieve date of emo
     * @return emo date
     */
    public String getDateEmo() {

        return dateEmo;
    }

    public void setDateEmo(String dateEmo) {
        dateEmo = dateEmo;
    }

}
