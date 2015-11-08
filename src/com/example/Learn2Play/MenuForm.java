package com.example.Learn2Play;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MenuForm extends Activity {
    private ImageButton buttonNiveau0;
    private ImageButton buttonNiveau1;
    private ImageButton buttonNiveau2;
    private ImageButton buttonNiveau3;

    private MediaPlayer songButtonClick;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_form);

        Bundle bdl = getIntent().getExtras();

        buttonNiveau0 = (ImageButton) findViewById(R.id.buttonNiveau0);
        buttonNiveau1 = (ImageButton) findViewById(R.id.buttonNiveau1);
        buttonNiveau2 = (ImageButton) findViewById(R.id.buttonNiveau2);
        buttonNiveau3 = (ImageButton) findViewById(R.id.buttonNiveau3);

        songButtonClick = MediaPlayer.create(this, R.raw.fx_knock_door);


        buttonNiveau0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSongTouch();
                Intent intent = new Intent(MenuForm.this, GameEngine.class);
                Bundle b = new Bundle();
                b.putInt("level", 1);
                b.putInt("nbTop", 3);
                b.putInt("nbBot", 1);
                b.putBundle("data", bdl.getBundle("data"));
                b.putBoolean("help", true);
                intent.putExtras(b);
                startActivity(intent);
                overridePendingTransition(R.transition.fade_in_opacity, R.transition.fade_out_opacity);
                finish();
                Menu.instruMenu.stop();
            }
        });

        buttonNiveau1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSongTouch();
                Intent intent = new Intent(MenuForm.this, GameEngine.class);
                Bundle b = new Bundle();
                b.putInt("level", 1);
                b.putInt("nbTop", 3);
                b.putInt("nbBot", 1);
                b.putBundle("data", bdl.getBundle("data"));
                b.putBoolean("help", false);
                intent.putExtras(b);
                startActivity(intent);
                overridePendingTransition(R.transition.fade_in_opacity, R.transition.fade_out_opacity);
                finish();
                Menu.instruMenu.stop();
            }
        });

        buttonNiveau2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSongTouch();
                Intent intent = new Intent(MenuForm.this, GameEngine.class);
                Bundle b = new Bundle();
                b.putInt("level", 2);
                b.putInt("nbTop", 4);
                b.putInt("nbBot", 2);
                b.putBundle("data", bdl.getBundle("data"));
                b.putBoolean("help", false);
                intent.putExtras(b);
                startActivity(intent);
                overridePendingTransition(R.transition.fade_in_opacity, R.transition.fade_out_opacity);
                finish();
                Menu.instruMenu.stop();
            }
        });

        buttonNiveau3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSongTouch();
                Intent intent = new Intent(MenuForm.this, GameEngine.class);
                Bundle b = new Bundle();
                b.putInt("level", 3);
                b.putInt("nbTop", 5);
                b.putInt("nbBot", 3);
                b.putBundle("data", bdl.getBundle("data"));
                b.putBoolean("help", false);
                intent.putExtras(b);
                startActivity(intent);
                overridePendingTransition(R.transition.fade_in_opacity, R.transition.fade_out_opacity);
                finish();
                Menu.instruMenu.stop();
            }
        });


    }

    private void playSongTouch(){
        songButtonClick.start();
    }

    public void onBackPressed() {
        Intent intent = new Intent(MenuForm.this, Menu.class);
        startActivity(intent);
        overridePendingTransition(R.transition.fade_in_opacity, R.transition.fade_out_opacity);
        finish();
    }
}
