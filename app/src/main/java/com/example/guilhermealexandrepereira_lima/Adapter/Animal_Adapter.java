package com.example.guilhermealexandrepereiralimaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.guilhermealexandrepereira_lima.AnimalList;
import com.example.guilhermealexandrepereira_lima.R;

import java.util.ArrayList;

public class Animal_Adapter extends ArrayAdapter<AnimalList.AnimalComPoder> {
    public Animal_Adapter(Context context, ArrayList<AnimalList.AnimalComPoder> animaisComPoder) {
        super(context, 0, animaisComPoder);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.lista_de_animais, parent, false);
        }

        AnimalList.AnimalComPoder item = getItem(position);

        ImageView imageViewAnimal = convertView.findViewById(R.id.imageViewAnimal);
        TextView textViewNomeAnimal = convertView.findViewById(R.id.textViewNomeAnimal);
        TextView textViewPoderTotal = convertView.findViewById(R.id.textViewPoderTotal);  // Exibindo o poder total

        if (item != null) {
            Animal animal = item.getAnimal();
            imageViewAnimal.setImageResource(animal.getImagem());
            textViewNomeAnimal.setText(animal.getNomeAnimal());
            textViewPoderTotal.setText("Poder Total: " + item.getPoderHabilidade().ValorTotal());
        }

        return convertView;
    }
}
