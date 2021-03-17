package com.example.sbs.insta.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.sbs.insta.Service.ArticleService;
import com.example.sbs.insta.Util.Util;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class HomeViewModel extends ViewModel {

    @Inject// : 여기에 삽입될 것이라는 뜻
    public HomeViewModel(ArticleService articleService) {
        articleService.usr_article_list(1,1, rb->{
            Util.log("rb.body.articles : "+rb.body.articles);

        } );
    }

}