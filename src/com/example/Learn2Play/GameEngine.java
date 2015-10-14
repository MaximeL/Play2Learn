package com.example.Learn2Play;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Maxime on 10/14/2015.
 */
public class GameEngine extends Activity {

    private String[] imageNames;
    private ImageElement[] imageTops;
    private ImageElement[] imageBots;

    private int nbTop;
    private int nbBot;

    private int score = 0;
    private int selectedItem = -1;
    int resID;

    private MediaPlayer gameSuccess;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Bundle b = getIntent().getExtras();
        nbTop = b.getInt("nbTop");
        nbBot = b.getInt("nbBot");
        imageNames = b.getStringArray("data");
        resID = getResources().getIdentifier("activity_niveau_" + b.getInt("level"), "layout", getPackageName());
        setContentView(resID);

        imageNames = GardenData.imageNames;

        imageTops = new ImageElement[nbTop];
        for(int i=0; i < nbTop; i++) {
            resID = getResources().getIdentifier("image_top_"+(i+1), "id", getPackageName());
            imageTops[i] = new ImageElement((ImageButton) findViewById(resID));
        }

        gameSuccess = MediaPlayer.create(this, R.raw.fx_applause);

        imageBots = new ImageElement[nbBot];
        for(int i=0; i < nbBot; i++) {
            resID = getResources().getIdentifier("image_bot_"+(i+1), "id", getPackageName());
            imageBots[i] = new ImageElement((ImageButton) findViewById(resID));
        }

        newGame();

        for(ImageElement imageElement : imageTops) {
            imageElement.getImageButton().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    removeBorders();
                    selectedItem = imageElement.getValueImage();
                    imageElement.setImageResource(R.drawable.customborder);
                }
            });
        }

        for(ImageElement imageElement : imageBots) {
            imageElement.getImageButton().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(selectedItem == imageElement.getValueImage()){
                        score++;
                        imageElement.setVisibility(View.INVISIBLE);
                        removeBorders();
                        if(score == nbBot) {
                            playSongGameSuccess();
                            newGame();
                        }
                    } else {
                        removeBorders();
                        selectedItem = -1;
                    }
                }
            });
        }

    }

    private void playSongGameSuccess(){
        gameSuccess.start();
    }

    private void newGame(){
        score = 0;

        removeBorders();
        ArrayList<Integer> listId = new ArrayList<Integer>();
        ArrayList<Integer> topListId = new ArrayList<Integer>();
        for(int i = 0; i < GardenData.nbElt; i++){
            listId.add(i);
        }

        Collections.shuffle(listId);

        for(int i = 0; i < nbTop; i++) {
            topListId.add(listId.get(i));
            resID = getResources().getIdentifier(imageNames[listId.get(i)] , "drawable", getPackageName());
            imageTops[i].setBackgroundResource(resID);
            imageTops[i].setValueImage(listId.get(i));
        }

        Collections.shuffle(topListId);

        for(int i = 0; i < nbBot; i++) {
            imageBots[i].setValueImage(topListId.get(i));
            resID = getResources().getIdentifier(imageNames[imageBots[i].getValueImage()], "drawable", getPackageName());
            imageBots[i].setBackgroundResource(resID);
            imageBots[i].setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(GameEngine.this, Menu.class);
        startActivity(intent);
        overridePendingTransition(R.transition.fade_in_opacity, R.transition.fade_out_opacity);
        finish();
    }

    public void removeBorders(){
        for(ImageElement imageElement : imageTops) {
            imageElement.setImageResource(R.drawable.noborder);
        }
    }
}
