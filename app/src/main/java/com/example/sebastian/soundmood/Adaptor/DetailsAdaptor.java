package com.example.sebastian.soundmood.Adaptor;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sebastian.soundmood.Holder.DetailsAdaptorHolder;
import com.example.sebastian.soundmood.R;
import com.example.sebastian.soundmood.model.PlaylistDetails;

import java.util.ArrayList;

/**
 * Created by Sebastian on 18.12.2017.
 */

public class DetailsAdaptor extends RecyclerView.Adapter<DetailsAdaptorHolder> {

    // store the data in the ArrayList
    private ArrayList<PlaylistDetails> playlistDetails;

    public DetailsAdaptor(ArrayList<PlaylistDetails> playlistDetails) {
        this.playlistDetails = playlistDetails;
    }

    @Override
    public DetailsAdaptorHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // card layout
        View detailsCard = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_details, parent, false);
        return new DetailsAdaptorHolder(detailsCard);
    }

    @Override
    public void onBindViewHolder(DetailsAdaptorHolder holder, int position) {

        // updating the cards
        final PlaylistDetails playlistDetail = playlistDetails.get(position);
        holder.updateDetailsUi(playlistDetail);


    }

    @Override
    public int getItemCount() {
        return playlistDetails.size();
    }
}
