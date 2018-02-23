package com.doompotato.catandroid;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmorard on 22/2/2018.
 */

public class Cities {
    List<CityShape> cities;
    Bitmap city;
    Bitmap town;
    public Cities(float x, float y, float shapeWidth, float shapeHeight) {
        cities=new ArrayList<CityShape>();
        cities.add(new CityShape());
    }
}
