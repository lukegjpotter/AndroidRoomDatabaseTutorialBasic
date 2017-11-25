package com.lukegjpotter.androidroomdatabasetutorialbasic.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.lukegjpotter.androidroomdatabasetutorialbasic.dao.BlogPostDao;
import com.lukegjpotter.androidroomdatabasetutorialbasic.entity.BlogPost;

/**
 * Created by lukegjpotter on 25/11/2017.
 */
@Database(entities = {BlogPost.class}, version = 1, exportSchema = false)
public abstract class BlogPostDatabase extends RoomDatabase {

    private static BlogPostDatabase INSTANCE;

    public static BlogPostDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(
                    context.getApplicationContext(),
                    BlogPostDatabase.class,
                    "BlogPostsDatabase")
                    .build();
        }

        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    public abstract BlogPostDao blogPostDao();
}
