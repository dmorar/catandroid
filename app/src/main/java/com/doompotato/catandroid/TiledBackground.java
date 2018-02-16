package com.doompotato.catandroid;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by dmorard on 15/2/2018.
 */

public class TiledBackground {

    private Bitmap image;
    private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    private int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;

    public TiledBackground(Bitmap bmp) {
        image = bmp;
    }
    public void draw(Canvas canvas) {
        int repeatsOnX = screenWidth / image.getWidth()+1;
        int repeatsOnY = screenHeight/ image.getHeight()+1;
        for(int y=0; y < repeatsOnY ; y++){
            for(int x=0; x < repeatsOnX ; x++){
                canvas.drawBitmap(image, image.getWidth()*x, image.getHeight()*y, null);
            }
        }
    }
}
