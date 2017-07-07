package software.unf.dk.sheepster;

import android.os.Bundle;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lvl2);
        clickCount2 = findViewById(R.id.countlvl2);
        life = 3;
        lvl2Sheep = (CanvasView) findViewById(R.id.lvl2Sheep);
        fence2 = (ImageView) findViewById(R.id.fence2);

    }

    public void sheepCountButton2 (View view){
        count3++;
        count4 = "" + count3;
        clickCount2.setText(count4);
        lvl2Sheep.animation();
    }

    public void backButton2(View view) {
        finish();
    }

    // Highscore + Gameover + return to mainActivity
    public void hiscoreToMain (){
            Intent hiscoreIntent = new Intent(this, MainActivity.class);
            hiscoreIntent.putExtra("Highscore", count4);
            startActivity(hiscoreIntent);
    }



}
