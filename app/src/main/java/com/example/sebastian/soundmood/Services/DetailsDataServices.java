package com.example.sebastian.soundmood.Services;

import com.example.sebastian.soundmood.model.PlaylistDetails;

import java.util.ArrayList;

/**
 * Created by Sebastian on 18.12.2017.
 */

public class DetailsDataServices {
    private static final DetailsDataServices ourInstance = new DetailsDataServices();

    public static DetailsDataServices getInstance() {
        return ourInstance;
    }

    private DetailsDataServices() {
    }

    // again, write until your fingers drop
    public ArrayList<PlaylistDetails> getChillDetails(){

        ArrayList<PlaylistDetails> list = new ArrayList<>();
        list.add(new PlaylistDetails("Best of Chillout Music", "24/7 Music Livestream", "details_chill_1_img" ));
        list.add(new PlaylistDetails("Beats to Relax", "Lofi Hip Hop & Ambient", "details_chill_2_img" ));
        list.add(new PlaylistDetails("Christmas Chill", "Best of Christmas Spirit", "details_chill_3_img" ));

        return list;
    }




}
