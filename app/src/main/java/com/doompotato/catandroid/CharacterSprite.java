package com.doompotato.catandroid;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.Display;

/**
 * Created by dmorard on 14/2/2018.
 */

public class CharacterSprite {
    private Bitmap image;
    private float x;
    private float y;
    private int xVelocity = 10;
    private int yVelocity = 20;
    private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    private int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;

    public CharacterSprite(Bitmap bmp, float x,float y) {
        image = bmp;
        this.x = x;
        this.y = y;
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, x, y, null);
    }

    public void update(){
        x += xVelocity;
        y += yVelocity;
        if ((x > screenWidth - image.getWidth()) || (x < 0)) {
            xVelocity = xVelocity * -1;
        }
        if ((y > screenHeight - image.getHeight()) || (y < 0)) {
            yVelocity = yVelocity * -1;
        }
        int asd = image.getDensity();
    }

    public void moveToPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }
}