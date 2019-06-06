package com.blackpaper.InstaDownload.stories.profile.post.download.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.blackpaper.InstaDownload.stories.profile.post.download.GlobalConstant;



/**
 * Created by nitin on 19/05/19.
 */
@SuppressLint("AppCompatCustomView")
public class BoldTextView extends TextView {
    public BoldTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public BoldTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BoldTextView(Context context) {
        super(context);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                GlobalConstant.BOLD_FONT);
        setTypeface(tf);
    }

}