package com.lukegjpotter.androidroomdatabasetutorialbasic.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lukegjpotter.androidroomdatabasetutorialbasic.R;
import com.lukegjpotter.androidroomdatabasetutorialbasic.databinding.ActivityAddBlogPostBinding;

public class AddBlogPostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityAddBlogPostBinding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_add_blog_post);

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
