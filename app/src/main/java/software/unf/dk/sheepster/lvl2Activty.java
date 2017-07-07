package software.unf.dk.sheepster;

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
    private int i=0;
    private int highscoreInt2;
    public static final String highscoreGemt = "highscoreGemt";
    private TextView highscoreLvl2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Hente gemt highscore
        /*SharedPreferences settings = getApplicationContext().getSharedPreferences(highscoreGemt, 0);
        int highscoreInt3 = settings.getInt("highscoreGemt", 0);
        highscoreInt2=highscoreInt3;
        */

       /* SharedPreferences prefs = getSharedPreferences(highscoreGemt, MODE_PRIVATE);
        String restoredText = prefs.getString("", null);
        if (restoredText != null) {
            int highscoreGemt1 = prefs.getInt("highscoreGemt", 0); //0 is the default value.
        }*/

        setContentView(R.layout.lvl2);
        clickCount2 = findViewById(R.id.countlvl2);
        life = 3;
        lvl2Sheep = (CanvasView) findViewById(R.id.lvl2Sheep);
        fence2 = (ImageView) findViewById(R.id.fence2);


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
            if (count3>highscoreInt2) {
                highscoreInt2=count3;
                hiscoreIntentString.putExtra("Highscore", count4);
            }
            //Sende highscore
            /*SharedPreferences settings = getApplicationContext().getSharedPreferences(highscoreGemt, 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("HighscoreGemt", highscoreInt2);
            editor.apply();*/


        startActivity(hiscoreIntentString);
    }



}
