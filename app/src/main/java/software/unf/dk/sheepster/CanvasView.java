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
    Bitmap standardSheep;
    int sleepTime, velocity;
    boolean sheepPosNotSet;
    double angle;
    private float sheepPosX, sheepPosY, height, width;
    Paint textColor;
    public int count=0;
    private TextView clickCount;
    public String text = "0";


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
        if (sheepPosNotSet) {
            sheepPosX = width;
            sheepPosY = height - (height / 5) * 3;
            sheepPosNotSet = false;
        }


        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setTextSize(width/10);





     //   float rectX = width/3;    //position
        float rectY = height/5;
        float rectWidth = width/2.05f;
      //  int rectHeight = 20;
      //  float textWidth = paint.measureText(text);



        paint.setColor(Color.RED);
        canvas.drawText(text, rectWidth, rectY, paint);


        //Tegn ting. Se på de metoder Studio foreslår når i skriver variabelNavn.draw
        //Der skulle også stå nogenlunde gennemskueligt hvad parametrene skal være
        // canvas.drawRect(0, 0, width, height, sky);



        //Sæt billederne til den størrelse i vil have dem. Parametrene er det originale BitMap, bredden af det nye bitmap, højden af det nye bitmap, true.
        //Bredden og højden skal være i pixels
        standardSheep = Bitmap.createScaledBitmap(standardSheep, (int) width / 3, (int) height / 3, true);
        canvas.drawBitmap(standardSheep, sheepPosX, sheepPosY, null);


    }


 /*   @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        count++;
        text = "" + count;


        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            count++;
          //  text = "" + count;
           // clickCount.setText(text);
            text = "" + count;
            while(sheepPosX > (width/3)) {


                if (Y > sheepPosY && Y < sheepPosY + (height / 3) && X > sheepPosX && X < sheepPosX + (width / 3)) {
                    count++;
                    text = "" + count;
                    clickCount.setText(text);
                    text = "" + count;
                }
            }


        }
        //down, move, up
        postInvalidate();
        return true;
    }*/


    //public void calSheepPos(double time, double angle, int velocity){
    //    sheepPosX = width/2 - (float)(velocity* Math.cos(angle)*time);
    //    sheepPosY = height/2 - (float)((0-0.01)*time*time+velocity*Math.sin(angle));
    //}

    public class Timer extends Thread {
        @Override
        public void run() {

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
                //else if (sheepPosY > (height-(height/5)*3)+1){
                //  sheepPosX -= width/300;
                //}else if (sheepPosX < width/3){
                //  sheepPosX -= width/300;
                // }


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

