package com.ocr.john.omood.controller;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ocr.john.omood.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EmoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EmoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EmoFragment extends Fragment {



    public EmoFragment() {
        // Required empty public constructor
    }

    // static factory method ici pour passer les arg aux fragments
    public static EmoFragment create(String tagname) {
        Bundle args = new Bundle();
        args.putString("emotag", tagname);
        // singleton :
        EmoFragment emofrg = new EmoFragment();
        emofrg .setArguments(args);
        return emofrg;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_emo, container, false);
    }



}
