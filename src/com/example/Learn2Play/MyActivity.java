package com.example.Learn2Play;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MyActivity extends Activity {
    private ImageButton buttonJouer;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        buttonJouer = (ImageButton) findViewById(R.id.buttonJouer);

        buttonJouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyActivity.this, Niveau1.class);
                startActivity(intent);
                overridePendingTransition(R.transition.fade_in_opacity, R.transition.fade_out_opacity);
                finish();
            }
        });
    }
}
