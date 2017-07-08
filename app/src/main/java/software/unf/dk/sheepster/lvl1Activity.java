package software.unf.dk.sheepster;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class lvl1Activity extends MainActivity {

    private ImageView fence;
    private TextView clickCount;
    private CanvasView lvl1Sheep;
    private Paint sky;
    public boolean bcount = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lvl1);
        clickCount = findViewById(R.id.clickCount);
        lvl1Sheep = (CanvasView) findViewById(R.id.lvl1Sheep);
        fence = (ImageView) findViewById(R.id.fence);




        lvl1Sheep.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                float sheepPosX = lvl1Sheep.getSheepPosX();
                float sheepPosY = lvl1Sheep.getSheepPosY();
                float height = view.getHeight();
                float width = view.getWidth();
                float X = motionEvent.getX();
                float Y = motionEvent.getY();



                /*while (bcount==true) {
                    if (X > sheepPosX && X < sheepPosX + width / 3 && Y > sheepPosY && Y < sheepPosY + height / 3) {
                        count++;
                     String count2 = "" + count;
                     clickCount.setText(count2);
                        bcount = false;
                    }


                }
                while(bcount==false) {  Dette while loop forårsager et crash.
                    if ((sheepPosX > 0 && sheepPosX < width/3) || (sheepPosX > width-(width/3) && sheepPosX < width )) { Vi formoder det har noget at gøre med intervallet på denne linje.
                        bcount = true;
                    }
                }
                */
              //  while (sheepPosX <= 0){
               //     bcount = true;
                   // boolean flerePoint = lvl1Sheep.getFlerePoint();
                  //  bcount = flerePoint;

               // }

                return false;


            }


        });

        lvl1Sheep.animation();

    }



    public void backButton(View view) {
        lvl1Sheep.setPlaying(false);
        finish();
    }




}

