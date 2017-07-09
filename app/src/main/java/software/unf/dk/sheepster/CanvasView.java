package software.unf.dk.sheepster;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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


public class CanvasView extends View {
    //Feltvariabler
    Bitmap standardSheep, lifeOne, lifeTwo, lifeThree, notlifeOne, notlifeTwo, notlifeThree,sheepFence, sheep3;
    int sleepTime,widthDivideretSlut;
    boolean sheepPosNotSet, sheepPosNotSet2, alive, lvl2;
    double angle;
    private float sheepPosX, sheepPosY, sheepPosX2, sheepPosY2, sheepPosX3, sheepPosY3, height, width;
    private int selectedSkin;
    Paint textColor;
    boolean playing;
    boolean flerePoint, flerePoint2;
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
        sheepFence = BitmapFactory.decodeResource(this.getResources(), R.drawable.fence);
        sheep3 = BitmapFactory.decodeResource(this.getResources(), R.drawable.fancyforside);
        //Hente gemt skin

        SharedPreferences prefs2 = context.getSharedPreferences("prefs2", skinSelectorActivity.MODE_PRIVATE);
        selectedSkin = prefs2.getInt("SkinGemt", selectedSkin);

        if (selectedSkin == 1) {
            standardSheep = BitmapFactory.decodeResource(this.getResources(), R.drawable.blacksheep2);
        } else if (selectedSkin == 2) {
            standardSheep = BitmapFactory.decodeResource(this.getResources(), R.drawable.bluesheep2);
        } else if (selectedSkin == 3) {
            standardSheep = BitmapFactory.decodeResource(this.getResources(), R.drawable.brownsheep2);
        } else if (selectedSkin == 4) {
            standardSheep = BitmapFactory.decodeResource(this.getResources(), R.drawable.lightbluesheep2);
        } else if (selectedSkin == 5) {
            standardSheep = BitmapFactory.decodeResource(this.getResources(), R.drawable.pinksheep2);
        } else if (selectedSkin == 6) {
            standardSheep = BitmapFactory.decodeResource(this.getResources(), R.drawable.redcrosssheep2);
        } else if (selectedSkin == 7) {
            standardSheep = BitmapFactory.decodeResource(this.getResources(), R.drawable.trumpsheep2);
        } else if (selectedSkin == 8) {
            standardSheep = BitmapFactory.decodeResource(this.getResources(), R.drawable.yellowsheep2);
        } else if (selectedSkin == 9) {
            standardSheep = BitmapFactory.decodeResource(this.getResources(), R.drawable.doctorsheep2);
        } else if (selectedSkin == 10) {
            standardSheep = BitmapFactory.decodeResource(this.getResources(), R.drawable.greensheep2);
        } else if (selectedSkin == 11) {
            standardSheep = BitmapFactory.decodeResource(this.getResources(), R.drawable.darthsheep2);
        } else {
            standardSheep = BitmapFactory.decodeResource(this.getResources(), R.drawable.sheepstandard2);
        }

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
        flerePoint2 = true;
        widthDivideretSlut = widthDivideret;
        health = 3;
        alive = true;
        lvl2=lvl;
        playing = true;
        sleepTime = 20;
        sheepPosNotSet = true;
        sheepPosNotSet2 = true;
        postInvalidate();
        Timer animate = new Timer();
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
                sky.setARGB(255, 243, 155, 60);
                //Tegn ting. Se på de metoder Studio foreslår når i skriver variabelNavn.draw
                //Der skulle også stå nogenlunde gennemskueligt hvad parametrene skal være
                canvas.drawRect(0, 0, width, (height / 7) * 4, sky);
        //Tegn hegn


