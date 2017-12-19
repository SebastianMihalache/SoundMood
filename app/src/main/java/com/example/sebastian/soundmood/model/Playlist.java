package com.example.sebastian.soundmood.model;

/**
 * Created by Sebastian on 17.12.2017.
 */

public class Playlist {

    private final String DRAWABLE = "drawable/";
    private String playlistTitle;
    private String imgURL;

    public Playlist(String playlistTitle, String imgURL) {
        this.playlistTitle = playlistTitle;
        this.imgURL = imgURL;
    }

    public String getPlaylistTitle() {
        return playlistTitle;
    }

    public String getImgURL() {
        return DRAWABLE + imgURL;
    }

}
