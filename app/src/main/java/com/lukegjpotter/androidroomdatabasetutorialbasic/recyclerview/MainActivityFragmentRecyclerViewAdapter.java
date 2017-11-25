package com.lukegjpotter.androidroomdatabasetutorialbasic.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.lukegjpotter.androidroomdatabasetutorialbasic.databinding.RecyclerItemBinding;
import com.lukegjpotter.androidroomdatabasetutorialbasic.entity.BlogPost;

import java.util.List;

/**
 * Created by lukegjpotter on 24/11/2017.
 */
public class MainActivityFragmentRecyclerViewAdapter extends RecyclerView.Adapter<MainActivityFragmentRecyclerViewAdapter.MainActivityFragmentRecyclerViewHolder> {

    private List<BlogPost> blogPosts;

    public MainActivityFragmentRecyclerViewAdapter(List<BlogPost> blogPosts) {
        this.blogPosts = blogPosts;
    }

    @Override
    public MainActivityFragmentRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerItemBinding itemBinding = RecyclerItemBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);

        return new MainActivityFragmentRecyclerViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(MainActivityFragmentRecyclerViewHolder holder, int position) {
        String blogPostTitle = blogPosts.get(position).getTitle();
        holder.bind(blogPostTitle);
    }

    @Override
    public int getItemCount() {
        return blogPosts.size();
    }

    public void setBlogPosts(List<BlogPost> blogPosts) {
        this.blogPosts = blogPosts;
        notifyDataSetChanged();
    }

    static class MainActivityFragmentRecyclerViewHolder extends RecyclerView.ViewHolder {

        RecyclerItemBinding binding;

        MainActivityFragmentRecyclerViewHolder(RecyclerItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(String blogPostTitle) {
            binding.blogPostTextView.setText(blogPostTitle);
            binding.executePendingBindings();
        }
    }
}