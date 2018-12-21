package com.example.erjiliandong;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.erjiliandong.Adapter.ShowTypeAdapter;
import com.example.erjiliandong.Adapter.ShowTypeProductAdapter;
import com.example.erjiliandong.Bean.ShowTypeBean;
import com.example.erjiliandong.Bean.ShowTypeProductBean;
import com.example.erjiliandong.P.IPresenterImpl;
import com.example.erjiliandong.V.IView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements IView {
    private IPresenterImpl iPresenter;
    private ShowTypeProductAdapter showTypeProductAdapter;
    private ShowTypeAdapter showTypeAdapter;
    private RecyclerView recyclerViewShop,recyclerViewShopType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iPresenter = new IPresenterImpl(this);
        initShopTypeView();
        initShopTypeProductView();
         getTypeData();
    }

    private void getTypeData() {
        Map<String,String> map = new HashMap<>();

        iPresenter.startRequest(Apis.URL_PRODUCT_GET_CATAGORY,map,ShowTypeBean.class);
    }

    private void initShopTypeProductView() {
       recyclerViewShop = findViewById(R.id.recyclerview_shop_type);

        LinearLayoutManager linearLayoutManagerleft = new LinearLayoutManager(this);
        linearLayoutManagerleft.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewShop.setLayoutManager(linearLayoutManagerleft);

        recyclerViewShop.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        showTypeAdapter = new ShowTypeAdapter(this);
        recyclerViewShop.setAdapter(showTypeAdapter);

        showTypeAdapter.set0nClick(new ShowTypeAdapter.OnClick() {
            @Override
            public void click(int position, String cid) {
                getShopData(cid);
            }
        });
    }

    private void getShopData(String cid) {
        Map<String,String> map = new HashMap<>();
        map.put("cid",cid);
        iPresenter.startRequest(Apis.URL_PRODUCT_GET_PRODUCT_CATAGORY,map,ShowTypeProductBean.class);
    }


    private void initShopTypeView() {
        recyclerViewShopType = findViewById(R.id.recyclerview_shop);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewShopType.setLayoutManager(linearLayoutManager);

        recyclerViewShopType.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        showTypeProductAdapter = new ShowTypeProductAdapter(this);
        recyclerViewShopType.setAdapter(showTypeProductAdapter);
    }

    @Override
    public void onSuccess(Object data) {
         if(data instanceof ShowTypeBean){
             ShowTypeBean showTypeBean = (ShowTypeBean) data;
             showTypeAdapter.setData(showTypeBean.getData());
         }else if(data instanceof ShowTypeProductBean){
             ShowTypeProductBean showTypeProductBean = (ShowTypeProductBean) data;
             showTypeProductAdapter.setData(showTypeProductBean.getData());

             recyclerViewShopType.scrollToPosition(0);
         }
    }
}
