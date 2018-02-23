package com.doompotato.catandroid;

import android.graphics.Bitmap;

/**
 * Created by dmorard on 19/2/2018.
 */

public class TileSprite extends Sprite {

    int diceNumber;

    public TileSprite(Bitmap bmp,int diceNumber, float x, float y) {
        super(bmp, x, y);
        this.diceNumber=diceNumber;
    }
}
