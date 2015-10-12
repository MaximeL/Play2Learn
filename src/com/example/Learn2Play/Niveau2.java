package com.example.Learn2Play;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Collections;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Collections;


/**
 * Created by Zizou on 12/10/2015.
 */
public class Niveau2 extends Activity{
    private ImageButton imageTop1;
    private ImageButton imageTop2;
    private ImageButton imageTop3;
    private ImageButton imageTop4;
    private ImageButton imageBot1;
    private ImageButton imageBot2;
    private int valueImageTop1 = -1;
    private int valueImageTop2 = -1;
    private int valueImageTop3 = -1;
    private int valueImageTop4 = -1;
    private int selectedItem = -1;
    private int successItem1 = -1;
    private int successItem2 = -1;
    private int propositions = 4;
    private int pts = 0;
    private int ptsToWin = 2;

    private MediaPlayer gameSuccess;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niveau_2);

        imageTop1 = (ImageButton) findViewById(R.id.image_top_1);
        imageTop2 = (ImageButton) findViewById(R.id.image_top_2);
        imageTop3 = (ImageButton) findViewById(R.id.image_top_3);
        imageTop4 = (ImageButton) findViewById(R.id.image_top_4);
        imageBot1 = (ImageButton) findViewById(R.id.image_bot_1);
        imageBot2 = (ImageButton) findViewById(R.id.image_bot_2);

        gameSuccess = MediaPlayer.create(this, R.raw.fx_applause);

        newGame();

        imageTop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedItem = valueImageTop1;
            }
        });

        imageTop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedItem = valueImageTop2;
            }
        });

        imageTop3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedItem = valueImageTop3;
            }
        });

        imageTop4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedItem = valueImageTop4;
            }
        });

        imageBot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedItem == successItem1){
                    pts++;
                    imageBot1.setVisibility(View.INVISIBLE);
                    if(pts == ptsToWin) {
                        playSongGameSuccess();
                        newGame();
                    }
                }
            }
        });

        imageBot2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedItem == successItem2){
                    pts++;
                    imageBot2.setVisibility(View.INVISIBLE);
                    if(pts == ptsToWin) {
                        playSongGameSuccess();
                        newGame();
                    }
                }
            }
        });

    }

    private void playSongGameSuccess(){
        gameSuccess.start();
    }

    private void newGame(){
        imageBot1.setVisibility(View.VISIBLE);
        imageBot2.setVisibility(View.VISIBLE);
        pts = 0;
        ArrayList<Integer> listId = new ArrayList<Integer>();
        ArrayList<Integer> topListId = new ArrayList<Integer>();
        for(int i = 0; i < Data.nbElt; i++){
            listId.add(i);
        }

        Collections.shuffle(listId);

        for(int i = 0; i < propositions; i++) {
            topListId.add(listId.get(i));
            switch (listId.get(i)) {
                case 0: {
                    if(i == 0) {
                        imageTop1.setBackgroundResource(R.drawable.fleur_256_256);
                        valueImageTop1 = Data.fleurId;
                    } else if(i == 1){
                        imageTop2.setBackgroundResource(R.drawable.fleur_256_256);
                        valueImageTop2 = Data.fleurId;
                    } else if(i == 2){
                        imageTop3.setBackgroundResource(R.drawable.fleur_256_256);
                        valueImageTop3 = Data.fleurId;
                    } else if(i == 3){
                        imageTop4.setBackgroundResource(R.drawable.fleur_256_256);
                        valueImageTop4 = Data.fleurId;
                    }
                    break;
                }
                case 1: {
                    if(i == 0) {
                        imageTop1.setBackgroundResource(R.drawable.papillon_256_256);
                        valueImageTop1 = Data.papillonId;
                    } else if(i == 1){
                        imageTop2.setBackgroundResource(R.drawable.papillon_256_256);
                        valueImageTop2 = Data.papillonId;
                    } else if(i == 2){
                        imageTop3.setBackgroundResource(R.drawable.papillon_256_256);
                        valueImageTop3 = Data.papillonId;
                    } else if(i == 3){
                        imageTop4.setBackgroundResource(R.drawable.papillon_256_256);
                        valueImageTop4 = Data.papillonId;
                    }
                    break;
                }
                case 2: {
                    if(i == 0) {
                        imageTop1.setBackgroundResource(R.drawable.arbre_256_256);
                        valueImageTop1 = Data.arbreId;
                    } else if(i == 1){
                        imageTop2.setBackgroundResource(R.drawable.arbre_256_256);
                        valueImageTop2 = Data.arbreId;
                    } else if(i == 2){
                        imageTop3.setBackgroundResource(R.drawable.arbre_256_256);
                        valueImageTop3 = Data.arbreId;
                    } else if(i == 3){
                        imageTop4.setBackgroundResource(R.drawable.arbre_256_256);
                        valueImageTop4 = Data.arbreId;
                    }
                    break;
                }
                case 3: {
                    if(i == 0) {
                        imageTop1.setBackgroundResource(R.drawable.abeille_256_256);
                        valueImageTop1 = Data.abeilleId;
                    } else if(i == 1){
                        imageTop2.setBackgroundResource(R.drawable.abeille_256_256);
                        valueImageTop2 = Data.abeilleId;
                    } else if(i == 2){
                        imageTop3.setBackgroundResource(R.drawable.abeille_256_256);
                        valueImageTop3 = Data.abeilleId;
                    } else if(i == 3){
                        imageTop4.setBackgroundResource(R.drawable.abeille_256_256);
                        valueImageTop4 = Data.abeilleId;
                    }
                    break;
                }
                case 4: {
                    if(i == 0) {
                        imageTop1.setBackgroundResource(R.drawable.coccinelle_256_256);
                        valueImageTop1 = Data.coccinelleId;
                    } else if(i == 1){
                        imageTop2.setBackgroundResource(R.drawable.coccinelle_256_256);
                        valueImageTop2 = Data.coccinelleId;
                    } else if(i == 2){
                        imageTop3.setBackgroundResource(R.drawable.coccinelle_256_256);
                        valueImageTop3 = Data.coccinelleId;
                    } else if(i == 3){
                        imageTop4.setBackgroundResource(R.drawable.coccinelle_256_256);
                        valueImageTop4 = Data.coccinelleId;
                    }
                    break;
                }
                case 5: {
                    if(i == 0) {
                        imageTop1.setBackgroundResource(R.drawable.chenille_256_256);
                        valueImageTop1 = Data.chenilleId;
                    } else if(i == 1){
                        imageTop2.setBackgroundResource(R.drawable.chenille_256_256);
                        valueImageTop2 = Data.chenilleId;
                    } else if(i == 2){
                        imageTop3.setBackgroundResource(R.drawable.chenille_256_256);
                        valueImageTop3 = Data.chenilleId;
                    } else if(i == 3){
                        imageTop4.setBackgroundResource(R.drawable.chenille_256_256);
                        valueImageTop4 = Data.chenilleId;
                    }
                    break;
                }
                default:
                    break;
            }
        }

        Collections.shuffle(topListId);
        successItem1 = topListId.get(0);
        successItem2 = topListId.get(1);

        switch(successItem1){
            case 0 : {
                imageBot1.setBackgroundResource(R.drawable.fleur_256_256);
                break;
            }
            case 1 : {
                imageBot1.setBackgroundResource(R.drawable.papillon_256_256);
                break;
            }
            case 2 : {
                imageBot1.setBackgroundResource(R.drawable.arbre_256_256);
                break;
            }
            case 3 : {
                imageBot1.setBackgroundResource(R.drawable.abeille_256_256);
                break;
            }
            case 4 : {
                imageBot1.setBackgroundResource(R.drawable.coccinelle_256_256);
                break;
            }
            case 5 : {
                imageBot1.setBackgroundResource(R.drawable.chenille_256_256);
                break;
            }
            default : break;
        }

        switch(successItem2){
            case 0 : {
                imageBot2.setBackgroundResource(R.drawable.fleur_256_256);
                break;
            }
            case 1 : {
                imageBot2.setBackgroundResource(R.drawable.papillon_256_256);
                break;
            }
            case 2 : {
                imageBot2.setBackgroundResource(R.drawable.arbre_256_256);
                break;
            }
            case 3 : {
                imageBot2.setBackgroundResource(R.drawable.abeille_256_256);
                break;
            }
            case 4 : {
                imageBot2.setBackgroundResource(R.drawable.coccinelle_256_256);
                break;
            }
            case 5 : {
                imageBot2.setBackgroundResource(R.drawable.chenille_256_256);
                break;
            }
            default : break;
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Niveau2.this, Menu.class);
        startActivity(intent);
        overridePendingTransition(R.transition.fade_in_opacity, R.transition.fade_out_opacity);
        finish();
    }
}
