package com.example.myapplication.view_model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class PostDetailViewModel extends ViewModel {

    MutableLiveData<ArrayList<String>>  tagsLiveData;
    MutableLiveData<ArrayList<String>> urlLiveData;
    ArrayList<String> tagsList;
    ArrayList<String> urlList;

    public PostDetailViewModel() {
        tagsLiveData= new MutableLiveData<>();
        urlLiveData = new MutableLiveData<>();
        init();
    }

    public MutableLiveData<ArrayList<String>> getTagsLiveData() {
        return tagsLiveData;
    }

    public MutableLiveData<ArrayList<String>> getUrlLiveData() {
        return urlLiveData;
    }

    private void init() {
        populateList();
        populateUrlList();
        tagsLiveData.setValue(tagsList);
        urlLiveData.setValue(urlList);
    }

    private void populateUrlList() {
        urlList = new ArrayList<>();
        urlList.add("https://wjddnjs754.cafe24.com/web/product/small/202303/5b9279582db2a92beb8db29fa1512ee9.jpg");
        urlList.add("https://wjddnjs754.cafe24.com/web/product/small/202303/5b9279582db2a92beb8db29fa1512ee9.jpg");
        urlList.add("https://wjddnjs754.cafe24.com/web/product/small/202303/5b9279582db2a92beb8db29fa1512ee9.jpg");
        urlList.add("https://wjddnjs754.cafe24.com/web/product/small/202303/5b9279582db2a92beb8db29fa1512ee9.jpg");
    }

    private void populateList() {
        tagsList = new ArrayList<>();
        tagsList.add("#2023");
        tagsList.add("#TODAYISMONDAY");
        tagsList.add("#TOP");
        tagsList.add("#POPS!");
        tagsList.add("#WOW");
        tagsList.add("#ROW");
    }




}