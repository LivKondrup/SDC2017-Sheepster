package software.unf.dk.sheepster;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class skinSelectorActivity extends Activity {

    private int highscoreGemt1, selectedSkin;
    private TextView highscoreTextview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.skinselector);

        //Hente gemt highscore
        SharedPreferences prefs = getSharedPreferences("prefs", lvl2Activty.MODE_PRIVATE);
        highscoreGemt1 = prefs.getInt("HighscoreGemt", highscoreGemt1);

        //Hente gemt skin
        SharedPreferences prefs2 = getSharedPreferences("prefs2", skinSelectorActivity.MODE_PRIVATE);
        selectedSkin = prefs2.getInt("SkinGemt", selectedSkin);

        //Opdater TextView
        //highscoreTextview = (TextView) findViewById(R.id.skinSelectorHighscoreTextView);
        //highscoreTextview.setText("Highscore: " + highscoreGemt1);
    }
    public void backButton3 (View view) {
        finish();

    }

    public void standardSheepImagebutton (View view) {
        selectedSkin = 0;
        SharedPreferences sp2 = getSharedPreferences("prefs2", skinSelectorActivity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp2.edit();
        editor.putInt("SkinGemt", selectedSkin);
        editor.commit();
        finish();
    }

    public void blackSheepImagebutton (View view) {
        selectedSkin = 1;
        SharedPreferences sp2 = getSharedPreferences("prefs2", skinSelectorActivity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp2.edit();
        editor.putInt("SkinGemt", selectedSkin);
        editor.commit();
        finish();
    }

    public void blueSheepImagebutton (View view) {
        selectedSkin = 2;
        SharedPreferences sp2 = getSharedPreferences("prefs2", skinSelectorActivity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp2.edit();
        editor.putInt("SkinGemt", selectedSkin);
        editor.commit();
        finish();
    }

    public void BrownSheepImagebutton (View view) {
        selectedSkin = 3;
        SharedPreferences sp2 = getSharedPreferences("prefs2", skinSelectorActivity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp2.edit();
        editor.putInt("SkinGemt", selectedSkin);
        editor.commit();
        finish();
    }

    public void lightblueSheepImagebutton (View view) {
        selectedSkin = 4;
        SharedPreferences sp2 = getSharedPreferences("prefs2", skinSelectorActivity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp2.edit();
        editor.putInt("SkinGemt", selectedSkin);
        editor.commit();
        finish();

    }

    public void pinkSheepImagebutton (View view) {
        selectedSkin = 5;
        SharedPreferences sp2 = getSharedPreferences("prefs2", skinSelectorActivity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp2.edit();
        editor.putInt("SkinGemt", selectedSkin);
        editor.commit();
        finish();

    }

    public void redcrossSheepImagebutton (View view) {
        selectedSkin = 6;
        SharedPreferences sp2 = getSharedPreferences("prefs2", skinSelectorActivity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp2.edit();
        editor.putInt("SkinGemt", selectedSkin);
        editor.commit();
        finish();

    }

    public void trumpSheepImagebutton (View view) {
        selectedSkin = 7;
        SharedPreferences sp2 = getSharedPreferences("prefs2", skinSelectorActivity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp2.edit();
        editor.putInt("SkinGemt", selectedSkin);
        editor.commit();
        finish();

    }

    public void yellowSheepImagebutton (View view) {
        selectedSkin = 8;
        SharedPreferences sp2 = getSharedPreferences("prefs2", skinSelectorActivity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp2.edit();
        editor.putInt("SkinGemt", selectedSkin);
        editor.commit();
        finish();

    }

    public void doctorSheepImagebutton (View view) {
        selectedSkin = 9;
        SharedPreferences sp2 = getSharedPreferences("prefs2", skinSelectorActivity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp2.edit();
        editor.putInt("SkinGemt", selectedSkin);
        editor.commit();
        finish();

    }

    public void greenSheepImagebutton (View view) {
        selectedSkin = 10;
        SharedPreferences sp2 = getSharedPreferences("prefs2", skinSelectorActivity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp2.edit();
        editor.putInt("SkinGemt", selectedSkin);
        editor.commit();
        finish();

    }

    public void darthSheepImagebutton (View view) {
        selectedSkin = 11;
        SharedPreferences sp2 = getSharedPreferences("prefs2", skinSelectorActivity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp2.edit();
        editor.putInt("SkinGemt", selectedSkin);
        editor.commit();
        finish();

    }
}
