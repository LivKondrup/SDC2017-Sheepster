package software.unf.dk.sheepster;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by deltager on 06-07-17.
 */

public class skinSelectorActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.skinselector);
    }
    public void backButton3 (View view) {
        finish();

    }
}
