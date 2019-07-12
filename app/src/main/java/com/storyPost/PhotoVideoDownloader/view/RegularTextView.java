package com.storyPost.PhotoVideoDownloader.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.storyPost.PhotoVideoDownloader.GlobalConstant;

/**
 * Created by nitin on 19/05/19.
 */

@SuppressLint("AppCompatCustomView")
public class RegularTextView extends TextView {
    public RegularTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public RegularTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RegularTextView(Context context) {
        super(context);

        init();
    }

    private void init() {

        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                GlobalConstant.REGULAR_FONT);

        setTypeface(tf);

    }

}
