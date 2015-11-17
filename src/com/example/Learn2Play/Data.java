package com.example.Learn2Play;

import android.os.Bundle;


public class Data {

    public static Bundle garden = new Bundle();

    public static Bundle colors = new Bundle();

    public static void setData() {
        //Set garden data
        garden.putStringArray("prefix", new String[]{
                "fleur",
                "papillon",
                "feuille",
                "abeille",
                "coccinelle",
                "ver_de_terre",
                "araignee",
                "sauterelle",
                "escargot",
                "fourmis"
        });
        garden.putStringArray("sufix" , new String[]{""});
        garden.putBoolean("differentSolution", false);

        //Set colors data
        colors.putStringArray("prefix", new String[]{
                "bleu",
                "vert",
                "rouge",
                "rose",
                "jaune"
        });
        colors.putStringArray("sufix", new String[]{
                "_papillon",
                "_fleur"
        });
        colors.putBoolean("differentSolution", true);
    }



}
