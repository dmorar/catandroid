package com.doompotato.catandroid;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by dmorard on 22/2/2018.
 */

public class Tiles implements Drawable{
    private ArrayList<TileSprite> tiles;

    public Tiles(Map<TileType, Bitmap> tilesBitmap, List<TileDTO> tilesNumber, float x, float y) {
        buildTiles(tilesBitmap,tilesNumber,x,y);
    }

    private void buildTiles(Map<TileType, Bitmap> tilesBitmap, List<TileDTO> tilesNumber, float x, float y) {
        int plusX = 0;
        int plusY = 0;
        int i = 0;
        this.tiles = new ArrayList<TileSprite>();

        for (TileDTO entry : tilesNumber) {
            Bitmap bitmap = tilesBitmap.get(entry.getTileType());
            switch (i) {
                case 0:
                    plusX = bitmap.getWidth();
                    break;
                case 3:
                    plusX = bitmap.getWidth() / 2;
                    plusY = bitmap.getHeight();
                    plusY *= 0.75;
                    break;
                case 7:
                    plusX = 0;
                    plusY *= 2;
                    break;
                case 12:
                    plusX = bitmap.getWidth() / 2;
                    plusY *= 1.5;
                    break;
                case 16:
                    plusX = bitmap.getWidth();
                    plusY *= 1.333333;
                    break;
            }
            TileSprite tileSprite = new TileSprite(bitmap, entry.getTileNumber(), x + plusX, y + plusY);
            plusX += bitmap.getWidth();
            this.tiles.add(tileSprite);
            i++;
        }
    }

    @Override
    public void draw(Canvas canvas) {
        for (TileSprite tile : tiles) {
            tile.draw(canvas);
        }
    }

    @Override
    public void update() {

    }
}
