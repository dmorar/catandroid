package com.doompotato.catandroid;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by dmorard on 19/2/2018.
 */

public class Sprite implements Drawable {

     Bitmap image;
     float x;
     float y;


    public Sprite(Bitmap bmp, float x,float y) {
        image = bmp;
        this.x = x;
        this.y = y;
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, x, y, null);
    }

    public void update(){
    }

    public void moveToPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }
}