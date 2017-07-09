package software.unf.dk.sheepster;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
    public String count4;
    public String count5;
    private int antalLiv=3;
    private int highscoreGemt1;
    public static String highscoreGemt = "highscoreGemt";
    private TextView highscoreLvl2;
    Bitmap lost1life;
    Bitmap lost2Life;
    private  ImageView thirdLife;
    private  ImageView secondLife;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lvl2);

        /*thirdLife = (ImageView) findViewById(R.id.firsLifeImageView);
        thirdLife = BitmapFactory.decodeResource(this.getResources(), R.drawable.life);

        secondLife = (ImageView) findViewById(R.id.secondLifeImageView);
        highscoreLvl2.setText(highscoreGemt);*/

        //Hente gemt highscore
        SharedPreferences prefs = getSharedPreferences("prefs", lvl2Activty.MODE_PRIVATE);
        highscoreGemt1 = prefs.getInt("HighscoreGemt", highscoreGemt1);

        clickCount2 = findViewById(R.id.countlvl2);
        life = 3;
        lvl2Sheep = (CanvasView) findViewById(R.id.lvl2Sheep);
        fence2 = (ImageView) findViewById(R.id.fence2);

        String highscoreGemt = "" + highscoreGemt1;

        highscoreLvl2 = (TextView) findViewById(R.id.highscoreLvl2);
        highscoreLvl2.setText("Highscore: " + highscoreGemt);

        lvl2Sheep.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                float sheepPosX = lvl2Sheep.getSheepPosX();
                float sheepPosY = lvl2Sheep.getSheepPosY();
                float height = view.getHeight();
                float width = view.getWidth();
                float X = motionEvent.getX();
                float Y = motionEvent.getY();

                if (X > sheepPosX && X < sheepPosX + width / 3 && Y > sheepPosY && Y < sheepPosY + height / 3 && lvl2Sheep.getFlerePoint()) {
                    count++;
                    String count2 = "" + count;
                    clickCount2.setText(count2);
                    lvl2Sheep.setFlerePoint(false);
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
                return false;
            }


        });

        lvl2Sheep.animation(true,100);
        new TjecAlive().start();
    }




    /*public void looseOneLife(View view){

        if (antalLiv == 3){
            lost1life = BitmapFactory.decodeResource(this.getResources(), R.drawable.notlife);

            lost1life.setImageBitmap(lost1life);
        } else if (antalLiv == 2){
            darthSheep = BitmapFactory.decodeResource(this.getResources(), R.drawable.darthsheep);

            fence.setImageBitmap(darthSheep);
        } else {
            hiscoreToMain(View view);
        }

    }*/

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
            startActivity(hiscoreIntentString);
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
