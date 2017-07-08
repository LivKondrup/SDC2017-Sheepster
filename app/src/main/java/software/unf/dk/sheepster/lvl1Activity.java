package software.unf.dk.sheepster;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class lvl1Activity extends MainActivity {

    private ImageView fence;
    private TextView clickCount;
    private CanvasView lvl1Sheep;
    private Paint sky;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lvl1);
      //  clickCount = findViewById(R.id.countlvl1);
        lvl1Sheep = (CanvasView) findViewById(R.id.lvl1Sheep);
        fence = (ImageView) findViewById(R.id.fence);
        sky = new Paint();
        sky.setARGB(255, 115, 195, 62);
    }

    public void setCount(int count1){
        count = count1;
    }

    public void backButton(View view) {
        finish();
    }

    public void sheepCountButton (View view){
       // count++;
      //  String count2 = "" + count;
      //  clickCount.setText(count2);
        lvl1Sheep.animation();



    }
}

