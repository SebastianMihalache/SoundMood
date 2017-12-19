package com.example.sebastian.soundmood.Services;

import com.example.sebastian.soundmood.model.Playlist;

import java.util.ArrayList;

/**
 * Created by Sebastian on 17.12.2017.
 */

public class DataServices {
    private static final DataServices ourInstance = new DataServices();

    public static DataServices getInstance() {
        return ourInstance;
    }

    private DataServices() {
    }



    // make the data manually because you don't have it on the internet like all the cool boys
    public ArrayList<Playlist> getPlaylistTop(){

        ArrayList<Playlist> list = new ArrayList<>();
        list.add(new Playlist("Chill", "chill_img"));
        list.add(new Playlist("Traveling", "travel_img"));
        list.add(new Playlist("Going out", "going_out_img"));

        return list;
    }

    public ArrayList<Playlist> getPlaylistMiddle(){

        ArrayList<Playlist> list = new ArrayList<>();
        list.add(new Playlist("Happy", "happy_img"));
        list.add(new Playlist("Grateful", "grateful_img"));
        list.add(new Playlist("Focused", "focused_img"));

        return list;
    }

    public ArrayList<Playlist> getPlaylistBottom(){

        ArrayList<Playlist> list = new ArrayList<>();
        list.add(new Playlist("Country music", "country_img"));
        list.add(new Playlist("Jazz music", "jazz_img"));
        list.add(new Playlist("Piano music", "piano_img"));

        return list;
    }
}
