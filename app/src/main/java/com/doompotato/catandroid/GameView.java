package com.doompotato.catandroid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by dmorard on 9/2/2018.
 */

class GameView extends SurfaceView implements SurfaceHolder.Callback{

    private MainThread thread;

    private VulpixSprite vulpixSprite;
    private TiledBackground tiledBackground;
    private Board board;


    public GameView(Context context) {
        super(context);
        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);
        setFocusable(true);
    }
    public Bitmap getResizedBitmap(Bitmap bm, float newWidth, float newHeight)
    {
        int width = bm.getWidth();
        int height = bm.getHeight();
        float scaleWidth = ( newWidth) / width;
        float scaleHeight = ( newHeight) / height;
        // create a matrix for the manipulation
        Matrix matrix = new Matrix();
        // resize the bit map
        matrix.postScale(scaleWidth, scaleHeight);
        // recreate the new Bitmap
        Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);
        return resizedBitmap;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean bol =  super.onTouchEvent(event);
        vulpixSprite.moveToPosition(event.getX(),event.getY());
        return bol;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            this.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
//        vulpixSprite = new VulpixSprite(getResizedBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.vulpix),200,200),100,100);
//        tiledBackground = new TiledBackground(getResizedBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.grass),200,200));
        DisplayMetrics dm = getContext().getResources().getDisplayMetrics();

        vulpixSprite = new VulpixSprite(getResizedBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.vulpix), Convert.dpToPx(100), Convert.dpToPx(100)),Convert.dpToPx(0),Convert.dpToPx(0));
        tiledBackground = new TiledBackground(BitmapFactory.decodeResource(getResources(),R.drawable.waves));

        HashMap<TileType,Bitmap> tilesBitmaps = new HashMap<>();
        tilesBitmaps.put(TileType.CLAY, getResizedBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.clay), Convert.dpToPx(74), Convert.dpToPx(84)));
        tilesBitmaps.put(TileType.ROCK, getResizedBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.rock), Convert.dpToPx(74), Convert.dpToPx(84)));
        tilesBitmaps.put(TileType.WOOD, getResizedBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.wood), Convert.dpToPx(74), Convert.dpToPx(84)));
        tilesBitmaps.put(TileType.WHEAT, getResizedBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.wheat), Convert.dpToPx(74), Convert.dpToPx(84)));
        tilesBitmaps.put(TileType.SHEEP, getResizedBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.sheep), Convert.dpToPx(74), Convert.dpToPx(84)));
        tilesBitmaps.put(TileType.DESERT, getResizedBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.desert), Convert.dpToPx(74), Convert.dpToPx(84)));
        ArrayList<TileDTO> tilesNumber = new ArrayList<>();
        tilesNumber.add(new TileDTO(TileType.CLAY,4));
        tilesNumber.add(new TileDTO(TileType.SHEEP,4));
        tilesNumber.add(new TileDTO(TileType.WOOD,2));
        tilesNumber.add(new TileDTO(TileType.WHEAT,2));
        tilesNumber.add(new TileDTO(TileType.SHEEP,5));
        tilesNumber.add(new TileDTO(TileType.DESERT,4));
        tilesNumber.add(new TileDTO(TileType.ROCK,4));
        tilesNumber.add(new TileDTO(TileType.WOOD,2));
        tilesNumber.add(new TileDTO(TileType.WHEAT,2));
        tilesNumber.add(new TileDTO(TileType.ROCK,5));
        tilesNumber.add(new TileDTO(TileType.CLAY,4));
        tilesNumber.add(new TileDTO(TileType.WOOD,4));
        tilesNumber.add(new TileDTO(TileType.WOOD,2));
        tilesNumber.add(new TileDTO(TileType.WHEAT,2));
        tilesNumber.add(new TileDTO(TileType.SHEEP,5));
        tilesNumber.add(new TileDTO(TileType.CLAY,4));
        tilesNumber.add(new TileDTO(TileType.ROCK,4));
        tilesNumber.add(new TileDTO(TileType.SHEEP,2));
        tilesNumber.add(new TileDTO(TileType.WHEAT,2));

        board = new Board(tilesBitmaps,tilesNumber,10,10);

        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry) {
            try {
                thread.setRunning(false);
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            retry = false;
        }
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        tiledBackground.draw(canvas);
        board.draw(canvas);
        vulpixSprite.draw(canvas);
    }

    public void update() {
        vulpixSprite.update();
            }
}
