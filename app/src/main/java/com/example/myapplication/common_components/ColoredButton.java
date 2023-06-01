package com.example.myapplication.common_components;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.myapplication.R;

public class ColoredButton extends ConstraintLayout {
    public TextView textView;
    private ConstraintLayout clColoredButton;

    GradientDrawable shape;

    public ColoredButton(Context context) {
        super(context);
        inflateLayout(context);
    }

    public ColoredButton(@NonNull Context context,
                         @Nullable AttributeSet attrs) {
        super(context, attrs);
        inflateLayout(context);
        shape = new GradientDrawable();
    }

    public ColoredButton(@NonNull Context context,
                         @Nullable AttributeSet attrs,
                         int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflateLayout(context);
    }

    private void inflateLayout(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.colored_button, this);
        initView(view);
    }

    private void initView(View view) {
        textView = view.findViewById(R.id.tv_button_text);
        clColoredButton = findViewById(R.id.cl_colored_button);

    }


    public void setColoredButtonOnClickListener(OnClickListener listener) {
        clColoredButton.setOnClickListener(listener);
    }

    public void makeRoundedCornerTextView(int shapeValue, int color,
                                          int radius, int strokeWidth,
                                          int strokeColor) {
        shape.setShape(shapeValue);
        shape.setColor(color);
        shape.setCornerRadius(radius);
        shape.setStroke(strokeWidth, strokeColor);
        textView.setBackgroundDrawable(shape);
    }

    //MARK: - setters

    public void setButtonText(String title) {
        textView.setText(title);
    }

    public void setTextColor(int color) {
        textView.setTextColor(color);
    }

    public void setTextSize(float size) {
        textView.setTextSize(size);
    }

}

