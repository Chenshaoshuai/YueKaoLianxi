package com.example.erjiliandong.M;

import com.example.erjiliandong.CallBack.MyCallBack;

import java.util.Map;

public interface IModel{
    void requestData(String urlStr, Map<String,String> param, Class clazz, MyCallBack callBack);
}