        if (sheepPosNotSet) {
            standardSheep = Bitmap.createScaledBitmap(standardSheep, (int) (width / 3)+1, (int) (height / 3)+1, true);
            sheepFence = Bitmap.createScaledBitmap(sheepFence, (int) (width / 3)+1, (int) (height / 3)+1, true);
            sheep3 = Bitmap.createScaledBitmap(sheep3, (int) (width / 3)+1, (int) (height / 3)+1, true);
            sheepPosX = width;
            sheepPosY = height - (height / 5) * 3;
            sheepPosY3 = width;
            sheepPosX3 = height - (height /5) /4;
            sheepPosNotSet = false;
        }

        if (sheepPosNotSet2) {
            sheepFence = Bitmap.createScaledBitmap(sheepFence, (int) (width / 3)+1, (int) (height / 3)+1, true);
            sheepPosX2 = width;
            sheepPosY2 = height - (height / 5) * 2;

            sheepPosNotSet2 = false;
        }
        if (lvl2) {
            lifeOne = Bitmap.createScaledBitmap(lifeOne, (int) (width/6), (int) (width / 6), true);
            lifeTwo = Bitmap.createScaledBitmap(lifeTwo, (int) (width/6), (int) (width / 6), true);
            lifeThree = Bitmap.createScaledBitmap(lifeThree, (int) (width/6), (int) (width / 6), true);

            notlifeOne = Bitmap.createScaledBitmap(notlifeOne, (int) (width/6), (int) (width / 6), true);
            notlifeTwo = Bitmap.createScaledBitmap(notlifeTwo, (int) (width/6), (int) (width / 6), true);
            notlifeThree = Bitmap.createScaledBitmap(notlifeThree, (int) (width/6), (int) (width / 6), true);

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
        canvas.drawBitmap(sheepFence, sheepPosX2, sheepPosY2, null);
        canvas.drawBitmap(sheep3, sheepPosX3, sheepPosY3, null);
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

    public boolean getFlerePoint2(){
        return flerePoint2;
    }

    public void setFlerePoint2 (boolean point2){
        flerePoint = point2;
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

                while (sheepPosX > -width / 3 || (lvl2 && (sheepPosX2 > -width / 3 || sheepPosX3 > -width /3))) {
                    try {
                        Thread.sleep(sleepTime);
                    } catch (InterruptedException e) {
                        //Nothing
                    }
                    if (sheepPosX > -width /3) {
                        sheepPosX -= width / widthDivideretSlut;
                        sheepPosY = (((-4f * ((-height * 2) / (width * width)) * 1) / 3) * (sheepPosX * sheepPosX)) + (((-height * 2) / width) * sheepPosX) + (height / 2);
                    }

                    if(lvl2){

                        if (sheepPosX2 > -width /3) {
                            sheepPosX2 -= width / widthDivideretSlut;
                            sheepPosY2 = (((-4f * ((-height * 2) / (width * width)) * 1) / 3) * (sheepPosX2 * sheepPosX2)) + (((-height * 2) / width) * sheepPosX2) + (height / 2);
                        }

                        if (sheepPosX3 > -width /3) {
                            sheepPosX3 -= width / widthDivideretSlut;
                            sheepPosY3 = (((-4f * ((-height * 2) / (width * width)) * 1) / 3) * (sheepPosX3 * sheepPosX3)) + (((-height * 2) / width) * sheepPosX3) + (height / 2);
                        }

                    }

                    postInvalidate();
                }

                if (flerePoint && lvl2) {
                    health--;
                            if (health == 0) {
                                alive = false;
                                playing = false;
                            }
                }
                if (flerePoint2 && lvl2) {
                    health--;
                    if (health == 0) {
                        alive = false;
                        playing = false;
                    }
                }
                sheepPosX = 0;
                sheepPosX2 = 0;
                flerePoint = true;
                flerePoint2 = true;
                sheepPosNotSet = true;
                sheepPosNotSet2 = true;
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

    public float getSheepPosX2(){
        return sheepPosX2;
    }

    public float getSheepPosY2(){
        return sheepPosY2;
    }

    public float getSheepPosX3(){
        return sheepPosX3;
    }

    public float getSheepPosY3(){
        return sheepPosY3;
    }
}

