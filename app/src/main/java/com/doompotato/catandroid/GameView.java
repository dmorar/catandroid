package com.doompotato.catandroid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

/**
 * Created by dmorard on 9/2/2018.
 */

class GameView extends SurfaceView implements SurfaceHolder.Callback{

    private MainThread thread;
    private CharacterSprite characterSprite;
    private TiledBackground tiledBackground;


    public GameView(Context context) {
        super(context);
        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);
        setFocusable(true);
    }
    public Bitmap getResizedBitmap(Bitmap bm, int newHeight, int newWidth)
    {
        int width = bm.getWidth();
        int height = bm.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
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
        characterSprite.moveToPosition(event.getX(),event.getY());
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
//        characterSprite = new CharacterSprite(getResizedBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.vulpix),200,200),100,100);
//        tiledBackground = new TiledBackground(getResizedBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.grass),200,200));
        characterSprite = new CharacterSprite(BitmapFactory.decodeResource(getResources(),R.drawable.vulpix),200,200);
        tiledBackground = new TiledBackground(BitmapFactory.decodeResource(getResources(),R.drawable.grass));
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
        characterSprite.draw(canvas);
    }

    public void update() {
        characterSprite.update();
            }
}
