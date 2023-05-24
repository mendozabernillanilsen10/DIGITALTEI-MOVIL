package com.app.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TodoslosProductos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TodoslosProductos extends Fragment {



    public TodoslosProductos() {
        // Required empty public constructor
    }



    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TodoslosProductos.
     */
    // TODO: Rename and change types and number of parameters
    public static TodoslosProductos newInstance(String param1, String param2) {
        TodoslosProductos fragment = new TodoslosProductos();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_todoslos_productos, container, false);
    }
}