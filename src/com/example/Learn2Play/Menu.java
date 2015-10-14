package com.example.Learn2Play;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Menu extends Activity {
    private ImageButton buttonNiveau1;
    private ImageButton buttonNiveau2;
    private ImageButton buttonNiveau3;

    private MediaPlayer songButtonClickLeaf;
    private MediaPlayer instruMenu;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        buttonNiveau1 = (ImageButton) findViewById(R.id.buttonNiveau1);
        buttonNiveau2 = (ImageButton) findViewById(R.id.buttonNiveau2);
        buttonNiveau3 = (ImageButton) findViewById(R.id.buttonNiveau3);

        songButtonClickLeaf = MediaPlayer.create(this, R.raw.fx_button_click_leaf);
        instruMenu = MediaPlayer.create(this, R.raw.instru_menu);

        instruMenu.start();
        instruMenu.setLooping(true);

        buttonNiveau1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSongTouch();
                Intent intent = new Intent(Menu.this, GameEngine.class);
                Bundle b = new Bundle();
                b.putInt("level", 1);
                b.putInt("nbTop", 3);
                b.putInt("nbBot", 1);
                b.putStringArray("data", GardenData.imageNames);
                intent.putExtras(b);
                startActivity(intent);
                overridePendingTransition(R.transition.fade_in_opacity, R.transition.fade_out_opacity);
                finish();
                instruMenu.stop();
            }
        });

        buttonNiveau2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSongTouch();
                Intent intent = new Intent(Menu.this, GameEngine.class);
                Bundle b = new Bundle();
                b.putInt("level", 2);
                b.putInt("nbTop", 4);
                b.putInt("nbBot", 2);
                b.putStringArray("data", GardenData.imageNames);
                intent.putExtras(b);
                startActivity(intent);
                overridePendingTransition(R.transition.fade_in_opacity, R.transition.fade_out_opacity);
                finish();
                instruMenu.stop();
            }
        });

        buttonNiveau3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSongTouch();
                Intent intent = new Intent(Menu.this, GameEngine.class);
                Bundle b = new Bundle();
                b.putInt("level", 3);
                b.putInt("nbTop", 5);
                b.putInt("nbBot", 3);
                b.putStringArray("data", GardenData.imageNames);
                intent.putExtras(b);
                startActivity(intent);
                overridePendingTransition(R.transition.fade_in_opacity, R.transition.fade_out_opacity);
                finish();
                instruMenu.stop();
            }
        });


    }

    private void playSongTouch(){
        songButtonClickLeaf.start();
    }
}
