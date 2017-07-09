package software.unf.dk.sheepster;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

public class lvl2Activty extends MainActivity {

    private TextView clickCount2;
    private CanvasView lvl2Sheep;
    private ImageView fence2;
    private int count3;
    public String nothing2;
    public String count5;
    private int antalLiv=3;
    private int highscoreGemt1, selectedSkin;
    public static String highscoreGemt = "highscoreGemt";
    private TextView highscoreLvl2, clickMeText2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lvl2);

        SharedPreferences prefs2 = getSharedPreferences("prefs2", skinSelectorActivity.MODE_PRIVATE);
        selectedSkin = prefs2.getInt("SkinGemt", selectedSkin);

        //Hente gemt highscore
        SharedPreferences prefs = getSharedPreferences("prefs", lvl2Activty.MODE_PRIVATE);
        highscoreGemt1 = prefs.getInt("HighscoreGemt", highscoreGemt1);
        final MediaPlayer mp1;
        if(selectedSkin == 11){
            mp1 = MediaPlayer.create(this, R.raw.lightsaber);}
                else if (selectedSkin == 3) {
                mp1 = MediaPlayer.create(this, R.raw.poop);
            } else if (selectedSkin == 7) {
                mp1 = MediaPlayer.create(this, R.raw.trump);
            } else {
                mp1 = MediaPlayer.create(this, R.raw.sheepsound);
            }

        final MediaPlayer mp2;
        if(selectedSkin == 11){
            mp2 = MediaPlayer.create(this, R.raw.lightsaber);}
        else if (selectedSkin == 3) {
            mp2 = MediaPlayer.create(this, R.raw.poop);
        } else if (selectedSkin == 7) {
            mp2 = MediaPlayer.create(this, R.raw.trump);
        } else {
            mp2 = MediaPlayer.create(this, R.raw.sheepsound);
        }

        final MediaPlayer mp3;
        if(selectedSkin == 11){
            mp3 = MediaPlayer.create(this, R.raw.lightsaber);}
        else if (selectedSkin == 3) {
            mp3 = MediaPlayer.create(this, R.raw.poop);
        } else if (selectedSkin == 7) {
            mp3 = MediaPlayer.create(this, R.raw.trump);
        } else {
            mp3 = MediaPlayer.create(this, R.raw.sheepsound);
        }

        clickCount2 = findViewById(R.id.countlvl2);
        count3 = 0;
        life = 3;
        lvl2Sheep = (CanvasView) findViewById(R.id.lvl2Sheep);
        fence2 = (ImageView) findViewById(R.id.fence2);

        clickMeText2 = findViewById(R.id.clickSheepTextView2);

        String highscoreGemt = "" + highscoreGemt1;

        highscoreLvl2 = (TextView) findViewById(R.id.highscoreLvl2);
        highscoreLvl2.setText("Highscore: " + highscoreGemt);

        lvl2Sheep.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                float sheepPosX = lvl2Sheep.getSheepPosX();
                float sheepPosY = lvl2Sheep.getSheepPosY();
                float sheepPosX2 =lvl2Sheep.getSheepPosX2();
                float sheepPosY2 = lvl2Sheep.getSheepPosY2();
                float sheepPosX3 =lvl2Sheep.getSheepPosX3();
                float sheepPosY3 = lvl2Sheep.getSheepPosY3();

                float height = view.getHeight();
                float width = view.getWidth();
                float X = motionEvent.getX();
                float Y = motionEvent.getY();

                if (X > sheepPosX && X < sheepPosX + width / 3 && Y > sheepPosY && Y < sheepPosY + height / 3 && lvl2Sheep.getFlerePoint()) {
                    count++;
                    String count2 = "Sheep: " + count;
                    clickCount2.setText(count2);
                    nothing2 = "";
                    clickMeText2.setText(nothing2);
                    lvl2Sheep.setFlerePoint(false);
                    mp1.start();
                }

                if (X > sheepPosX2 && X < sheepPosX2 + width / 3 && Y > sheepPosY2 && Y < sheepPosY2 + height / 3 && lvl2Sheep.getFlerePoint2()) {
                    count++;
                    String count2 = "Sheep: " + count;
                    clickCount2.setText(count2);
                    nothing2 = "";
                    clickMeText2.setText(nothing2);
                    lvl2Sheep.setFlerePoint2(false);
                    mp2.start();
                }



                if (X > sheepPosX3 && X < sheepPosX3 + width / 3 && Y > sheepPosY3 && Y < sheepPosY3 + height / 3 && lvl2Sheep.getFlerePoint3()) {
                    count++;
                    String count2 = "Sheep: " + count;
                    clickCount2.setText(count2);
                    nothing2 = "";
                    clickMeText2.setText(nothing2);
                    lvl2Sheep.setFlerePoint3(false);
                    mp3.start();
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
                lvl2Sheep.abc(count);
                return false;
            }


        });

        lvl2Sheep.animation(true,250);
        new TjecAlive().start();
    }

    public void backButton2(View view) {
        finish();
    }


    // Highscore + Gameover + return to mainActivity
    public void hiscoreToMain(){
        Intent hiscoreIntentString = new Intent(this, MainActivity.class);
        SharedPreferences prefs = getSharedPreferences("prefs", lvl2Activty.MODE_PRIVATE);
        highscoreGemt1 = prefs.getInt("HighscoreGemt", highscoreGemt1);
            if (count>highscoreGemt1) {
                highscoreGemt1 = count;
                count5 = "" + highscoreGemt1;
                hiscoreIntentString.putExtra("Highscore", count5);
            } else {
            highscoreGemt = "" + highscoreGemt1;
            hiscoreIntentString.putExtra("Highscore", highscoreGemt);
            }

            //Sende highscore
            SharedPreferences sp = getSharedPreferences("prefs", Activity.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putInt("HighscoreGemt", highscoreGemt1);
            editor.commit();

            //Skif Activity til MainActivity
            finish();
    }

    public class TjecAlive extends Thread{
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {

            }
            while (lvl2Sheep.getAlive()){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
            }
            hiscoreToMain();
        }
    }
}
