package com.example.sebastian.soundmood.Fragments;

import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sebastian.soundmood.Adaptor.MainAdaptor;
import com.example.sebastian.soundmood.R;
import com.example.sebastian.soundmood.Services.DataServices;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SecondaryFragment.OnSecondaryFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SecondaryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondaryFragment extends Fragment {

    private static final String ARG_PLAYLIST_TYPE = "playlist_type";



    // set the different playlist types for the different fragments
    public static final int PLAYLIST_TYPE_TOP = 0;
    public static final int PLAYLIST_TYPE_MIDDLE = 1;
    public static final int PLAYLIST_TYPE_BOTTOM = 2;

    private int playlistType;

    private OnSecondaryFragmentInteractionListener mListener;

    public SecondaryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param playlistType The type of playlist.
     * @return A new instance of fragment SecondaryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SecondaryFragment newInstance(int playlistType) {
        SecondaryFragment fragment = new SecondaryFragment();
        Bundle args = new Bundle();

        // saving the type of playlist in the bundle
        args.putInt(ARG_PLAYLIST_TYPE, playlistType);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            // getting the type of playlist from the bundle
            playlistType = getArguments().getInt(ARG_PLAYLIST_TYPE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_secondary, container, false);

        // find the recycler view
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recycler_content);
        recyclerView.setHasFixedSize(true);

        // set recycler orientation
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

        // set the recycler to the adapter and choose a playlist type for each
        MainAdaptor adaptor;

        if (playlistType == PLAYLIST_TYPE_TOP){
            adaptor = new MainAdaptor(DataServices.getInstance().getPlaylistTop());

        } else if (playlistType == PLAYLIST_TYPE_MIDDLE){
            adaptor = new MainAdaptor(DataServices.getInstance().getPlaylistMiddle());

        } else {
            adaptor = new MainAdaptor(DataServices.getInstance().getPlaylistBottom());

        }

        recyclerView.setAdapter(adaptor);

        // set item decoration (fancy way of saying the padding thinggy between the cards)
        recyclerView.addItemDecoration(new HorizontalItemDecorator(45));

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onSecondaryFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnSecondaryFragmentInteractionListener) {
            mListener = (OnSecondaryFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnSecondaryFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnSecondaryFragmentInteractionListener {
        // TODO: Update argument type and name
        void onSecondaryFragmentInteraction(Uri uri);
    }
}


        class HorizontalItemDecorator extends RecyclerView.ItemDecoration {
    private int spacer;

            public HorizontalItemDecorator(int spacer) {
                this.spacer = spacer;
            }

            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.right = spacer;
            }
        }