package com.example.myapplication.fragment;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.adapter.PostDetailImagePagerAdapter;
import com.example.myapplication.adapter.TagsRvAdapter;
import com.example.myapplication.databinding.FragmentPostDetailBinding;
import com.example.myapplication.view_model.PostDetailViewModel;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.Objects;

public class PostDetailFragment extends Fragment implements LifecycleOwner {

    FragmentPostDetailBinding binding;
    private PostDetailViewModel mViewModel;
    private TagsRvAdapter tagsRvAdapter;
    private PostDetailImagePagerAdapter pagerAdapter;

    public static PostDetailFragment newInstance() {
        return new PostDetailFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_post_detail, container, false);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(PostDetailViewModel.class);
        mViewModel.getTagsLiveData().observe(getViewLifecycleOwner(), tagsListUpdateObserver);
        mViewModel.getUrlLiveData().observe(getViewLifecycleOwner(),urlListUpdateObserver);
        setUpTagsData();
        setUpViewPagerData();

    }

    private void setUpViewPagerData() {



//        binding.imageViewPager.adapter = PostDetailImagePagerAdapter(this, mViewModel.getUrlLiveData())
//
//
//        TabLayoutMediator(binding.introDots, binding.viewPager) {
//            tab, position ->
//
//
//        }.attach()
    }

    private void setUpTagsData() {
        tagsRvAdapter = new TagsRvAdapter(getContext(), new ArrayList<>());
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(getContext());
        binding.tagsRv.setLayoutManager(layoutManager);
        binding.tagsRv.setAdapter(tagsRvAdapter);
    }

    Observer<ArrayList<String>> tagsListUpdateObserver = new Observer<ArrayList<String>>() {
        @Override
        public void onChanged(ArrayList<String> tagsList) {
            tagsRvAdapter.updateTagsList(tagsList);
        }
    };

    Observer<ArrayList<String>> urlListUpdateObserver = new Observer<ArrayList<String>>() {
        @Override
        public void onChanged(ArrayList<String> urlList) {
            pagerAdapter = new PostDetailImagePagerAdapter(requireActivity(),urlList);
            binding.imageViewPager.setAdapter(pagerAdapter);
            new TabLayoutMediator(binding.postImageTabLayout, binding.imageViewPager,
                    (tab, position) ->
                            tab.getIcon()
                            //tab.setText("OBJECT " + (position + 1))
            ).attach();
        }
    };

}