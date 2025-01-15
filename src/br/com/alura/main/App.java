package br.com.alura.main;
import java.util.ArrayList;

import br.com.alura.screenmatch.calculations.RecommendationFilter;
import br.com.alura.screenmatch.model.Movie;

public class App {
    public static void main(String[] args) {

        Movie myMovie = new Movie("Poderoso chefão", 1970);
        myMovie.setDurationInMinutes(180);
        Movie filmeDoLucas = new Movie("Até o último homem", 2010);
        filmeDoLucas.setDurationInMinutes(180);
        
        myMovie.displaysTechnicalSheet();

        myMovie.evaluate(8);
        myMovie.evaluate(5);
        myMovie.evaluate(10);

        System.out.println(myMovie.getTotalReviews());
        System.out.println(myMovie.takeAverage());

        RecommendationFilter recommendationFilter = new RecommendationFilter();
        recommendationFilter.filter(myMovie);

        ArrayList<Movie> listMovies = new ArrayList<>();
        listMovies.add(myMovie);
        listMovies.add(filmeDoLucas);
        System.out.println("Tamanho da lista: " + listMovies.size());
        System.out.println("Primeiro filme: " + listMovies.get(0).getName());
        System.out.println(listMovies);
        System.out.println("toString do filme: " + listMovies.get(0).toString());
    }
}
