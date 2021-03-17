package com.example.sbs.insta.api;



import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MainAPI {
    String baseUrl = "http://10.0.2.2:8021/";

    @GET("usr/article/list?")
    Observable<MainAPI_RB<MainAPI_usr_Articlelist>> usr_article_list(@Query("boardId") int boardId, @Query("page") int page);


}
