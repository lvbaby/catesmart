package com.fancyedu.catesmart;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fancyedu.catesmart.ui.adapter.CustomViewHold;
import com.fancyedu.catesmart.ui.adapter.GoodsAdapter;
import com.fancyedu.catesmart.ui.adapter.GoodsMeauAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.category)
    RecyclerView category;
    @Bind(R.id.menu)
    RecyclerView menu;
    @Bind(R.id.goodsRecycleView)
    RecyclerView goodsRecycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        DisplayMetrics dm = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(dm);
//        System.out.println("width heigth : " + dm.heightPixels);
//        System.out.println("width : " + dm.widthPixels);
//        DensityUtil densityUtil = new DensityUtil(this);
//        LogUtil.MyLog("width", DensityUtil.getDmDensityDpi() + "===========width====" + dm.widthPixels + "," + "==========" + dm.heightPixels);

        initGoodsCategory();
        initGoods();
    }

    GoodsMeauAdapter goodsMeauAdapter;

    private void initGoodsCategory() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        category.setLayoutManager(manager);
        List<String> itemDatas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            itemDatas.add("" + i);
        }
        goodsMeauAdapter = new GoodsMeauAdapter(this, itemDatas);
        goodsMeauAdapter.setItemOnClickCallBack(new GoodsMeauAdapter.ItemOnClickCallBack() {
            @Override
            public void OnClickCallBack(int position) {
                CustomViewHold oldViewHolder = (CustomViewHold) category.findViewHolderForAdapterPosition(goodsMeauAdapter.oldPosition); //得到要更新的item的view
                oldViewHolder.getRoorView().setBackgroundColor(Color.parseColor("#2f4050"));

                CustomViewHold viewHolder = (CustomViewHold) category.findViewHolderForAdapterPosition(position); //得到要更新的item的view
                viewHolder.getRoorView().setBackgroundColor(Color.parseColor("#FFFFFF"));

                goodsMeauAdapter.oldPosition = position;

            }
        });

        category.setAdapter(goodsMeauAdapter);
    }

    private void initGoods() {
        List<String> itemDatas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            itemDatas.add("" + i);
        }
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        goodsRecycleView.setLayoutManager(gridLayoutManager);

        GoodsAdapter goodsAdapter = new GoodsAdapter(this, itemDatas);
        goodsRecycleView.setAdapter(goodsAdapter);
    }
}
