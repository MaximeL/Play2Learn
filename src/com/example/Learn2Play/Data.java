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
        garden.putInt("size", 1);
        garden.putStringArray("0", new String[] {
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

        //Set colors data
        colors.putInt("size", 2);
        colors.putStringArray("0", new String[]{
        });
        colors.putStringArray("1", new String[]{
        });
    }

}
