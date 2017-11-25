package com.lukegjpotter.androidroomdatabasetutorialbasic.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by lukegjpotter on 25/11/2017.
 */
@Entity
public class BlogPost {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "title")
    private String title;

    /**
     * Default Constructor
     * <p>
     * Room Database will use this no-arg constructor by default.
     * The others are annotated with @Ignore, so Room will not give a warning about
     * "Multiple Good Constructors".
     */
    public BlogPost() {
    }

    @Ignore
    public BlogPost(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
