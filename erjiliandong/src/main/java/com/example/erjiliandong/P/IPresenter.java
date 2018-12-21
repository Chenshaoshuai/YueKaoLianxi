package com.example.erjiliandong.P;

import android.telecom.Call;

import com.example.erjiliandong.OkHttp.ICallBack;

import java.util.Map;

public interface IPresenter {
    void startRequest(String urlStr, Map<String,String>param, Class clazz);
}
