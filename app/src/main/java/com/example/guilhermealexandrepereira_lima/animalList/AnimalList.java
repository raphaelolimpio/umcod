package com.example.guilhermealexandrepereira_lima;

import java.util.ArrayList;
import java.util.List;

public class AnimalList {
    // Lista para armazenar pares de Animal e PoderHabilidade
    private List<AnimalComPoder> listaAnimais;

    // Construtor
    public AnimalList() {
        listaAnimais = new ArrayList<>();
    }

    // Método para adicionar um animal junto com seu poder
    public void adicionarAnimal(Animal animal) {
        


        PoderHabilidade poder = new PoderHabilidade(animal.getNomeAnimal(), 
        animal.getPalavraAnimal());

        // Calcula o poder total
        int poderTotal = poder.ValorTotal();
        poder.setPodertotal(poderTotal);

        // Adiciona à lista o Animal com seu PoderHabilidade
        listaAnimais.add(new AnimalComPoder(animal, poder));
    }

    // Método para exibir todos os animais e seus poderes
    public void listarAnimais() {
        if (listaAnimais.isEmpty()) {
            System.out.println("Nenhum animal na lista! ");
            return;
        }
        for (AnimalComPoder item : listaAnimais) {
            System.out.println("Animal: " + item.getAnimal().getNomeAnimal());
            System.out.println("Poder Total: " + item.getPoderHabilidade().ValorTotal());
            System.out.println("Imagem do Animal: " + item.getImagemAnimal());
            System.out.println("-----------------------------");
        }
    }

    public List<AnimalComPoder> getListaAnimais() {
        return listaAnimais;
    }
        

    // Classe interna para armazenar Animal e PoderHabilidade juntos
    private static class AnimalComPoder {
        private final Animal animal;
        private final PoderHabilidade poderHabilidade;

        public AnimalComPoder(Animal animal, PoderHabilidade poderHabilidade) {
            this.animal = animal;
            this.poderHabilidade = poderHabilidade;
        }

        public Animal getAnimal() {
            return animal;
        }

        public PoderHabilidade getPoderHabilidade() {
            return poderHabilidade;
        }

        public int getImagemAnimal(){
            return animal.getImagem();
        }
    }
}
