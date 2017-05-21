package com.example.Learn2Play;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.io.IOException;


public class Menu extends Activity {
    private ImageButton buttonForm;
    private ImageButton buttonColor;

    private MediaPlayer songButtonClick;
    public static MediaPlayer instruMenu;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        initGame();

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
                Bundle b = new Bundle();
                b.putBundle("data", Data.garden);
                b.putString("gameMode", "forms");
                intent.putExtras(b);
                startActivity(intent);
                overridePendingTransition(R.transition.fade_in_opacity, R.transition.fade_out_opacity);
                finish();
            }
        });

        buttonColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSongTouch();
                Intent intent = new Intent(Menu.this, MenuForm.class);
                Bundle b = new Bundle();
                b.putBundle("data", Data.colors);
                b.putString("gameMode", "colors");
                intent.putExtras(b);
                startActivity(intent);
                overridePendingTransition(R.transition.fade_in_opacity, R.transition.fade_out_opacity);
                finish();
            }
        });
    }

    private void playSongTouch(){
        songButtonClick.start();
    }

    public void onBackPressed() {
        finish();
        System.exit(0);
    }

    private void initGame() {
        Data.setData();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Menu.instruMenu.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Menu.instruMenu.start();
    }
}
