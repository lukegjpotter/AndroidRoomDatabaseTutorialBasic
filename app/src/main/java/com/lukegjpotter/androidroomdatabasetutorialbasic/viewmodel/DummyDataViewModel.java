package com.lukegjpotter.androidroomdatabasetutorialbasic.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lukegjpotter on 24/11/2017.
 */
public class DummyDataViewModel extends AndroidViewModel {

    private MutableLiveData<List<String>> blogPosts;

    public DummyDataViewModel(@NonNull Application application) {
        super(application);

        blogPosts = new MutableLiveData<>();
        populateBlogPosts();
    }

    public LiveData<List<String>> getBlogPosts() {

        return blogPosts;
    }

    private void populateBlogPosts() {
        List<String> strings = new ArrayList<>();
        strings.add("Post Title #1");
        strings.add("Post Title #2");
        strings.add("Post Title #3");

        blogPosts.postValue(strings);
    }
}
