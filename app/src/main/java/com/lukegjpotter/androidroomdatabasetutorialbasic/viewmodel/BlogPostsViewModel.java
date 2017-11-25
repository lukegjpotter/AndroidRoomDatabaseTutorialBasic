package com.lukegjpotter.androidroomdatabasetutorialbasic.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.lukegjpotter.androidroomdatabasetutorialbasic.database.BlogPostDatabase;
import com.lukegjpotter.androidroomdatabasetutorialbasic.entity.BlogPost;

import java.util.List;


/**
 * Created by lukegjpotter on 25/11/2017.
 */

public class BlogPostsViewModel extends AndroidViewModel {

    private final LiveData<List<BlogPost>> blogPosts;

    public BlogPostsViewModel(@NonNull Application application) {
        super(application);

        blogPosts = BlogPostDatabase.getInstance(getApplication()).blogPostDao().getAllBlogPosts();
    }

    public LiveData<List<BlogPost>> getBlogPosts() {
        return blogPosts;
    }
}
