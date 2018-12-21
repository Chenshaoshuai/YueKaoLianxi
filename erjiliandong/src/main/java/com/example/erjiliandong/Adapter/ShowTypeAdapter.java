package com.example.erjiliandong.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.erjiliandong.Bean.ShowTypeBean;
import com.example.erjiliandong.R;

import java.util.ArrayList;
import java.util.List;

public class ShowTypeAdapter extends RecyclerView.Adapter<ShowTypeAdapter.ViewHolder> {
    private Context mContext;
    private List<ShowTypeBean.DataBean> mList = new ArrayList<>();

    public ShowTypeAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(mContext,R.layout.shop_type_adapter,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
      viewHolder.name.setText(mList.get(i).getName());
      viewHolder.layout.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            if(m0nClick!=null){
               m0nClick.click(i,mList.get(i).getCid());
            }
          }
      });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setData(List<ShowTypeBean.DataBean> data) {
        this.mList = data;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout layout;
        TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.ll_shop_type);
            name = itemView.findViewById(R.id.tv_shop_type_name);
        }
    }
    OnClick m0nClick;

    public void set0nClick(OnClick onClick) {
        this.m0nClick = onClick;
    }

    public interface OnClick{
        void click(int position,String cid);
    }
}
