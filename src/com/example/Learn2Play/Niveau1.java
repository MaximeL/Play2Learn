package com.example.Learn2Play;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Marc on 30/09/2015.
 */
public class Niveau1 extends Activity {

    private String[] imageNames;
    private ImageElement[] imageTops;
    private ImageElement imageBot1;

    private int selectedItem = -1;
    private int propositions = 3;

    int resID;

    private MediaPlayer gameSuccess;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        imageNames = Data.imageNames;

        imageTops = new ImageElement[propositions];
        ImageButton imgButton = (ImageButton) findViewById(R.id.image_top_1);
        Log.d("Debug", "juste before creation : imgButton : " + imgButton);
        imageTops[0] = new ImageElement((ImageButton) findViewById(R.id.image_top_1));
        imageTops[1] = new ImageElement((ImageButton) findViewById(R.id.image_top_2));
        imageTops[2] = new ImageElement((ImageButton) findViewById(R.id.image_top_3));

        for(ImageElement imageElement : imageTops)
            Log.d("Debug", "juste after creation : imageButton : " + imageElement.imageButton);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niveau_1);

        imageBot1 = new ImageElement((ImageButton) findViewById(R.id.image_bot_1));

        gameSuccess = MediaPlayer.create(this, R.raw.fx_applause);

        newGame();

        for(ImageElement imageElement : imageTops) {
            imageElement.imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    removeBorders();
                    selectedItem = imageElement.getValueImage();
                    imageElement.imageButton.setImageResource(R.drawable.customborder);
                }
            });
        }

        imageBot1.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedItem == imageBot1.getValueImage()) {
                    playSongGameSuccess();
                    newGame();
                } else {
                    removeBorders();
                    selectedItem = -1;
                }
            }
        });

    }

    private void playSongGameSuccess(){
        gameSuccess.start();
    }

    private void newGame(){
        removeBorders();
        ArrayList<Integer> listId = new ArrayList<Integer>();
        ArrayList<Integer> topListId = new ArrayList<Integer>();
        for(int i = 0; i < Data.nbElt; i++){
            listId.add(i);
        }

        Collections.shuffle(listId);

        for(int i = 0; i < propositions; i++) {
            topListId.add(listId.get(i));
            resID = getResources().getIdentifier(imageNames[listId.get(i)] , "drawable", getPackageName());
            Log.d("Debug", "Image : " + imageNames[listId.get(i)]);
            Log.d("Debug", "i : " + i);
            Log.d("Debug", "imageTops[i] : " + imageTops[i]);
            Log.d("Debug", "imageButton : " + imageTops[i].imageButton);
            Log.d("Debug", "imageButton : " + imageTops[i].getImageButton());
            Log.d("Debug", "resID : " + resID);
            imageTops[i].imageButton.setBackgroundResource(resID);
            imageTops[i].setValueImage(listId.get(i));
        }

        Collections.shuffle(topListId);
        imageBot1.setValueImage(topListId.get(0));

        resID = getResources().getIdentifier(imageNames[imageBot1.getValueImage()] , "drawable", getPackageName());
        imageBot1.imageButton.setBackgroundResource(resID);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Niveau1.this, Menu.class);
        startActivity(intent);
        overridePendingTransition(R.transition.fade_in_opacity, R.transition.fade_out_opacity);
        finish();
    }

    public void removeBorders(){
        for(ImageElement imageElement : imageTops) {
            imageElement.imageButton.setImageResource(R.drawable.noborder);
        }
    }
}