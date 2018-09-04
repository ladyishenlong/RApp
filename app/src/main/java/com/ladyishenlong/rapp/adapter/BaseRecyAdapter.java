package com.ladyishenlong.rapp.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ladyishenlong.rapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class BaseRecyAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {


    protected Context context;
    protected List<T> datas;

    public BaseRecyAdapter(Context context, List<T> datas) {
        this.context = context;
        this.datas = datas;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        @LayoutRes int layoutId = setLayout();
        LayoutInflater inflater =LayoutInflater.from(context);
        BaseViewHolder viewHolder =new BaseViewHolder(inflater.inflate(layoutId, parent, false));
        return viewHolder;
    }

    /**
     * 返回的是该recycleview的布局，
     * 放在此处方便butterknfie的插件使用
     * */
    protected abstract int setLayout();


    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        View itemView = holder.getItemView();
        ButterKnife.bind(this, itemView);//绑定butterknife
        bindData(datas.get(position),position);
    }



    /**
     * 子类数据设置处
     * */
    protected abstract void bindData(T data,int position);



    /**
     * 设置数据
     */
    public void setDatas(List<T> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }



    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }


}
