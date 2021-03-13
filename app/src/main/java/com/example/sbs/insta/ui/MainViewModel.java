package com.example.sbs.insta.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class MainViewModel extends ViewModel {
    public MutableLiveData<String> lvAvartarImgUrl = new MutableLiveData<>();

    public MainViewModel(){
        // 아바타 이미지 세팅
        String avarterImgURL ="https://i.pravatar.cc/600?img="+new Random().nextInt(10)+1;
        lvAvartarImgUrl.setValue(avarterImgURL);
    }
}
