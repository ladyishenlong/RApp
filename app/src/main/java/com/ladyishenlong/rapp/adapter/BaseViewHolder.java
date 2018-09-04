package com.ladyishenlong.rapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * baseViewHolder
 * 用来返回itemView
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {

    private View itemView;

    public BaseViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
    }

    public View getItemView() {
        return itemView;
    }
}
