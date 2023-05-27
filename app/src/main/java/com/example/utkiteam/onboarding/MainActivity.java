package com.example.utkiteam.onboarding;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.ScaleXSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.utkiteam.R;
import com.example.utkiteam.enter.HomePage;

public class MainActivity extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotlayout;

    private TextView[] mDots;

    private Button bt_ob_skip;
    private Button bt_ob_next;

    private int mCurrentPage;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.statusbar));

        mSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        mDotlayout = (LinearLayout) findViewById(R.id.DotLayout);

        bt_ob_skip = (Button) findViewById(R.id.bt_ob_skip);
        bt_ob_next = (Button) findViewById(R.id.bt_ob_next);

        SliderAdapter SliderAdapter = new SliderAdapter(this);

        mSlideViewPager.setAdapter(SliderAdapter);

        addDotsIndicator(0);

        mSlideViewPager.addOnPageChangeListener(viewListener);

        bt_ob_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mCurrentPage == 2) {
                    Intent intent = new Intent(MainActivity.this, com.example.utkiteam.enter.HomePage.class);
                    startActivity(intent);
                } else {
                    mSlideViewPager.setCurrentItem(mCurrentPage + 1);
                }


            }
        });

        bt_ob_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(3);
            }
        });


    }


    public void addDotsIndicator(int position) {

        mDots = new TextView[3];
        mDotlayout.removeAllViews();

        for (int i = 0; i < mDots.length; i++) {

            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226 "));
            //mDots[i].setText("&#8226");
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.dots_grey_onboarding));

            mDotlayout.addView(mDots[i]);

        }

        if (mDots.length > 0) {

            mDots[position].setTextColor(getResources().getColor(R.color.dots_chose_grey_onboarding));

        }

    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);
            mCurrentPage = position;

            if (position == 0) {
                bt_ob_skip.setEnabled(true);
                bt_ob_next.setEnabled(true);
                bt_ob_skip.setVisibility(View.VISIBLE);

                bt_ob_skip.setText("Пропустить");
                bt_ob_next.setText("Дальше");

            } else if (position == mDots.length - 1) {
                bt_ob_skip.setEnabled(true);
                bt_ob_next.setEnabled(true);
                bt_ob_skip.setVisibility(View.VISIBLE);

                bt_ob_skip.setText("");
                bt_ob_next.setText("Вход");
            } else {
                bt_ob_skip.setEnabled(true);
                bt_ob_next.setEnabled(true);
                bt_ob_skip.setVisibility(View.VISIBLE);

                bt_ob_skip.setText("Пропустить");
                bt_ob_next.setText("Дальше");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


}