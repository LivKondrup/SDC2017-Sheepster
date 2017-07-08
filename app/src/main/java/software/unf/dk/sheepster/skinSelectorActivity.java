package software.unf.dk.sheepster;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class skinSelectorActivity extends Activity {

    private int highscoreGemt1;
    private TextView highscoreTextview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.skinselector);

        //Hente gemt highscore
        SharedPreferences prefs = getSharedPreferences("prefs", lvl2Activty.MODE_PRIVATE);
        highscoreGemt1 = prefs.getInt("HighscoreGemt", highscoreGemt1);

        //Opdater TextView
        highscoreTextview = (TextView) findViewById(R.id.skinSelectorHighscoreTextView);
        highscoreTextview.setText("Highscore: " + highscoreGemt1);
    }
    public void backButton3 (View view) {
        finish();

    }
}
