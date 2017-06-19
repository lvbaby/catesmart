package com.fancyedu.catesmart.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import com.fancyedu.catesmart.R;

import java.util.List;

/**
 * Created by Hyy on 2017/6/17.
 */

public class GoodsMeauAdapter extends CommonRecycleViewAdapter<String> {

   public int oldPosition;

    public GoodsMeauAdapter(Context mContext, List<String> itemDatas) {
        super(mContext, R.layout.item_category, itemDatas);
    }


    @Override
    public void bindView(CustomViewHold customViewHold, String item, final int position) {
        if (position == 0) {
            oldPosition = 0;
            customViewHold.getRoorView().setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
        customViewHold.getRoorView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemOnClickCallBack != null) {
                    itemOnClickCallBack.OnClickCallBack(position);
                }
            }
        });

    }

    public ItemOnClickCallBack getItemOnClickCallBack() {
        return itemOnClickCallBack;
    }

    public void setItemOnClickCallBack(ItemOnClickCallBack itemOnClickCallBack) {
        this.itemOnClickCallBack = itemOnClickCallBack;
    }

    private ItemOnClickCallBack itemOnClickCallBack;


    public interface ItemOnClickCallBack {
        void OnClickCallBack(int position);
    }
}
