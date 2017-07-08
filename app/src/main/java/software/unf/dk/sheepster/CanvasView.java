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
    Bitmap standardSheep, skyBackground, grassBackground;
    int sleepTime, velocity;
    boolean sheepPosNotSet;
    double angle;
    private float sheepPosX, sheepPosY, height, width;
    Paint textColor;
    public int count=0;
    private TextView clickCount;
    public String text = "0";
    boolean playing;
    boolean flerePoint;

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
        sheepPosNotSet = true;
        //Sæt paint. Altså farver (og tekststørrelse) som bruges til at tegne

        textColor= new Paint();
        textColor.setARGB(255, 0, 0, 0);
        //Kan også bruge variabelNavn.setARGB(). A er gennemsigtigheden, R er rød, G er grøn og B er blå.
        //Brug den til at lave mere præcise farver.
        postInvalidate();
    }

    public void animation() {
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


        if (sheepPosNotSet) {
            standardSheep = Bitmap.createScaledBitmap(standardSheep, (int) (width / 3)+1, (int) (height / 3)+1, true);
            sheepPosX = width;
            sheepPosY = height - (height / 5) * 3;
            sheepPosNotSet = false;
        }


        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setTextSize(width/10);


        float rectY = height/5;
        float rectWidth = width/2.05f;

        paint.setColor(Color.RED);
        canvas.drawText(text, rectWidth, rectY, paint);


        //Tegn ting. Se på de metoder Studio foreslår når i skriver variabelNavn.draw
        //Der skulle også stå nogenlunde gennemskueligt hvad parametrene skal være


        //Sæt billederne til den størrelse i vil have dem. Parametrene er det originale BitMap, bredden af det nye bitmap, højden af det nye bitmap, true.
        //Bredden og højden skal være i pixels

        canvas.drawBitmap(standardSheep, sheepPosX, sheepPosY, null);
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public class Timer extends Thread {
        @Override
        public void run() {
            while(playing) {
                while (sheepPosX > -width / 3) {
                    try {
                        Thread.sleep(sleepTime);
                    } catch (InterruptedException e) {
                        //Nothing
                    }
                    if (sheepPosX > 2 * width / 3) {
                        sheepPosX -= width / 300;
                    } else if (sheepPosX < 2 * width / 3) {
                        sheepPosX -= width / 300;
                        sheepPosY = (((-4f * ((-height * 2) / (width * width)) * 1) / 3) * (sheepPosX * sheepPosX)) + (((-height * 2) / width) * sheepPosX) + (height / 2);

                    }

                    postInvalidate();


                }

                sheepPosNotSet = true;
                flerePoint = true;
            }



        }
    }

    public float getSheepPosX(){
        return sheepPosX;
    }

    public  float getSheepPosY(){
        return sheepPosY;
    }

    public boolean getFlerePoint(){
        return flerePoint;
    }

}

