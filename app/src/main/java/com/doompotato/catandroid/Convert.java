package com.doompotato.catandroid;

import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * Created by dmorard on 22/2/2018.
 */

public  class Convert {

    private static final DisplayMetrics dm = Resources.getSystem().getDisplayMetrics();

    public static float dpToPx(float dp) {
        int px = Math.round(dp * (dm.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return px;
    }
    public static int pxToDp(float px) {
        int dp = Math.round(px / (dm.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return dp;
    }
}
