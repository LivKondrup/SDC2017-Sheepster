package software.unf.dk.sheepster;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by deltager on 06-07-17.
 */

public class CanvasView extends View {

    //Feltvariabler
    Bitmap standardSheep;
    int sheepPosX, height, width;
    boolean sheepPosNotSet;
    //Paint text, sky;


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
    }

    public void animation(){
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
            sheepPosNotSet = false;
        }


            //Sæt billederne til den størrelse i vil have dem. Parametrene er det originale BitMap, bredden af det nye bitmap, højden af det nye bitmap, true.
        //Bredden og højden skal være i pixels
        standardSheep = Bitmap.createScaledBitmap(standardSheep, width/10, height/10, true);

        canvas.drawBitmap(standardSheep, sheepPosX, height/4, null);



    }

    public class Timer extends Thread {
        @Override
        public void run() {

            while(sheepPosX > 0){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    //Nothing
                }

                sheepPosX -= width/100;
                postInvalidate();
            }

        }
    }
}
