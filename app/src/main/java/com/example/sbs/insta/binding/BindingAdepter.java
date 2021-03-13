package com.example.sbs.insta.binding;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.example.sbs.insta.Util.Util;

public class BindingAdepter {
    @BindingAdapter({"imgUrl"})
    public static void imgUrl(ImageView view, String imgUrl) {
        Util.loadImageOn(imgUrl, view);
    }
}
