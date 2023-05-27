package com.example.utkiteam.App;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.utkiteam.R;


public class MapFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageButton lvl1 = getView().findViewById(R.id.bt_lvl1);
        ImageButton lvl2 = getView().findViewById(R.id.bt_lvl2);
        ImageButton lvl3 = getView().findViewById(R.id.bt_lvl3);
        ImageButton lvl4 = getView().findViewById(R.id.bt_lvl4);
        ImageButton lvl5 = getView().findViewById(R.id.bt_lvl5);

        lvl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_mapFragment_to_firstLvlFragment2);
            }
        });
        lvl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_mapFragment_to_secondLvlFragment);
            }
        });
        lvl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_mapFragment_to_thirdLvlFragment);
            }
        });
        lvl4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_mapFragment_to_fourLvlFragment);
            }
        });
        lvl5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_mapFragment_to_fiveFragment);
            }
        });

    }
}