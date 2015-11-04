package com.example.Learn2Play;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by Maxime on 10/14/2015.
 */
public class ImageElement {

    private ImageButton imageButton;
    private ImageView arrow;

    private int valueImage;
    private MediaPlayer songAnimal;
    private int audioID;
    private String name;

    private boolean isResponce = false;

    public ImageElement(ImageButton imageButton, ImageView arrow) {
        this.imageButton = imageButton;
        this.arrow = arrow;
        this.valueImage = -1;
    }

    public void playSong(Context context){
        songAnimal = MediaPlayer.create(context, audioID);
        songAnimal.start();
    }

    public ImageButton getImageButton() {
        return imageButton;
    }

    public int getAudioID() {
        return audioID;
    }

    public void setAudioID(int audioID) {
        this.audioID = audioID;
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
    public void startAnimation(Animation anim){
        imageButton.startAnimation(anim);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean activeHepl(int id) {
        if(valueImage == id) {
            arrow.setVisibility(View.VISIBLE);
            isResponce = true;
        }
        return isResponce;
    }
    public void hideArrow() {
        arrow.setVisibility(View.INVISIBLE);
        isResponce = false;
    }
}
