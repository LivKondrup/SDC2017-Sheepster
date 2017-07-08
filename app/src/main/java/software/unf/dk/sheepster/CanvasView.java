package software.unf.dk.sheepster;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by deltager on 06-07-17.
 */

public class CanvasView extends View {

    //Feltvariabler
    Bitmap standardSheep;
    int sleepTime, velocity;
    boolean sheepPosNotSet;
    double angle;
    private float sheepPosX, sheepPosY, height, width;
    Paint sky;


    public CanvasView(Context context) {
        super(context);
        setup();
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup();
    }

    public void setup(){
        //Constructor
        standardSheep = BitmapFactory.decodeResource(this.getResources(),R.drawable.sheepstandard);
        sheepPosNotSet = true;
        angle = 1.3;
        velocity = 150;

        //Sæt paint. Altså farver (og tekststørrelse) som bruges til at tegne
        sky = new Paint();
        sky.setARGB(255,115,195,62);
        //Kan også bruge variabelNavn.setARGB(). A er gennemsigtigheden, R er rød, G er grøn og B er blå.
        //Brug den til at lave mere præcise farver.
        postInvalidate();
    }

    public void animation(){
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
        if(sheepPosNotSet){
            sheepPosX = width;
            sheepPosY = height-(height/5)*3;
            sheepPosNotSet = false;
        }
        //Tegn ting. Se på de metoder Studio foreslår når i skriver variabelNavn.draw
        //Der skulle også stå nogenlunde gennemskueligt hvad parametrene skal være
        canvas.drawRect(0, 0, width, height, sky);


            //Sæt billederne til den størrelse i vil have dem. Parametrene er det originale BitMap, bredden af det nye bitmap, højden af det nye bitmap, true.
        //Bredden og højden skal være i pixels
        standardSheep = Bitmap.createScaledBitmap(standardSheep, (int) width/3, (int) height/3, true);
        canvas.drawBitmap(standardSheep, sheepPosX, sheepPosY, null);



    }

    //public void calSheepPos(double time, double angle, int velocity){
    //    sheepPosX = width/2 - (float)(velocity* Math.cos(angle)*time);
    //    sheepPosY = height/2 - (float)((0-0.01)*time*time+velocity*Math.sin(angle));
    //}

    public class Timer extends Thread {
        @Override
        public void run() {

            while(sheepPosX > -width/3){
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    //Nothing
                }
                if (sheepPosX > 2*width/3){
                    sheepPosX -= width/300;
                } else if (sheepPosX < 2*width/3){
                    sheepPosX -= width/300;
                    sheepPosY = (((-4f * ((-height * 2) / (width * width)) * 1) / 3) * (sheepPosX * sheepPosX)) + (((-height * 2) / width) * sheepPosX) + (height / 2);

                }
                //else if (sheepPosY > (height-(height/5)*3)+1){
                  //  sheepPosX -= width/300;
                }//else if (sheepPosX < width/3){
                  //  sheepPosX -= width/300;
               // }



                postInvalidate();


            }


        }
    }

