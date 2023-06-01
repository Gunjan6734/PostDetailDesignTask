package com.example.myapplication.common_components;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.myapplication.R;

public class SimpleTitleBar extends ConstraintLayout {
    private ImageView ivLeftBtn;
    private TextView tvCenterTitle;
    private ImageView ivRightBtn;
    private ConstraintLayout clHeaderBar;

    public ImageView getIvLeftBtn() {
        return ivLeftBtn;
    }


    public TextView getTvCenterTitle() {
        return tvCenterTitle;
    }

    public ImageView getIvRightBtn() {
        return ivRightBtn;
    }


    public SimpleTitleBar(Context context) {
        super(context);
        initializeViews(context);
    }

    public SimpleTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeViews(context);
    }

    public SimpleTitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeViews(context);
    }

    private void initializeViews(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.simple_title_bar, this);
        initView(view);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    private void initView(View view) {
        ivLeftBtn = (ImageView) view.findViewById(R.id.iv_left_btn);
        tvCenterTitle = (TextView) view.findViewById(R.id.tv_center_title);
        ivRightBtn = (ImageView) view.findViewById(R.id.iv_right_btn);
        clHeaderBar = findViewById(R.id.cl_header_bar);
    }

    public void setLeftButtonVisible() {
        ivLeftBtn.setVisibility(VISIBLE);
    }

    public void setLeftButtonVisible(Drawable drawable) {
        setLeftButtonVisible();
        ivLeftBtn.setImageDrawable(drawable);
    }

    public void setLeftButtonInvisible() {
        ivLeftBtn.setVisibility(INVISIBLE);
    }

    public void setRightButtonVisible() {
        ivRightBtn.setVisibility(VISIBLE);
    }

    public void setRightButtonVisible(Drawable drawable) {
        setRightButtonVisible();
        ivRightBtn.setImageDrawable(drawable);
    }

    public void setRightButtonInvisible() {
        ivRightBtn.setVisibility(INVISIBLE);
    }


    public void setTitleVisible() {
        tvCenterTitle.setVisibility(VISIBLE);

    }

    public void setTitleVisible(String title) {
        tvCenterTitle.setText(title);
        setTitleVisible();
    }

    public void setLeftButtonOnClickListener(OnClickListener listener) {
        ivLeftBtn.setOnClickListener(listener);
    }

    public void setRightButtonOnClickListener(OnClickListener listener) {
        ivRightBtn.setOnClickListener(listener);
    }

    public void changeHeaderBackground(int res_id) {
        clHeaderBar.setBackgroundColor(getResources().getColor(res_id, null));
    }

}

