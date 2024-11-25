package com.example.guilhermealexandrepereira_lima;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.guilhermealexandrepereiralimaapp.Animal_Adapter;

import java.util.ArrayList;

public class PaginaInicial extends AppCompatActivity {

    private ListView listViewAnimais;
    private ArrayList<AnimalComPoder> animalComPoder;
    private Animal_Adapter adapter;
    //  private PoderHabilidadeAdapter adapter1;
    private Button buttonAnimais, buttonCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_inicial);

        listViewAnimais = findViewById(R.id.listViewAnimais);

        AnimalList animalList = new AnimalList();
        animaisComPoder = (ArrayList<AnimalComPoder>) animalList.getListaAnimais();
        // Add animals to the list here
        animalList.add(new Animal(getString(R.string.rato), R.drawable.rato_signo_zodiaco_chines, getString(R.string.palavraRato)));
        animalList.add(new Animal(getString(R.string.bufalo), R.drawable.boi_zodiaco_signo_chines, getString(R.string.palavraBufalo)));
        animalList.add(new Animal(getString(R.string.tigre), R.drawable.signo_zodiaco_tigre, getString(R.string.palavraTigre)));
        animalList.add(new Animal(getString(R.string.coelho), R.drawable.coelho_signo_chines_zodiaco, getString(R.string.palavraCoelho)));
        animalList.add(new Animal(getString(R.string.dragao), R.drawable.signo_zodiaco_dragao, getString(R.string.palavraDragao)));
        animalList.add(new Animal(getString(R.string.serpente), R.drawable.serpente_cobra_signo_chines, getString(R.string.plavraSerpente)));
        animalList.add(new Animal(getString(R.string.cavalo), R.drawable.cavalo_signo_zodiaco, getString(R.string.palavraCavalo)));
        animalList.add(new Animal(getString(R.string.cabra), R.drawable.cabra_signo_chines, getString(R.string.palavraCabra)));
        animalList.add(new Animal(getString(R.string.macaco), R.drawable.signo_chines_macaco_personalidade, getString(R.string.palavraMacaco)));
        animalList.add(new Animal(getString(R.string.galo), R.drawable.galo_signo_chines, getString(R.string.palavraGalo)));
        animalList.add(new Animal(getString(R.string.cao), R.drawable.cachorro_signo_zodiaco_chines, getString(R.string.palavraCao)));
        animalList.add(new Animal(getString(R.string.javali), R.drawable.javali_signo_chines_zodiaco, getString(R.string.palavraJavali)));

        adapter = new Animal_Adapter(this, animaisComPoder);
        listViewAnimais.setAdapter(adapter);

        listViewAnimais.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AnimalComPoder animalComPoder = (AnimalComPoder) parent.getItemAtPosition(position);
                Intent intent = new Intent(PaginaInicial.this, Animal_Status.class);
                intent.putExtra("nome", animal.getNomeAnimal());
                intent.putExtra("imagem", animal.getImagem());
                intent.putExtra("palavra", animal.getPalavraAnimal());
                startActivity(intent);
            }
        });


        buttonAnimais = findViewById(R.id.buttonAnimais);
        buttonAnimais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogAnimais();
            }
        });
        buttonCadastrar = findViewById(R.id.buttonCadastro);
    buttonCadastrar.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(PaginaInicial.this, SelecionaAnimaisActivity.class);
        intent.putExtra("animais", animaisComPoder);
        startActivity(intent);
    }
});


    }

    private void showDialogAnimais() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_animais, null);
        ListView listViewDialogAnimais = dialogView.findViewById(R.id.listViewDialogAnimais);

        PoderHabilidadeAdapter adapter1 = new PoderHabilidadeAdapter(this, animaisComPoder);
        listViewDialogAnimais.setAdapter(adapter1);

        builder.setView(dialogView);
        builder.setTitle("Animais e seus Atributos");
        builder.setPositiveButton("OK", null);
        builder.create().show();

    }
}