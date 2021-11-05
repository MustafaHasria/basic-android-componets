package com.example.basicandroidcomponents.models.steppers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.basicandroidcomponents.R;

public class ViewPagerAdapter extends PagerAdapter {

    Context context;

    int images[] = {

            R.drawable.steppers_image_1,
            R.drawable.steppers_image_2,
            R.drawable.steppers_image_3,
            R.drawable.steppers_image_4

    };

    int headings[] = {

            R.string.heading_one,
            R.string.heading_two,
            R.string.heading_three,
            R.string.heading_fourth
    };

    int description[] = {

      R.string.desc_one,
      R.string.desc_two,
      R.string.desc_three,
      R.string.desc_fourth
    };

    public ViewPagerAdapter(Context context){

        this.context = context;

    }

    @Override
    public int getCount() {
        return  headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.steppers_slider_for_view_pager,container,false);

        ImageView steppersSliderForViewPagerImageView = (ImageView) view.findViewById(R.id.steppers_slider_for_view_pager_image_view);
        TextView steppersSliderForViewPagerTextViewTitle = (TextView) view.findViewById(R.id.steppers_slider_for_view_pager_text_view_title);
        TextView steppersSliderForViewPagerTextViewDesc = (TextView) view.findViewById(R.id.steppers_slider_for_view_pager_text_view_desc);

        steppersSliderForViewPagerImageView.setImageResource(images[position]);
        steppersSliderForViewPagerTextViewTitle.setText(headings[position]);
        steppersSliderForViewPagerTextViewDesc.setText(description[position]);

        container.addView(view);

        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((LinearLayout)object);

    }
}
