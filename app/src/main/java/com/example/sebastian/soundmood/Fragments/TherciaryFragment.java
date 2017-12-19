package com.example.sebastian.soundmood.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sebastian.soundmood.Adaptor.DetailsAdaptor;
import com.example.sebastian.soundmood.Adaptor.MainAdaptor;
import com.example.sebastian.soundmood.R;
import com.example.sebastian.soundmood.Services.DataServices;
import com.example.sebastian.soundmood.Services.DetailsDataServices;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TherciaryFragment.OnTherciaryFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TherciaryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TherciaryFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnTherciaryFragmentInteractionListener mListener;

    public TherciaryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TherciaryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TherciaryFragment newInstance(String param1, String param2) {
        TherciaryFragment fragment = new TherciaryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_therciary, container, false);

        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recycler_content);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        DetailsAdaptor adaptor = new DetailsAdaptor(DetailsDataServices.getInstance().getChillDetails());
        recyclerView.setAdapter(adaptor);


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onTherciaryFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnTherciaryFragmentInteractionListener) {
            mListener = (OnTherciaryFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
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
    public interface OnTherciaryFragmentInteractionListener {
        // TODO: Update argument type and name
        void onTherciaryFragmentInteraction(Uri uri);
    }
}
