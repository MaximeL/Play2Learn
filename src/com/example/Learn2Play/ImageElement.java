package com.example.Learn2Play;

import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by Maxime on 10/14/2015.
 */
public class ImageElement {

    private ImageButton imageButton;
    private ImageView arrow;

    private int valueImage;
    private String name;

    public ImageElement(ImageButton imageButton, ImageView arrow) {
        this.imageButton = imageButton;
        this.arrow = arrow;
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
    public void setVisibility(int visibility) {
        imageButton.setVisibility(visibility);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void activeHepl(int id) {
        if(valueImage == id) arrow.setVisibility(View.VISIBLE);
    }
    public void hideArrow() {
        arrow.setVisibility(View.INVISIBLE);
    }
}
