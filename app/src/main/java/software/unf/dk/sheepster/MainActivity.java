package software.unf.dk.sheepster;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class MainActivity extends Activity {
public int count=0;
public int count2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
