package com.lukegjpotter.androidroomdatabasetutorialbasic.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lukegjpotter.androidroomdatabasetutorialbasic.R;
import com.lukegjpotter.androidroomdatabasetutorialbasic.databinding.FragmentMainBinding;
import com.lukegjpotter.androidroomdatabasetutorialbasic.recyclerview.MainActivityFragmentRecyclerViewAdapter;
import com.lukegjpotter.androidroomdatabasetutorialbasic.viewmodel.DummyDataViewModel;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FragmentMainBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);

        MainActivityFragmentRecyclerViewAdapter recyclerViewAdapter = new MainActivityFragmentRecyclerViewAdapter(new ArrayList<>());
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.recyclerView.setAdapter(recyclerViewAdapter);

        DummyDataViewModel viewModel = ViewModelProviders.of(this).get(DummyDataViewModel.class);

        viewModel.getBlogPosts().observe(MainActivityFragment.this, recyclerViewAdapter::addBlogPosts);

        return binding.getRoot();
    }
}
