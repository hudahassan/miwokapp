package com.example.huza.miwok;

/**
 * Created by huza on 3/15/2019.
 */

public class word {
    private int message;
    private int default_message;
    private int audio_Resource;

    private int image=NO_IMAGE;
    private static final int NO_IMAGE=-1;

    public word(int message, int default_message,int audio_Resource) {
        this.message = message;
        this.default_message = default_message;
        this.audio_Resource=audio_Resource;
    }
    public word(int message, int default_message,int image,int audio_Resource) {
        this.message = message;
        this.default_message = default_message;
        this.image=image;
        this.audio_Resource=audio_Resource;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public int getDefault_message() {
        return default_message;
    }

    public void setDefault_message(int default_message) {
        this.default_message = default_message;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
    public boolean hasimage() {
        return image != NO_IMAGE;

    }

    public int getAudio_Resource() {
        return audio_Resource;
    }

    public void setAudio_Resource(int audio_Resource) {
        this.audio_Resource = audio_Resource;
    }
}

