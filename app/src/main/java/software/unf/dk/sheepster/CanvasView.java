package software.unf.dk.sheepster;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by deltager on 06-07-17.
 */


public class CanvasView extends View {

    //Feltvariabler
    Bitmap standardSheep, lifeOne, lifeTwo, lifeThree, notlifeOne, notlifeTwo, notlifeThree;
    int sleepTime,widthDivideretSlut;
    boolean sheepPosNotSet, alive, lvl2;
    double angle;
    private float sheepPosX, sheepPosY, height, width;
    Paint textColor;
    boolean playing;
    boolean flerePoint;
     public int health;

    public CanvasView(Context context) {
        super(context);
        setup(context);
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setup(context);
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup(context);
    }

    public void setup(Context context) {
        //Constructor
        standardSheep = BitmapFactory.decodeResource(this.getResources(), R.drawable.sheepstandard);

        //Creating Bitmaps for Lives (ImageViews)
        lifeOne = BitmapFactory.decodeResource(this.getResources(), R.drawable.life);
        lifeTwo = BitmapFactory.decodeResource(this.getResources(), R.drawable.life);
        lifeThree = BitmapFactory.decodeResource(this.getResources(), R.drawable.life);

        notlifeOne = BitmapFactory.decodeResource(this.getResources(), R.drawable.notlife);
        notlifeTwo = BitmapFactory.decodeResource(this.getResources(), R.drawable.notlife);
        notlifeThree = BitmapFactory.decodeResource(this.getResources(), R.drawable.notlife);


        //Sæt paint. Altså farver (og tekststørrelse) som bruges til at tegne
        textColor= new Paint();
        textColor.setARGB(255, 0, 0, 0);
        //Kan også bruge variabelNavn.setARGB(). A er gennemsigtigheden, R er rød, G er grøn og B er blå.
        //Brug den til at lave mere præcise farver.
    }


    public void animation(boolean lvl,int widthDivideret) {
        flerePoint = true;
        widthDivideretSlut = widthDivideret;
        health = 3;
        alive = true;
        lvl2=lvl;
        playing = true;
        sleepTime = 20;
        Timer animate = new Timer();
        sheepPosNotSet = true;
        postInvalidate();
        animate.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //Få fat i højden og bredde af jeres View. I pixels
        height = canvas.getHeight();
        width = canvas.getWidth();

        //Funktion to make green background, MANGLER AT GØRE TIL REKTANGLER
            Paint grass;
                grass= new Paint();
                grass.setARGB(255, 115, 195, 62);
                //Tegn ting. Se på de metoder Studio foreslår når i skriver variabelNavn.draw
                //Der skulle også stå nogenlunde gennemskueligt hvad parametrene skal være
                canvas.drawRect(0,0, width, height, grass);

        //Funktion to make blue background, MANGLER AT GØRE TIL REKTANGLER
                Paint sky;
                sky = new Paint();
                sky.setARGB(255, 51, 181, 241);
                //Tegn ting. Se på de metoder Studio foreslår når i skriver variabelNavn.draw
                //Der skulle også stå nogenlunde gennemskueligt hvad parametrene skal være
                canvas.drawRect(0, 0, width, (height / 7) * 4, sky);
        //Tegn hegn


        if (sheepPosNotSet) {
            standardSheep = Bitmap.createScaledBitmap(standardSheep, (int) (width / 3)+1, (int) (height / 3)+1, true);
            sheepPosX = width;
            sheepPosY = height - (height / 5) * 3;
            sheepPosNotSet = false;
        }
        if (lvl2) {
            if (health == 3) {
                canvas.drawBitmap(lifeOne, 5, 5, null);
                canvas.drawBitmap(lifeTwo, 105, 5, null);
                canvas.drawBitmap(lifeThree, 205, 5, null);

            } else if (health == 2) {
                canvas.drawBitmap(lifeOne, 5, 5, null);
                canvas.drawBitmap(lifeTwo, 105, 5, null);
                canvas.drawBitmap(notlifeThree, 205, 5, null);
            } else {
                canvas.drawBitmap(lifeOne, 5, 5, null);
                canvas.drawBitmap(notlifeTwo, 105, 5, null);
                canvas.drawBitmap(notlifeThree, 205, 5, null);
            }
        }


        float rectY = height/5;
        float rectWidth = width/2.05f;



        //Tegn ting. Se på de metoder Studio foreslår når i skriver variabelNavn.draw
        //Der skulle også stå nogenlunde gennemskueligt hvad parametrene skal være


        //Sæt billederne til den størrelse i vil have dem. Parametrene er det originale BitMap, bredden af det nye bitmap, højden af det nye bitmap, true.
        //Bredden og højden skal være i pixels

        canvas.drawBitmap(standardSheep, sheepPosX, sheepPosY, null);
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public boolean getAlive(){
        return alive;
    }

    public boolean getFlerePoint(){
        return flerePoint;
    }

    public void setFlerePoint(boolean point){
        flerePoint = point;
    }

    public class Timer extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                //Nothing
            }
            while(playing) {
                while (sheepPosX > -width / 3) {
                    try {
                        Thread.sleep(sleepTime);
                    } catch (InterruptedException e) {
                        //Nothing
                    }
                    if (sheepPosX > 2 * width / 3) {
                        sheepPosX -= width / widthDivideretSlut;
                    } else if (sheepPosX < 2 * width / 3) {
                        sheepPosX -= width / widthDivideretSlut;
                        sheepPosY = (((-4f * ((-height * 2) / (width * width)) * 1) / 3) * (sheepPosX * sheepPosX)) + (((-height * 2) / width) * sheepPosX) + (height / 2);

                    }

                    postInvalidate();


                }

                if (flerePoint) {
                    health--;
                            if (health == 0) {
                                alive = false;
                            }
                }
                sheepPosX = 0;
                flerePoint = true;
                sheepPosNotSet = true;
                postInvalidate();
            }



        }
    }

    public float getSheepPosX(){
        return sheepPosX;
    }

    public  float getSheepPosY(){
        return sheepPosY;
    }
}

