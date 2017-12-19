package com.example.sebastian.soundmood.Adaptor;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sebastian.soundmood.Activities.MainActivity;
import com.example.sebastian.soundmood.Holder.AdaptorHolder;
import com.example.sebastian.soundmood.R;
import com.example.sebastian.soundmood.model.Playlist;

import java.util.ArrayList;

/**
 * Created by Sebastian on 17.12.2017.
 */

public class MainAdaptor extends RecyclerView.Adapter<AdaptorHolder> {

    //storing the data
    private ArrayList<Playlist> playlists;

    public MainAdaptor(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
    }

    @Override
    public AdaptorHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //set the card layout on the holder
        View playlistCard = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_playlist, parent, false);
        return new AdaptorHolder(playlistCard);
    }

    @Override
    public void onBindViewHolder(AdaptorHolder holder, final int position) {

        //grab the position and update the cards
        final Playlist playlist = playlists.get(position);
        holder.updateUI(playlist);

        //grab the position of the current view
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //load the details fragment
                MainActivity.getMainActivity().loadDetailsScreen(playlist);

            }
        });

    }

    @Override
    public int getItemCount() {
        return playlists.size();
    }
}
