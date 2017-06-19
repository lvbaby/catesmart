package com.fancyedu.catesmart.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.andview.refreshview.recyclerview.BaseRecyclerAdapter;

import java.util.List;

/**
 * Created by Hyy on 2016/8/5.
 */
public abstract class CommonRecycleViewAdapter<T> extends BaseRecyclerAdapter<CustomViewHold> {


    private Context mContext;
    public int resource;
    List<T> itemDatas;
    List<Integer> resources;

    public CommonRecycleViewAdapter(Context mContext, int resource, List<T> itemDatas) {
        this.mContext = mContext;
        this.resource = resource;
        this.itemDatas = itemDatas;
    }

    public CommonRecycleViewAdapter(Context mContext, List<Integer> resources, List<T> itemDatas) {
        this.mContext = mContext;
        this.resources = resources;
        this.itemDatas = itemDatas;
    }

    @Override
    public CustomViewHold getViewHolder(View view) {
        return new CustomViewHold(view);
    }

    @Override
    public CustomViewHold onCreateViewHolder(ViewGroup parent, int viewType, boolean isItem) {
        return CustomViewHold.creatViewHolder(mContext, parent, resource);
    }

    @Override
    public void onBindViewHolder(CustomViewHold holder, int position, boolean isItem) {
        bindView(holder, itemDatas.get(position), position);
    }

    @Override
    public int getAdapterItemCount() {
        return itemDatas.size();
    }

    public abstract void bindView(CustomViewHold customViewHold, T item, int position);

    public void notifyDataSetChanged(List<T> newDatas) {
        itemDatas.clear();
        itemDatas.addAll(newDatas);
        this.notifyDataSetChanged();
    }

    public void addAll(List<T> addDatas) {

        if (addDatas != null) {
            itemDatas.addAll(addDatas);
        }

        this.notifyDataSetChanged();
    }


    @Override
    public int getAdapterItemViewType(int position) {
        return super.getAdapterItemViewType(position);
    }
}
