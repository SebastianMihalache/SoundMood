package com.example.sebastian.soundmood.model;

/**
 * Created by Sebastian on 18.12.2017.
 */

public class PlaylistDetails {
    private final String DRAWABLE = "drawable/";
    private String detailsTitle;
    private String detailsSubtitle;
    private String detailsImg;

    public String getDetailsTitle() {
        return detailsTitle;
    }

    public String getDetailsSubtitle() {
        return detailsSubtitle;
    }

    public String getDetailsImg() {
        return DRAWABLE + detailsImg;
    }

    public PlaylistDetails(String detailsTitle, String detailsSubtitle, String detailsImg) {
        this.detailsTitle = detailsTitle;
        this.detailsSubtitle = detailsSubtitle;
        this.detailsImg = detailsImg;

    }
}
