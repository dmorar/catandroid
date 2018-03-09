package com.doompotato.catandroid;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.List;
import java.util.Map;

/**
 * Created by dmorard on 19/2/2018.
 */

public class Board implements Drawable {

    private Roads roads;
    private Cities cities;
    private SeaPort seaport;
    private Thief thief;
    private Tiles tiles;
    private float x;
    private float y;

    public Board(Map<TileType, Bitmap> tilesBitmap, List<TileDTO> tilesNumber, float x, float y) {
        this.x=x;
        this.y=y;
        tiles = new Tiles(tilesBitmap,tilesNumber,x,y);
        cities = new Cities(x,y,tiles.getTileWidth(),tiles.getTileHeight());
    }

    @Override
    public void draw(Canvas canvas) {
            tiles.draw(canvas);
            cities.draw(canvas);
    }

    @Override
    public void update() {

    }

}


