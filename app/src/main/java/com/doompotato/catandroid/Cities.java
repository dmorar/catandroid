package com.doompotato.catandroid;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmorard on 22/2/2018.
 */

public class Cities implements Drawable{
    List<CityShape> cities;
    Bitmap city;
    Bitmap town;
    public Cities(float x, float y,float tileWidth,float tileHeight) {
        cities=new ArrayList<CityShape>();
        cities.add(new CityShape((float)(tileWidth*1.5),y));
        cities.add(new CityShape((float)(tileWidth*2.5),y));
        cities.add(new CityShape((float)(tileWidth*3.5),y));
        cities.add(new CityShape(1,0));
    }

    @Override
    public void draw(Canvas canvas) {
        for (CityShape city:cities) {
            city.draw(canvas);
        }
    }

    @Override
    public void update() {

    }
}
