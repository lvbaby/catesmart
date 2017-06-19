package com.fancyedu.catesmart.ui.view;

import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

/**
 * Created by Hyy on 2017/6/18.
 */

public class GoodsPopupWindow extends PopupWindow {
    View popopView;

    View locationView;

    Activity mContext;


    Button confirm;

    TextView title;
    TextView content;
    ImageView cancle;

    private void initPopupWionw() {

        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        setHeight(ViewGroup.LayoutParams.MATCH_PARENT);

        setOutsideTouchable(false);

        setContentView(popopView);


    }


    public GoodsPopupWindow(Activity mContext, View locationView) {
        super(mContext);
        this.mContext = mContext;
        this.locationView = locationView;


        popopView = LayoutInflater.from(mContext).inflate(R.layout.popuwindow_prompt_text, (ViewGroup) locationView, false);
        confirm = (Button) popopView.findViewById(R.id.confirm);
        title = (TextView) popopView.findViewById(R.id.title);
        content = (TextView) popopView.findViewById(R.id.content);
        cancle = (ImageView) popopView.findViewById(R.id.cancel);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onclinkCallBack != null) {
                    onclinkCallBack.confirmCallBack();
                    dismiss();
                } else {
                    dismiss();
                }
            }

        });

        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });


        initPopupWionw();
    }


    @Override
    public void showPopupWindow() {
        super.showPopupWindow();

        showAtLocation(locationView, Gravity.CENTER, 0, 0);
    }
}
