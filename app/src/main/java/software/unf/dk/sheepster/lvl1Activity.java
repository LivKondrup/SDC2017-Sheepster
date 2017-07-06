package software.unf.dk.sheepster;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class lvl1Activity extends MainActivity {

    private TextView clickCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lvl1);
        clickCount = findViewById(R.id.countlvl1);
        // Gemmer klik, virker ikke
        //count = count2;
        //String count2 = "" + count;
        //clickCount.setText(count2);
    }

    public void backButton(View view) {
        finish();
    }



    public void sheepCountButton (View view){
        count++;
        String count2 = "" + count;
        clickCount.setText(count2);
    }

// Gemmer klik, virker ikke.
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        count2 = count;
//
//    }
}

