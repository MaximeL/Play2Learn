package com.example.Learn2Play;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Maxime on 10/14/2015.
 */
public class GameEngine extends Activity {

    private String[] imageNames;
    private ImageElement[] imageTops;
    private ImageElement[] imageBots;

    private ImageView[] arrows;

    private ImageView imageNon;
    private ImageView imageOui;

    private Animation animGetVisibleYes = null;
    private Animation animGetVisibleNo = null;
    
    private TextView textView;

    private int nbTop;
    private int nbBot;

    private int score = 0;
    private int selectedItem = -1;

    int resID;
    int imgbtnID;
    int arrowID;

    boolean help;

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

        imageNon = (ImageView) findViewById(R.id.image_non);
        imageOui = (ImageView) findViewById(R.id.image_oui);

        imageNon.setVisibility(View.INVISIBLE);
        imageOui.setVisibility(View.INVISIBLE);

        resID = getResources().getIdentifier("textView", "id", getPackageName());
        textView = (TextView) findViewById(resID);

        animGetVisibleYes = AnimationUtils.loadAnimation(this, R.anim.anim_get_visible_yes);
        animGetVisibleNo = AnimationUtils.loadAnimation(this, R.anim.anim_get_visible_no);

        animGetVisibleYes.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                if(score == nbBot) {
                    playSongGameSuccess();
                }
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(score == nbBot) {
                    newGame();
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        imageTops = new ImageElement[nbTop];
        for(int i=0; i < nbTop; i++) {
            imgbtnID = getResources().getIdentifier("image_top_"+(i+1), "id", getPackageName());
            arrowID = getResources().getIdentifier("arrow_"+(i+1), "id", getPackageName());
            imageTops[i] = new ImageElement((ImageButton) findViewById(resID), (ImageView) findViewById(arrowID));
        }

        gameSuccess = MediaPlayer.create(this, R.raw.fx_applause);

        imageBots = new ImageElement[nbBot];
        for(int i=0; i < nbBot; i++) {
            resID = getResources().getIdentifier("image_bot_"+(i+1), "id", getPackageName());
            imageBots[i] = new ImageElement((ImageButton) findViewById(resID), null);
        }

        newGame();

        for(ImageElement imageElement : imageTops) {
            imageElement.getImageButton().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    removeBorders();
                    selectedItem = imageElement.getValueImage();
                    imageElement.setImageResource(R.drawable.customborder);
                    textView.setText(imageElement.getName().toUpperCase());
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
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        imageOui.setVisibility(View.VISIBLE);
                                        imageOui.startAnimation(animGetVisibleYes);
                                        imageOui.setVisibility(View.INVISIBLE);
                                    }
                                });
                            }
                        }).start();
                    } else if(selectedItem != -1){
                        removeBorders();
                        selectedItem = -1;
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        imageNon.setVisibility(View.VISIBLE);
                                        imageNon.startAnimation(animGetVisibleNo);
                                        imageNon.setVisibility(View.INVISIBLE);
                                    }
                                });
                            }
                        }).start();
                    }
                }
            });
        }

    }

    private void playSongGameSuccess(){
        gameSuccess.start();
    }

    private void newGame(){
        selectedItem = -1;
        score = 0;

        textView.setText("");

        removeBorders();
        ArrayList<Integer> listId = new ArrayList<Integer>();
        ArrayList<Integer> topListId = new ArrayList<Integer>();
        for(int i = 0; i < imageNames.length; i++){
            listId.add(i);
        }

        Collections.shuffle(listId);

        for(int i = 0; i < nbTop; i++) {
            topListId.add(listId.get(i));
            resID = getResources().getIdentifier(imageNames[listId.get(i)]+"_256_256" , "drawable", getPackageName());
            imageTops[i].setBackgroundResource(resID);
            imageTops[i].setValueImage(listId.get(i));
            imageTops[i].setName(imageNames[listId.get(i)]);
        }

        Collections.shuffle(topListId);

        for(int i = 0; i < nbBot; i++) {
            imageBots[i].setValueImage(topListId.get(i));
            resID = getResources().getIdentifier(imageNames[imageBots[i].getValueImage()]+"_256_256", "drawable", getPackageName());
            imageBots[i].setBackgroundResource(resID);
            imageBots[i].setVisibility(View.VISIBLE);
            imageBots[i].setName(imageNames[imageBots[i].getValueImage()]);
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
        textView.setText("");
    }
}
