package com.fancyedu.catesmart.ui.adapter;

import android.content.Context;

import com.fancyedu.catesmart.R;

import java.util.List;

/**
 * Created by Hyy on 2017/6/17.
 */

public class GoodsAdapter extends CommonRecycleViewAdapter<String> {
    public GoodsAdapter(Context mContext, List<String> itemDatas) {
        super(mContext, R.layout.item_goods, itemDatas);
    }

    @Override
    public void bindView(CustomViewHold customViewHold, String item, int position) {

    }
}
