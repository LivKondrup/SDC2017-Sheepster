package software.unf.dk.sheepster;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class lvl2Activty extends MainActivity {

    private TextView clickCount2;
    private CanvasView lvl2Sheep;
    private ImageView fence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lvl2);
        clickCount2 = findViewById(R.id.countlvl2);
        life = 3;
        lvl2Sheep = (CanvasView) findViewById(R.id.lvl1Sheep);
        fence = (ImageView) findViewById(R.id.fence);

    }

    public void sheepCountButton2 (View view){
        count2++;
        String count3 = "" + count2;
        clickCount2.setText(count3);
        lvl2Sheep.animation();
    }

    public void backButton2(View view) {
        finish();
    }

}
