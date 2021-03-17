package com.example.sbs.insta.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MainAPI_RB<T> {
    public String resultCode;
    public String msg;
    public boolean fail;
    public boolean success;
    public T body;
}
