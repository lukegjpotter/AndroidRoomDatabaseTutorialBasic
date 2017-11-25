package com.lukegjpotter.androidroomdatabasetutorialbasic.activity;

import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lukegjpotter.androidroomdatabasetutorialbasic.R;
import com.lukegjpotter.androidroomdatabasetutorialbasic.database.BlogPostDatabase;
import com.lukegjpotter.androidroomdatabasetutorialbasic.databinding.FragmentAddBlogPostBinding;
import com.lukegjpotter.androidroomdatabasetutorialbasic.entity.BlogPost;

/**
 * A placeholder fragment containing a simple view.
 */
public class AddBlogPostActivityFragment extends Fragment {

    public AddBlogPostActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentAddBlogPostBinding binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_add_blog_post,
                container,
                false);

        binding.addBlogPostButton.setOnClickListener((view) -> {
            String blogPostTitleEditTextContent = binding.addBlogPostTextInputEditText
                    .getText().toString().trim();

            if (!blogPostTitleEditTextContent.isEmpty()) {
                new AddBlogPostTask(blogPostTitleEditTextContent).execute();
                getActivity().finish();
            }
        });

        return binding.getRoot();
    }

    private class AddBlogPostTask extends AsyncTask<Void, Void, Void> {
        String blogPostTitle;

        public AddBlogPostTask(String blogPostTitle) {
            this.blogPostTitle = blogPostTitle;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            BlogPostDatabase.getInstance(getActivity().getApplication()).blogPostDao().insertBlogPosts(new BlogPost(blogPostTitle));
            return null;
        }
    }
}
