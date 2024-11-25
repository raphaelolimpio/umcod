package com.example.guilhermealexandrepereira_lima;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.ArrayList;

public class PoderHabilidadeAdapter extends ArrayAdapter<AnimalList.AnimalComPoder> {

    public PoderHabilidadeAdapter(Context context, ArrayList<AnimalList.AnimalComPoder> listaAnimaisComPoder) {
        super(context, 0, listaAnimaisComPoder);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.poder_habilidade, parent, false);
        }

        AnimalList.AnimalComPoder item = getItem(position);

        ImageView imageViewAnimal = convertView.findViewById(R.id.imageViewAnimal);
        TextView textViewNomeAnimal = convertView.findViewById(R.id.textViewNomeAnimal);
        TextView textViewValorPalavra = convertView.findViewById(R.id.textViewValorPalavra);
        TextView textViewValorNome = convertView.findViewById(R.id.textViewValorNome);
        TextView textViewPoderAnimal = convertView.findViewById(R.id.textViewPoderAnimal);

        if (item != null) {

            Animal animal = item.getAnimal();
            PoderHabilidade poder = item.getPoderHabilidade();

            imageViewAnimal.setImageResource(animal.getImagem());
            textViewNomeAnimal.setText(animal.getNomeAnimal());
            textViewValorNome.setText("Valor Nome: " + poder.ValorNome());
            textViewValorPalavra.setText("Valor Palavra: " + poder.ValorPalavra());
            textViewPoderAnimal.setText("Poder: " + poder.ValorTotal());

        }

        return convertView;
    }
}