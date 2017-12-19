package com.example.sebastian.soundmood.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sebastian.soundmood.R;
import com.example.sebastian.soundmood.model.PlaylistDetails;

/**
 * Created by Sebastian on 18.12.2017.
 */

public class DetailsAdaptorHolder extends RecyclerView.ViewHolder {

    private ImageView image;
    private TextView title;
    private TextView subtitle;

    public DetailsAdaptorHolder(View itemView) {
        super(itemView);

        this.image = (ImageView) itemView.findViewById(R.id.image_details);
        this.title = (TextView) itemView.findViewById(R.id.titlu_descriere);
        this.subtitle = (TextView) itemView.findViewById(R.id.subtitlu_descriere);
    }

    // updating the title, image and subtitle
    public void updateDetailsUi (PlaylistDetails playlistDetails){
        String url = playlistDetails.getDetailsImg();
        int resource = image.getResources().getIdentifier(url, null, image.getContext().getPackageName());
        image.setImageResource(resource);

        title.setText(playlistDetails.getDetailsTitle());
        subtitle.setText(playlistDetails.getDetailsSubtitle());

    }
}
