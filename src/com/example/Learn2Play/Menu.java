package com.example.Learn2Play;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by marcd on 06/11/2015.
 */
public class Menu extends Activity {
    private ImageButton buttonForm;
    private ImageButton buttonColor;

    private MediaPlayer songButtonClick;
    private MediaPlayer instruMenu;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        buttonForm = (ImageButton) findViewById(R.id.buttonForm);
        buttonColor = (ImageButton) findViewById(R.id.buttonColor);

        songButtonClick = MediaPlayer.create(this, R.raw.fx_knock_door);
        instruMenu = MediaPlayer.create(this, R.raw.instru_menu);

        instruMenu.start();
        instruMenu.setLooping(true);

        buttonForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSongTouch();
                Intent intent = new Intent(Menu.this, MenuForm.class);
                startActivity(intent);
                overridePendingTransition(R.transition.fade_in_opacity, R.transition.fade_out_opacity);
                finish();
                instruMenu.stop();
            }
        });

        buttonColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSongTouch();
                Intent intent = new Intent(Menu.this, MenuForm.class);
                startActivity(intent);
                overridePendingTransition(R.transition.fade_in_opacity, R.transition.fade_out_opacity);
                finish();
                instruMenu.stop();
            }
        });
    }

    private void playSongTouch(){
        songButtonClick.start();
    }
}
