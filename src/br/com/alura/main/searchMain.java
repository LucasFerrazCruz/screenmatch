package br.com.alura.main;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.alura.config.Envloader;
import br.com.alura.screenmatch.model.Title;
import br.com.alura.screenmatch.model.TitleOmdb;

public class searchMain {
    public static void main(String[] args) throws IOException, InterruptedException {

        Envloader envLoader = new Envloader(".env");
        String apiKey = envLoader.get("OMDB_API_KEY");

        Scanner movie = new Scanner(System.in);
        System.out.println("Digite um filme: ");
        var search = movie.nextLine();
        String url = "http://www.omdbapi.com/?s=" + search.replace(" ", "+") + "&apikey=" + apiKey;
        
        try {
            
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build();
            HttpResponse<String> response = client
            .send(request, HttpResponse.BodyHandlers.ofString());
            
            String json = response.body();
            System.out.println(json);
            
            Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .create();
            TitleOmdb titleOmdb = gson.fromJson(json, TitleOmdb.class);
            System.out.println(titleOmdb);
            
            Title title = new Title(titleOmdb);
            System.out.println("Título já convertido");
            System.out.println(title);

        } catch (NumberFormatException e) {

            System.out.println("Aconteceu um erro: " + e.getMessage());

        } catch (IllegalArgumentException e) {

            System.out.println("Ocorreu algum erro no argumento da busca: " + e.getMessage());
        }
        
        System.out.println("Programa finalizado!");
    }
}
