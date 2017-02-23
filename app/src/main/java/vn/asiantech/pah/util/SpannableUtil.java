package vn.asiantech.pah.util;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;

import vn.asiantech.pah.listener.OnClickSpannableListener;

/**
 * Copyright © 2016 AsianTech inc.
 * Created by binc on 19/01/2017.
 */

public final class SpannableUtil {

    private SpannableUtil() {
        //no-op
    }

    public static SpannableString setTextSpannable(String text , int start, int end, final OnClickSpannableListener listener, final String tag) {
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Log.i("TAG11","dfgdfgdgdgdgdg");
                if (listener != null) {
                    listener.onClickSpannable(tag);
                }
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.parseColor("#F8E81C"));
                ds.setUnderlineText(false);
            }
        };

        SpannableString ss = new SpannableString(text);
        ss.setSpan(clickableSpan, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return ss;
    }
}
