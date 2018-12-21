package com.example.erjiliandong.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.erjiliandong.Bean.ShowTypeProductBean;
import com.example.erjiliandong.R;

import java.util.ArrayList;
import java.util.List;

public class ShowTypeProductLinearAdapter extends RecyclerView.Adapter<ShowTypeProductLinearAdapter.ViewHolder> {
    private Context mContext;
    private List<ShowTypeProductBean.DataBean.ListBean> mList = new ArrayList<>();

    public ShowTypeProductLinearAdapter(Context context) {
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(mContext,R.layout.shop_type_product_linear_adapter,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(mContext).load(mList.get(i).getIcon()).into(viewHolder.mImage);
        viewHolder.name.setText(mList.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setData(List<ShowTypeProductBean.DataBean.ListBean> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView mImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_shop_type_product_linear);
            mImage = itemView.findViewById(R.id.iv_shop_type_product_linear);
        }
    }
}
