package com.doompotato.catandroid;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.Display;

/**
 * Created by dmorard on 14/2/2018.
 */

public class VulpixSprite extends Sprite {

    private int xVelocity = 10;
    private int yVelocity = 20;
    private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    private int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;

    public VulpixSprite(Bitmap bmp, float x, float y) {
        super(bmp, x, y);
    }

    @Override
    public void update() {
      /*  x += xVelocity;
        y += yVelocity;
        //Invert X Speed if it reach the border
        if ((x > screenWidth - image.getWidth()) || (x < 0)) {
            xVelocity = xVelocity * -1;
        }
        //Invert Y Speed if it reach the border
        if ((y > screenHeight - image.getHeight()) || (y < 0)) {
            yVelocity = yVelocity * -1;
        }*/
    }
}