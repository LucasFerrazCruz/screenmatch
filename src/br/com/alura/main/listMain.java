package br.com.alura.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import br.com.alura.screenmatch.model.Movie;
import br.com.alura.screenmatch.model.Serie;
import br.com.alura.screenmatch.model.Title;

public class ListMain {
    public static void main(String[] args) {
        Movie myMovie = new Movie("Poderoso chefão", 1970);
        myMovie.evaluate(9);
        Movie filmeDoLucas = new Movie("Até o último homem", 2010);
        myMovie.evaluate(10);
        Serie serie = new Serie("Lost", 1990);

        ArrayList<Title> list = new ArrayList<>();
        list.add(myMovie);
        list.add(filmeDoLucas);
        list.add(serie);

        for (Title item : list) {
            System.out.println(item.getName());
            if (item instanceof Movie movie && movie.getClassification() > 2) {
                System.out.println("Classificação: " + movie.getClassification());
            }
        }

        ArrayList<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Paulo");
        buscaPorArtista.add("Jacqueline");
        System.out.println(buscaPorArtista);

        Collections.sort(buscaPorArtista);
        System.out.println("Depois da ordenação");
        System.out.println(buscaPorArtista);
        System.out.println("Lista de títulos ordenados");
        Collections.sort(list);
        System.out.println(list);
        list.sort(Comparator.comparing(Title::getYearOfRelease));
        System.out.println("Ordenando por ano");
        System.out.println(list);
    }
}
