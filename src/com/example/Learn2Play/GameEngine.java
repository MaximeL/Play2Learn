package com.example.Learn2Play;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
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

    private Bundle allNames;
    private int sizesufix;
    private String[] prefix;
    private String[] sufix;
    private boolean solutionSufix;
    private ImageElement[] imageTops;
    private ImageElement[] imageBots;

    private ImageView[] arrows;

    private ImageView imageNon;
    private ImageView imageOui;

    private Animation animGetVisibleYes = null;
    private Animation animGetVisibleNo = null;
    private Animation animImageGetOut = null;
    private Animation animArrow = null;

    private TextView textView;

    private int nbTop;
    private int nbBot;

    private int score = 0;
    private int selectedItem = -1;
    private int selectedSet = 0;

    private int resID;
    private int audioID;
    private int imgbtnID;
    private int arrowID;

    private boolean help;

    private String text;

    private MediaPlayer gameSuccess;
    private MediaPlayer fxFail;
    private MediaPlayer audioHelpForms;
    private MediaPlayer audioHelpColors;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Bundle b = getIntent().getExtras();
        nbTop = b.getInt("nbTop");
        nbBot = b.getInt("nbBot");
        allNames = b.getBundle("data");
        prefix = allNames.getStringArray("prefix");
        sufix = allNames.getStringArray("sufix");
        solutionSufix = allNames.getBoolean("differentSolution");
        sizesufix = sufix.length;
        resID = getResources().getIdentifier("activity_niveau_" + b.getInt("level"), "layout", getPackageName());
        setContentView(resID);

        help = b.getBoolean("help");

        imageNon = (ImageView) findViewById(R.id.image_non);
        imageOui = (ImageView) findViewById(R.id.image_oui);

        imageNon.setVisibility(View.INVISIBLE);
        imageOui.setVisibility(View.INVISIBLE);

        resID = getResources().getIdentifier("textView", "id", getPackageName());
        textView = (TextView) findViewById(resID);

        animGetVisibleYes = AnimationUtils.loadAnimation(this, R.anim.anim_get_visible_yes);
        animGetVisibleNo = AnimationUtils.loadAnimation(this, R.anim.anim_get_visible_no);
        animImageGetOut = AnimationUtils.loadAnimation(this, R.anim.anim_image_get_out);
        animArrow = AnimationUtils.loadAnimation(this, R.anim.anim_arrow);
        animArrow.setRepeatMode(Animation.INFINITE);

        if(b.getString("gameMode").equals("forms")){
            audioHelpForms = MediaPlayer.create(this, R.raw.help_formes);
            audioHelpForms.start();
        } else if(b.getString("gameMode").equals("colors")){
            audioHelpColors = MediaPlayer.create(this, R.raw.help_couleurs);
            audioHelpColors.start();
        }

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
                    resetHelp();
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
            arrowID = getResources().getIdentifier("arrow_top_"+(i+1), "id", getPackageName());
            imageTops[i] = new ImageElement((ImageButton) findViewById(imgbtnID), (ImageView) findViewById(arrowID));
        }

        gameSuccess = MediaPlayer.create(this, R.raw.fx_applause);
        fxFail = MediaPlayer.create(this, R.raw.sound_fx_fail);
        fxFail.setVolume(1.9f, 1.9f);

        imageBots = new ImageElement[nbBot];
        for(int i=0; i < nbBot; i++) {
            imgbtnID = getResources().getIdentifier("image_bot_"+(i+1), "id", getPackageName());
            arrowID = getResources().getIdentifier("arrow_bot_"+(i+1), "id", getPackageName());
            imageBots[i] = new ImageElement((ImageButton) findViewById(imgbtnID), (ImageView) findViewById(arrowID));
            audioID = getResources().getIdentifier("raw/" + "coccinelle", "raw", getPackageName());
            imageBots[i].setAudioID(audioID);
        }

        newGame();

        for(ImageElement imageElement : imageTops) {
            imageElement.getImageButton().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    removeBorders();
                    selectedItem = imageElement.getValueImage();
                    imageElement.setImageResource(R.drawable.customborder);
                    imageElement.playSong(GameEngine.this);
                    text = imageElement.getName().toUpperCase();
                    if(text.equals("ARAIGNEE")){
                        text = "ARAIGN" + '\u00C9' + "E";
                    }
                    text = text.replaceAll("_", " ");
                    textView.setText(text);
                    if (score != nbBot)
                        setHelpTop();
                    resetHelp();
                    //Le boolean est false si la selection est mauvaise. On garde l'aide en haut dans ce cas
                    boolean tmp = setHelpBot();
                    if(!tmp) {
                        resetHelp();
                        setHelpTop();
                    }
                }
            });
        }

        for(ImageElement imageElement : imageBots) {
            imageElement.getImageButton().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    resetHelp();
                    if(selectedItem == imageElement.getValueImage()){
                        selectedItem = -1;
                        score++;
                        if(score != nbBot)
                            setHelpTop();
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        imageElement.startAnimation(animImageGetOut);
                                        imageElement.setVisibility(View.INVISIBLE);
                                    }
                                });
                            }
                        }).start();
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
                        playSongFail();
                        removeBorders();
                        selectedItem = -1;
                        setHelpTop();
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

    private void playSongFail(){
        fxFail.start();
    }

    private void newGame(){
        selectedItem = -1;
        score = 0;

        Log.d("GameEngine", "sizesufix = "+sizesufix);
        selectedSet = (int) Math.floor(Math.random()*sizesufix);
        Log.d("GameEngine", "selectedset = "+selectedSet);

        textView.setText("");

        removeBorders();
        ArrayList<Integer> listId = new ArrayList<Integer>();
        ArrayList<Integer> topListId = new ArrayList<Integer>();
        for(int i = 0; i < prefix.length; i++){
            listId.add(i);
        }

        Collections.shuffle(listId);

        for(int i = 0; i < nbTop; i++) {
            topListId.add(listId.get(i));
            Log.d("GameEngine", "image name : " + prefix[listId.get(i)]+sufix[selectedSet]+"_256_256");
            resID = getResources().getIdentifier(prefix[listId.get(i)]+sufix[selectedSet]+"_256_256" , "drawable", getPackageName());
            imageTops[i].setBackgroundResource(resID);
            imageTops[i].setValueImage(listId.get(i));
            audioID = getResources().getIdentifier("raw/" + prefix[listId.get(i)], "raw", getPackageName());
            imageTops[i].setAudioID(audioID);
            imageTops[i].setName(prefix[listId.get(i)]);
        }

        Collections.shuffle(topListId);

        for(int i = 0; i < nbBot; i++) {
            imageBots[i].setValueImage(topListId.get(i));
            if(solutionSufix) {
                resID = getResources().getIdentifier(prefix[imageBots[i].getValueImage()] + "_solution" + "_256_256", "drawable", getPackageName());
            } else {
                resID = getResources().getIdentifier(prefix[imageBots[i].getValueImage()] + sufix[selectedSet] + "_256_256", "drawable", getPackageName());
            }
            imageBots[i].setBackgroundResource(resID);
            imageBots[i].setVisibility(View.VISIBLE);
            imageBots[i].setName(prefix[imageBots[i].getValueImage()]);
        }

        setHelpTop();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(GameEngine.this, Menu.class);
        startActivity(intent);
        overridePendingTransition(R.transition.fade_in_opacity, R.transition.fade_out_opacity);
        finish();
    }

    private void removeBorders(){
        for(ImageElement imageElement : imageTops) {
            imageElement.setImageResource(R.drawable.noborder);
        }
        textView.setText("");
    }

    private void setHelpTop() {
        if(help) {
            for(int i = 0; i < nbBot; i++) {
                for(int j = 0; j < nbTop; j++) {
                    imageTops[j].activeHepl(imageBots[i].getValueImage(), animArrow);
                }
            }
        }
    }
    private boolean setHelpBot() {
        if(help) {
            boolean res = false;
            boolean tmp;
            for(int i = 0; i < nbBot; i++) {
                tmp = imageBots[i].activeHepl(selectedItem, animArrow);
                if(tmp) res = tmp;
            }
            return res;
        }
        return true;
    }

    private void resetHelp() {
        if(help) {
            for(int i = 0; i < nbBot; i++) {
                imageBots[i].hideArrow();
            }
            for(int i = 0; i < nbTop; i++) {
                imageTops[i].hideArrow();
            }
        }
    }
}
