package software.unf.dk.sheepster;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class lvl1Activity extends MainActivity {

    private ImageView fence;
    private TextView clickCount,clickMeText;
    private CanvasView lvl1Sheep;
    private Paint sky;       // hvorfor er denne variabel oprettet, dette er det eneste sted den står?
    String nothing;
    private int selectedSkin;

    //Bitmap darthSheep;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lvl1);

        SharedPreferences prefs2 = getSharedPreferences("prefs2", skinSelectorActivity.MODE_PRIVATE);
        selectedSkin = prefs2.getInt("SkinGemt", selectedSkin);

        clickCount = findViewById(R.id.clickCount);
        clickMeText = findViewById(R.id.clickSheep2TextView);
        lvl1Sheep = (CanvasView) findViewById(R.id.lvl1Sheep);
        fence = (ImageView) findViewById(R.id.fence);

        final MediaPlayer mp;
        if(selectedSkin == 11){
            mp = MediaPlayer.create(this, R.raw.lightsaber);
        } else if(selectedSkin == 3) {
            mp = MediaPlayer.create(this, R.raw.poop);
        } else if(selectedSkin == 7) {
            mp = MediaPlayer.create(this, R.raw.trump);
        } else {
            mp = MediaPlayer.create(this, R.raw.sheepsound);
        }

        lvl1Sheep.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                float sheepPosX = lvl1Sheep.getSheepPosX();
                float sheepPosY = lvl1Sheep.getSheepPosY();
                float height = view.getHeight();
                float width = view.getWidth();
                float X = motionEvent.getX();
                float Y = motionEvent.getY();

                if (X > sheepPosX && X < sheepPosX + width / 3 && Y > sheepPosY && Y < sheepPosY + height / 3 && lvl1Sheep.getFlerePoint()) {
                    count++;
                    String count2 = "Sheep: " + count;
                    clickCount.setText(count2);
                    nothing = "";
                    clickMeText.setText(nothing);
                    lvl1Sheep.setFlerePoint(false);
                    mp.start();
                }



                //if(count==sheepTotal()){
                //    count= count-1;
                //}
                /*

                if (bcount==true) {
                    if (X > sheepPosX && X < sheepPosX + width / 3 && Y > sheepPosY && Y < sheepPosY + height / 3) {
                        count++;
                        String count2 = "" + count;
                        clickCount.setText(count2);
                        bcount = false;
                    }


                }*/
                lvl1Sheep.abc(count);
                return false;
            }


        });

        lvl1Sheep.animation(false,300);
    }



    public void backButton(View view) {
        lvl1Sheep.setPlaying(false);
        finish();
    }




}

