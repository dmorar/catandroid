package com.doompotato.catandroid;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by dmorard on 23/2/2018.
 */

public class CityShape implements Drawable{


    public CityShape(float x, float y) {

    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawCircle(Convert.dpToPx(10),Convert.dpToPx(10),Convert.dpToPx(10),null);
    }

    @Override
    public void update() {

    }
}
