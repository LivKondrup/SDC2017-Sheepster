package software.unf.dk.sheepster;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class lvl1Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lvl1);
    }

    public void backButton (){      //mangler test
        finish();
    }
}
