package com.app.vista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.app.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MIcarritoDecompras#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MIcarritoDecompras extends Fragment {



    public MIcarritoDecompras() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static MIcarritoDecompras newInstance(String param1, String param2) {
        MIcarritoDecompras fragment = new MIcarritoDecompras();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_m_icarrito_decompras, container, false);
    }
}