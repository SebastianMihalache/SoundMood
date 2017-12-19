package com.example.sebastian.soundmood.Activities;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sebastian.soundmood.Fragments.DetailsFragment;
import com.example.sebastian.soundmood.Fragments.MainFragment;
import com.example.sebastian.soundmood.Fragments.SecondaryFragment;
import com.example.sebastian.soundmood.Fragments.TherciaryFragment;
import com.example.sebastian.soundmood.R;
import com.example.sebastian.soundmood.model.Playlist;

public class MainActivity extends AppCompatActivity implements MainFragment.OnMainFragmentInteractionListener,
        SecondaryFragment.OnSecondaryFragmentInteractionListener,
        TherciaryFragment.OnTherciaryFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivity.setMainActivity(this);

        // placing the main fragment
        FragmentManager fm = getSupportFragmentManager();
        Fragment mainFragment = fm.findFragmentById(R.id.container_main);

        if (mainFragment == null) {
            mainFragment = new MainFragment();
            fm.beginTransaction()
                    .add(R.id.container_main, mainFragment)
                    .commit();
        }

}

    private static MainActivity mainActivity;

    public static MainActivity getMainActivity() {
        return mainActivity;
    }

    private static void setMainActivity(MainActivity mainActivity) {
        MainActivity.mainActivity = mainActivity;
    }

    public void loadDetailsScreen(Playlist selectPlaylist){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_main, new DetailsFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onMainFragmentInteraction(Uri uri) {

    }

    @Override
    public void onSecondaryFragmentInteraction(Uri uri) {

    }

    @Override
    public void onTherciaryFragmentInteraction(Uri uri) {

    }
}
