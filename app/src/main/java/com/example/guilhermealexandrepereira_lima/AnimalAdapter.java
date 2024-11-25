package com.example.guilhermealexandrepereira_lima;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AnimalAdapter extends BaseAdapter {
    private Context context;
    private List<AnimalComPoder> animaisComPoder;

    public AnimalAdapter(Context context, List<AnimalComPoder> animaisComPoder) {
        this.context = context;
        this.animaisComPoder = animaisComPoder;
    }

    @Override
    public int getCount() {
        return animaisComPoder.size();
    }

    @Override
    public Object getItem(int position) {
        return animaisComPoder.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_animal, parent, false);
        }

        AnimalComPoder animalComPoder = animaisComPoder.get(position);

        TextView nomeTextView = convertView.findViewById(R.id.nomeAnimal);
        TextView poderTextView = convertView.findViewById(R.id.poderAnimal);

        nomeTextView.setText(animalComPoder.getAnimal().getNomeAnimal());
        poderTextView.setText(String.valueOf(animalComPoder.getPoderHabilidade().ValorTotal()));

        return convertView;
    }
}