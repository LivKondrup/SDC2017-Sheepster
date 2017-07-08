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



                if (bcount==true) {
                    if (X > sheepPosX && X < sheepPosX + width / 3 && Y > sheepPosY && Y < sheepPosY + height / 3) {
                        count++;
                        String count2 = "" + count;
                        clickCount.setText(count2);
                        bcount = false;
                    }


                }
                return false;
            }


        });
        boolean flerePoint = lvl1Sheep.getFlerePoint();
        lvl1Sheep.animation();
        bcount=flerePoint;



    }



    public void backButton(View view) {
        lvl1Sheep.setPlaying(false);
        finish();
    }




}

