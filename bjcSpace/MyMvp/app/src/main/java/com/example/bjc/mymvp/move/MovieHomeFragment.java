package com.example.bjc.mymvp.move;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bjc.mymvp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieHomeFragment extends Fragment {


    public MovieHomeFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

}
