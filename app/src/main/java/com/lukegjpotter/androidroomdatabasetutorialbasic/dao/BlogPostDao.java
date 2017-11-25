package com.lukegjpotter.androidroomdatabasetutorialbasic.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.lukegjpotter.androidroomdatabasetutorialbasic.entity.BlogPost;

import java.util.List;

/**
 * Created by lukegjpotter on 25/11/2017.
 */
@Dao
public interface BlogPostDao {

    @Query("SELECT * FROM blogpost")
    LiveData<List<BlogPost>> getAllBlogPosts();

    @Query("SELECT * FROM blogpost WHERE id = :id LIMIT 1")
    LiveData<List<BlogPost>> findBlogPostById(long id);

    @Query("SELECT * FROM blogpost WHERE title LIKE :title LIMIT 1")
    LiveData<List<BlogPost>> findBlodPostByTitle(String title);

    @Query("SELECT COUNT(*) FROM blogpost")
    int rowCount();

    @Insert
    void insertBlogPosts(BlogPost... blogPosts);

    @Update
    void updateBlogPosts(BlogPost... blogPosts);

    @Delete
    void deleteBlogPosts(BlogPost... blogPosts);
}
