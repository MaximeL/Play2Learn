package com.example.Learn2Play;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Maxime on 10/14/2015.
 */
public class ImageElement {

    private ImageButton imageButton;
    private int valueImage;
    private MediaPlayer songAnimal;
    private int audioID;

    public ImageElement(ImageButton imageButton) {
        this.imageButton = imageButton;
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


}
