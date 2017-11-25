package com.lukegjpotter.androidroomdatabasetutorialbasic.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lukegjpotter.androidroomdatabasetutorialbasic.R;
import com.lukegjpotter.androidroomdatabasetutorialbasic.database.BlogPostDatabase;
import com.lukegjpotter.androidroomdatabasetutorialbasic.database.util.DatabaseInitializer;
import com.lukegjpotter.androidroomdatabasetutorialbasic.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Populate the Database.
        DatabaseInitializer.populateAsync(BlogPostDatabase.getInstance(getApplicationContext()));

        // Set the layout.
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(binding.toolbar);

        // When the Floating Action Button is clicked start the Add Blog Post Activity.
        binding.fab.setOnClickListener((view) ->
                startActivity(new Intent(MainActivity.this, AddBlogPostActivity.class)));
    }
}
