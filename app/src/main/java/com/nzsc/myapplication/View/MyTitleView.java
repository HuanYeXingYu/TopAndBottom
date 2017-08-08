package com.nzsc.myapplication.View;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;


import com.nzsc.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 夜墨 on 2017/8/7.
 */

public class MyTitleView extends ConstraintLayout {

    @BindView(R.id.tv_top_content)
    TextView tvTopContent;
    @BindView(R.id.imag_top_left)
    ImageView imagTopLeft;
    @BindView(R.id.imag_top_right)
    ImageView imagTopRight;

    public MyTitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.top_view, this);
        ButterKnife.bind(this);
    }

    // 为左侧返回按钮添加自定义点击事件
    public void setLeftImageListener(OnClickListener listener) {
        imagTopLeft.setOnClickListener(listener);
    }
    // 为右侧返回按钮添加自定义点击事件
    public void setRightImageListener(OnClickListener listener) {
        imagTopRight.setOnClickListener(listener);
    }
    public void setRightImageRes(int imageID) {
        imagTopRight.setImageResource(imageID);
    }
    public void setLeftImageRes(int imageID) {
        imagTopLeft.setImageResource(imageID);
    }
    // 设置标题的方法
    public void setTitle(String title) {
        tvTopContent.setText(title);
    }


}
