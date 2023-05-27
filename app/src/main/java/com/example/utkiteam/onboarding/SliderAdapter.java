package com.example.utkiteam.onboarding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.utkiteam.R;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    public int[] slide_image = {

            R.drawable.slide_1,
            R.drawable.slide_2,
            R.drawable.slide_3,
    };

    public String[] slide_heading = {
            "Вливайся!",
            "Играй!",
            "Узнавай!"
    };

    public String[] slide_descs = {
            "Начинайте работу в нашей компании без лишних проблем. Наше приложение создано чтобы облегчить вам этот процесс. ",
            "С помощью игр мы упростим изучение всех наших основных блоков и структур.",
            "Узнавай полезную информацию у чат-бота внутри приложения. Он ответит на самые популярные вопросы."
    };

    @Override
    public int getCount() {
        return slide_heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.img_ob_1);
        TextView slideHeading = (TextView) view.findViewById(R.id.txt_ob_1);
        TextView slideDescription = (TextView) view.findViewById(R.id.txt_desc_ob_1);

        slideImageView.setImageResource(slide_image[position]);
        slideHeading.setText(slide_heading[position]);
        slideDescription.setText(slide_descs[position]);

        container.addView(view);

        return view;
    }

    ;

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((ConstraintLayout) object);

    }
}
