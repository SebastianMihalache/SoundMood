package com.example.sebastian.soundmood.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sebastian.soundmood.R;
import com.example.sebastian.soundmood.model.Playlist;

/**
 * Created by Sebastian on 17.12.2017.
 */

public class AdaptorHolder extends RecyclerView.ViewHolder{

    private ImageView mainImage;
    private TextView title;

    public AdaptorHolder(View itemView) {
        super(itemView);

        this.mainImage = (ImageView)itemView.findViewById(R.id.image);
        this.title = (TextView)itemView.findViewById(R.id.titlu);
    }

    // update the image and text for each card
    public void updateUI (Playlist playlist){
        String url = playlist.getImgURL();
        int resource = mainImage.getResources().getIdentifier(url, null, mainImage.getContext().getPackageName());
        mainImage.setImageResource(resource);

        title.setText(playlist.getPlaylistTitle());

    }
}
