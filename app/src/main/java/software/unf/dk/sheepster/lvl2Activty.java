package software.unf.dk.sheepster;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
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
    public String count5;
    private int i=0;
    private int highscoreGemt1;
    public static String highscoreGemt = "highscoreGemt";
    private TextView highscoreLvl2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Hente gemt highscore
        SharedPreferences prefs = getSharedPreferences("prefs", lvl2Activty.MODE_PRIVATE);
        highscoreGemt1 = prefs.getInt("HighscoreGemt", highscoreGemt1);

        setContentView(R.layout.lvl2);
        clickCount2 = findViewById(R.id.countlvl2);
        life = 3;
        lvl2Sheep = (CanvasView) findViewById(R.id.lvl2Sheep);
        fence2 = (ImageView) findViewById(R.id.fence2);

        String highscoreGemt = "" + highscoreGemt1;

        highscoreLvl2 = (TextView) findViewById(R.id.highscoreLvl2);
        highscoreLvl2.setText(highscoreGemt);
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
    public void hiscoreToMain(View view){
        Intent hiscoreIntentString = new Intent(this, MainActivity.class);
        SharedPreferences prefs = getSharedPreferences("prefs", lvl2Activty.MODE_PRIVATE);
        highscoreGemt1 = prefs.getInt("HighscoreGemt", highscoreGemt1);
            if (count3>highscoreGemt1) {
                highscoreGemt1 = count3;
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
}
