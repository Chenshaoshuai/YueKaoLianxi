package com.example.erjiliandong.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.erjiliandong.Bean.ShowTypeProductBean;
import com.example.erjiliandong.R;

import java.util.ArrayList;
import java.util.List;

public class ShowTypeProductAdapter extends RecyclerView.Adapter<ShowTypeProductAdapter.ViewHolder> {
    private Context mContext;
    private List<ShowTypeProductBean.DataBean> mList = new ArrayList<>();

    public ShowTypeProductAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(mContext, R.layout.show_type_product_adapter,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.name.setText(mList.get(i).getName());
        ShowTypeProductLinearAdapter showTypeProductLinearAdapter = new ShowTypeProductLinearAdapter(mContext);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        viewHolder.mRecycle.setLayoutManager(linearLayoutManager);
        viewHolder.mRecycle.setAdapter(showTypeProductLinearAdapter);
        viewHolder.mRecycle.addItemDecoration(new DividerItemDecoration(mContext,DividerItemDecoration.VERTICAL));
        showTypeProductLinearAdapter.setData(mList.get(i).getList());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setData(List<ShowTypeProductBean.DataBean> data) {
        this.mList = data;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private RecyclerView mRecycle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mRecycle = itemView.findViewById(R.id.recyclerview_shop_product);
            name = itemView.findViewById(R.id.tv_shop_type_product_name);
        }
    }
}
