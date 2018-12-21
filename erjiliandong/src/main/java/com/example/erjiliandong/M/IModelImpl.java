package com.example.erjiliandong.M;

import com.example.erjiliandong.CallBack.MyCallBack;
import com.example.erjiliandong.OkHttp.ICallBack;
import com.example.erjiliandong.OkHttp.OkHttp;

import java.util.Map;

public class IModelImpl implements IModel {
    @Override
    public void requestData(String urlStr, Map<String, String> param, Class clazz, final MyCallBack callBack) {
        OkHttp.getInstance().getQueue(urlStr, param, clazz, new ICallBack() {
            @Override
            public void getResponse(Object obj) {
                callBack.onSuccess(obj);
            }

            @Override
            public void getFails(Exception e) {
                callBack.onSuccess(e);
            }
        });
    }
}
