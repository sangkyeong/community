package com.example.sbs.insta.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.sbs.insta.Service.ArticleService;
import com.example.sbs.insta.Service.MemberService;
import com.example.sbs.insta.Util.Util;

import java.util.Random;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainViewModel extends ViewModel {
    public MutableLiveData<String> lvAvartarImgUrl = new MutableLiveData<>();

    @Inject
    public MainViewModel(@NonNull Application application, ArticleService articleService){
        // 아바타 이미지 세팅
        String avarterImgURL = "https://i.pravatar.cc/600?img="+ new Random().nextInt(10)+1;
        lvAvartarImgUrl.setValue(avarterImgURL);
        articleService.usr_article_list(1, 1, rb -> {
            Util.log("articles : " + rb.body.articles);});
    }
}
