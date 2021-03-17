package com.example.sbs.insta.Service;



import androidx.annotation.NonNull;


import com.example.sbs.insta.Util.Util;
import com.example.sbs.insta.api.MainAPI;
import com.example.sbs.insta.api.MainAPI_RB;
import com.example.sbs.insta.api.MainAPI_usr_Articlelist;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class ArticleService {
    private MainAPI mainApi;

    @Inject
    public ArticleService(MainAPI mainApi) {
        this.mainApi = mainApi;
    }

    public void usr_article_list(int boardId, int page, @NonNull Consumer<? super MainAPI_RB<MainAPI_usr_Articlelist>> onNext) {
        mainApi.usr_article_list(boardId, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onNext, throwable -> {
                    Util.log("throwable : " + throwable.getMessage());
                });
    }
}
