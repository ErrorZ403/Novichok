package com.example.utkiteam;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;


import androidx.annotation.NonNull;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;

    String[] ex_text_picture;
    String[] ex_text;
    int[] icons;


    public Adapter(Context context, String[] txt_img, String[] txt, int[] img) {
        this.context = context;

        this.ex_text_picture = txt_img;
        this.ex_text = txt;
        this.icons = img;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private static final String TAG = "MyApp";

        TextView txt_img;
        TextView txt;
        ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_img = itemView.findViewById(R.id.ex_text_picture);
            txt = itemView.findViewById(R.id.ex_text_picture_2);
            img = itemView.findViewById(R.id.ex_img_picture);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition() + 1;
                    if (pos == 1) {
                        Navigation.findNavController(v).navigate(R.id.action_firstLvlFragment2_to_instuctionFragment);
                    } else if (pos == 2) {
                        Navigation.findNavController(v).navigate(R.id.action_firstLvlFragment2_to_rulesWorkingFragment);
                    } else if (pos == 3) {
                        Navigation.findNavController(v).navigate(R.id.action_firstLvlFragment2_to_rulesEmergencySituationFragment2);
                    }

                }
            });

        }
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.example_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        holder.txt_img.setText(ex_text_picture[position]);
        holder.txt.setText(ex_text[position]);
        holder.img.setImageResource(icons[position]);
    }

    @Override
    public int getItemCount() {
        return ex_text.length;
    }
}
