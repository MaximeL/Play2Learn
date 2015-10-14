package com.example.Learn2Play;

import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Maxime on 10/14/2015.
 */
public class ImageElement {

    private ImageButton imageButton;
    private int valueImage;

    public ImageElement(ImageButton imageButton) {
        this.imageButton = imageButton;
        this.valueImage = -1;
    }

    public ImageButton getImageButton() {
        return imageButton;
    }

    public void setImageButton(ImageButton imageButton) {
        this.imageButton = imageButton;
    }

    public int getValueImage() {
        return valueImage;
    }

    public void setValueImage(int valueImage) {
        this.valueImage = valueImage;
    }

    public void setBackgroundResource(int resID) {
        imageButton.setBackgroundResource(resID);
    }
    public void setImageResource(int noborder) {
        imageButton.setImageResource(noborder);
    }



}
