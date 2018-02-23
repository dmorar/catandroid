package com.doompotato.catandroid;

/**
 * Created by dmorard on 22/2/2018.
 */

public class TileDTO {
    private TileType tileType;
    private int tileNumber;

    public TileDTO(TileType tileType, int tileNumber){
        setTileType(tileType);
        setTileNumber(tileNumber);
    }
    public TileType getTileType() {
        return tileType;
    }

    public void setTileType(TileType tileType) {
        this.tileType = tileType;
    }

    public int getTileNumber() {
        return tileNumber;
    }

    public void setTileNumber(int tileNumber) {
        this.tileNumber = tileNumber;
    }
}
