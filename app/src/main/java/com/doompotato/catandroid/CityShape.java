package com.doompotato.catandroid;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by dmorard on 23/2/2018.
 */

public class CityShape implements Drawable {

    private float x;
    private float y;
    private Paint paint;

    public CityShape(float x, float y) {
        this.x = x;
        this.y = y;
        paint=new Paint();
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawCircle(Convert.dpToPx(x), Convert.dpToPx(y), Convert.dpToPx(10), paint);
    }

    @Override
    public void update() {

    }
}
