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
import android.view.View;

/**
 * Created by deltager on 06-07-17.
 */

public class CanvasView2 extends View {

    //Feltvariabler
    Bitmap standardSheep2;
    int sheepPosX2, height2, width2, sleepTime2;
    boolean sheepPosNotSet2;
    Paint sky2;


    public CanvasView2(Context context) {
        super(context);
        setup2();
    }

    public CanvasView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setup2();
    }

    public CanvasView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup2();
    }

    public void setup2(){
        //Constructor
        standardSheep2 = BitmapFactory.decodeResource(this.getResources(),R.drawable.sheepstandard2);
        sheepPosNotSet2 = true;

        //Sæt paint. Altså farver (og tekststørrelse) som bruges til at tegne
        sky2 = new Paint();
        sky2.setARGB(255,115,195,62);
        //Kan også bruge variabelNavn.setARGB(). A er gennemsigtigheden, R er rød, G er grøn og B er blå.
        //Brug den til at lave mere præcise farver.
    }

    public void animation2(){
        sleepTime2 = 10;
        Timer2 animate = new Timer2();
        sheepPosNotSet2 = true;
        postInvalidate();
        animate.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //Få fat i højden og bredde af jeres View. I pixels
        height2 = canvas.getHeight();
        width2 = canvas.getWidth();
        if(sheepPosNotSet2){
            sheepPosX2 = width2;
            sheepPosNotSet2 = false;
        }
        //Tegn ting. Se på de metoder Studio foreslår når i skriver variabelNavn.draw
        //Der skulle også stå nogenlunde gennemskueligt hvad parametrene skal være
        canvas.drawRect(0, 0, width2, height2, sky2);


        //Sæt billederne til den størrelse i vil have dem. Parametrene er det originale BitMap, bredden af det nye bitmap, højden af det nye bitmap, true.
        //Bredden og højden skal være i pixels
        standardSheep2 = Bitmap.createScaledBitmap(standardSheep2, width2/3, height2/3, true);

        canvas.drawBitmap(standardSheep2, sheepPosX2, height2/2, null);



    }

    public class Timer2 extends Thread {
        @Override
        public void run() {

            while(sheepPosX2 > -width2/3){
                try {
                    Thread.sleep(sleepTime2);
                } catch (InterruptedException e) {
                    //Nothing
                }

                sheepPosX2 -= width2/300;
                postInvalidate();
            }

        }
    }
}
