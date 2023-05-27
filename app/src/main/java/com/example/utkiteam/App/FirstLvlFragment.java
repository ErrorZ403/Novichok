package com.example.utkiteam.App;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.utkiteam.Adapter;
import com.example.utkiteam.R;


public class FirstLvlFragment extends Fragment {

    private String[] txt_img = new String[]{
            "\uD83D\uDCD2",
            "\uD83D\uDC36",
            "\uD83E\uDD37\u200D♂"
    };

    private String[] txt = new String[]{
            "Инструктаж по технике безопасности",
            "Правила работы на рабочем месте",
            "Правила эвакуации в случае ЧС"
    };

    private int[] icons = new int[]{
            R.drawable.done,
            R.drawable.ic_arrow_6arrow_next,
            R.drawable.ic_arrow_6arrow_next
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first_lvl, container, false);
    }

    RecyclerView recyclerView;
    RecyclerView.Adapter progAdapter;
    RecyclerView.LayoutManager layoutManager;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = getView().findViewById(R.id.rec_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        progAdapter = new Adapter(getActivity(), txt_img, txt, icons);
        recyclerView.setAdapter(progAdapter);

        Button bt_toMap = getView().findViewById(R.id.bt_toMap);
        bt_toMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_firstLvlFragment2_to_mapFragment);
            }
        });

    }
}