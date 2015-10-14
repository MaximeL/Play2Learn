package com.example.Learn2Play;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
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
    private ImageButton imageTop1;
    private ImageButton imageTop2;
    private ImageButton imageTop3;
    private ImageButton imageBot1;
    private int valueImageTop1 = -1;
    private int valueImageTop2 = -1;
    private int valueImageTop3 = -1;
    private int selectedItem = -1;
    private int successItem = -1;
    private int propositions = 3;

    private MediaPlayer gameSuccess;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niveau_1);

        imageTop1 = (ImageButton) findViewById(R.id.image_top_1);
        imageTop2 = (ImageButton) findViewById(R.id.image_top_2);
        imageTop3 = (ImageButton) findViewById(R.id.image_top_3);
        imageBot1 = (ImageButton) findViewById(R.id.image_bot_1);

        gameSuccess = MediaPlayer.create(this, R.raw.fx_applause);

        newGame();

        imageTop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeBorders();
                selectedItem = valueImageTop1;
                imageTop1.setImageResource(R.drawable.customborder);
            }
        });

        imageTop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeBorders();
                selectedItem = valueImageTop2;
                imageTop2.setImageResource(R.drawable.customborder);
            }
        });

        imageTop3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeBorders();
                selectedItem = valueImageTop3;
                imageTop3.setImageResource(R.drawable.customborder);
            }
        });

        imageBot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedItem == successItem){
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
                    }
                    break;
                }
                case 2: {
                    if(i == 0) {
                        imageTop1.setBackgroundResource(R.drawable.feuille_256_256);
                        valueImageTop1 = Data.feuilleId;
                    } else if(i == 1){
                        imageTop2.setBackgroundResource(R.drawable.feuille_256_256);
                        valueImageTop2 = Data.feuilleId;
                    } else if(i == 2){
                        imageTop3.setBackgroundResource(R.drawable.feuille_256_256);
                        valueImageTop3 = Data.feuilleId;
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
                    }
                    break;
                }
                case 5: {
                    if(i == 0) {
                        imageTop1.setBackgroundResource(R.drawable.ver_256_256);
                        valueImageTop1 = Data.verId;
                    } else if(i == 1){
                        imageTop2.setBackgroundResource(R.drawable.ver_256_256);
                        valueImageTop2 = Data.verId;
                    } else if(i == 2){
                        imageTop3.setBackgroundResource(R.drawable.ver_256_256);
                        valueImageTop3 = Data.verId;
                    }
                    break;
                }
                case 6: {
                    if(i == 0) {
                        imageTop1.setBackgroundResource(R.drawable.araigne_256_256);
                        valueImageTop1 = Data.araigneId;
                    } else if(i == 1){
                        imageTop2.setBackgroundResource(R.drawable.araigne_256_256);
                        valueImageTop2 = Data.araigneId;
                    } else if(i == 2){
                        imageTop3.setBackgroundResource(R.drawable.araigne_256_256);
                        valueImageTop3 = Data.araigneId;
                    }
                    break;
                }
                case 7: {
                    if(i == 0) {
                        imageTop1.setBackgroundResource(R.drawable.sauterelle_256_256);
                        valueImageTop1 = Data.sauterelleId;
                    } else if(i == 1){
                        imageTop2.setBackgroundResource(R.drawable.sauterelle_256_256);
                        valueImageTop2 = Data.sauterelleId;
                    } else if(i == 2){
                        imageTop3.setBackgroundResource(R.drawable.sauterelle_256_256);
                        valueImageTop3 = Data.sauterelleId;
                    }
                    break;
                }
                case 8: {
                    if(i == 0) {
                        imageTop1.setBackgroundResource(R.drawable.escargot_256_256);
                        valueImageTop1 = Data.escargotId;
                    } else if(i == 1){
                        imageTop2.setBackgroundResource(R.drawable.escargot_256_256);
                        valueImageTop2 = Data.escargotId;
                    } else if(i == 2){
                        imageTop3.setBackgroundResource(R.drawable.escargot_256_256);
                        valueImageTop3 = Data.escargotId;
                    }
                    break;
                }
                case 9: {
                    if(i == 0) {
                        imageTop1.setBackgroundResource(R.drawable.fourmis_256_256);
                        valueImageTop1 = Data.fourmisId;
                    } else if(i == 1){
                        imageTop2.setBackgroundResource(R.drawable.fourmis_256_256);
                        valueImageTop2 = Data.fourmisId;
                    } else if(i == 2){
                        imageTop3.setBackgroundResource(R.drawable.fourmis_256_256);
                        valueImageTop3 = Data.fourmisId;
                    }
                    break;
                }
                default:
                    break;
            }
        }

        Collections.shuffle(topListId);
        successItem = topListId.get(0);

        switch(successItem){
            case 0 : {
                imageBot1.setBackgroundResource(R.drawable.fleur_256_256);
                break;
            }
            case 1 : {
                imageBot1.setBackgroundResource(R.drawable.papillon_256_256);
                break;
            }
            case 2 : {
                imageBot1.setBackgroundResource(R.drawable.feuille_256_256);
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
                imageBot1.setBackgroundResource(R.drawable.ver_256_256);
                break;
            }
            case 6 : {
                imageBot1.setBackgroundResource(R.drawable.araigne_256_256);
                break;
            }
            case 7 : {
                imageBot1.setBackgroundResource(R.drawable.sauterelle_256_256);
                break;
            }
            case 8 : {
                imageBot1.setBackgroundResource(R.drawable.escargot_256_256);
                break;
            }
            case 9 : {
                imageBot1.setBackgroundResource(R.drawable.fourmis_256_256);
                break;
            }
            default : break;
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Niveau1.this, Menu.class);
        startActivity(intent);
        overridePendingTransition(R.transition.fade_in_opacity, R.transition.fade_out_opacity);
        finish();
    }

    public void removeBorders(){
        imageTop1.setImageResource(R.drawable.noborder);
        imageTop2.setImageResource(R.drawable.noborder);
        imageTop3.setImageResource(R.drawable.noborder);
    }
}