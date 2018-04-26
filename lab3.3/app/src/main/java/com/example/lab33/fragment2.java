package com.example.lab33;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 삼성 on 2018-04-27.
 */

public class fragment2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //fragment2.xml 과 연결
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment2, container, false);

        return rootView;
    }
}

