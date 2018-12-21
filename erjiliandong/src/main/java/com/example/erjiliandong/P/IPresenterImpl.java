package com.example.erjiliandong.P;

import com.example.erjiliandong.CallBack.MyCallBack;
import com.example.erjiliandong.M.IModelImpl;
import com.example.erjiliandong.V.IView;

import java.util.Map;

public class IPresenterImpl implements IPresenter {
    private IModelImpl model;
    private IView iView;

    public IPresenterImpl(IView iView) {
        this.iView = iView;
        model =new IModelImpl();
    }

    @Override
    public void startRequest(String urlStr, Map<String, String> param, Class clazz) {
        model.requestData(urlStr, param, clazz, new MyCallBack() {
            @Override
            public void onSuccess(Object data) {
                iView.onSuccess(data);
            }
        });
    }
    public void onDetach(){
        if(model!=null){
             model=null;
        }else if(iView!=null){
            iView = null;
        }
    }
}
