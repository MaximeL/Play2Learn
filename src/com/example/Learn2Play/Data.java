package com.example.Learn2Play;

import android.os.Bundle;

/**
 * Created by marcd on 11/10/2015.
 *
 */
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
                "ver",
                "araignee",
                "sauterelle",
                "escargot",
                "fourmis"
        });
        garden.putStringArray("sufix" , new String[]{""});

        //Set colors data
        colors.putStringArray("prefix", new String[]{
                "color1",
                "color2"
        });
        colors.putStringArray("sufix", new String[]{
                "_bestiole1",
                "_bestiole2"
        });
    }

}
