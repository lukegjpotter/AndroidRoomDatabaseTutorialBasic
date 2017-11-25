package com.lukegjpotter.androidroomdatabasetutorialbasic.database.util;

import android.os.AsyncTask;

import com.lukegjpotter.androidroomdatabasetutorialbasic.database.BlogPostDatabase;
import com.lukegjpotter.androidroomdatabasetutorialbasic.entity.BlogPost;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lukegjpotter on 25/11/2017.
 */

public class DatabaseInitializer {

    public static void populateAsync(final BlogPostDatabase database) {
        new PopulateDbAsync(database).execute();
    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final BlogPostDatabase database;

        PopulateDbAsync(BlogPostDatabase database) {
            this.database = database;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            // If the Database is empty, add the initial data.
            if (database.blogPostDao().rowCount() == 0) {
                List<BlogPost> blogPosts = new ArrayList<>();
                blogPosts.add(new BlogPost("Blog Post #1"));
                blogPosts.add(new BlogPost("Blog Post #2"));
                blogPosts.add(new BlogPost("Blog Post #3"));

                database.blogPostDao().insertBlogPosts(blogPosts.toArray(new BlogPost[blogPosts.size()]));
            }

            return null;
        }
    }
}
