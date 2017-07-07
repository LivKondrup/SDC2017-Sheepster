package software.unf.dk.sheepster;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
    public int count=0;
    public int count2;
    public String highscore="0";
    public int life;
    public TextView highScoreTextView;

    CanvasView cv;
    CanvasView cv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //cv = (CanvasView) findViewById(R.id.canvasView);

        Intent hiscoreIntentString = getIntent();
        highscore = hiscoreIntentString.getStringExtra("Highscore");
        highScoreTextView = (TextView) findViewById(R.id.highscoreTextView);
        highScoreTextView.setText(highscore);



    }

    //Knappen kalder denne metode, som kalder metoden i CanvasView. I kan ikke få knapper til direkte at kalde metoder i jeres View
    public void animation(View view) {
        cv.animation();
    }
    public void animation2(View view) {
        cv2.animation();
    }


    public void tolvl1(View view) {
        Intent lvl1Intent = new Intent(this, lvl1Activity.class);
        startActivity(lvl1Intent);
    }

    public void tolvl2(View view) {
        Intent lvl2Intent = new Intent(this, lvl2Activty.class);
        startActivity(lvl2Intent);
    }

    public void skinselector (View view){
        Intent skinselectorIntent = new Intent (this, skinSelectorActivity.class);
        startActivity(skinselectorIntent);
    }



}
