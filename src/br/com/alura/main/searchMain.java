package br.com.alura.main;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.alura.config.Envloader;
import br.com.alura.screenmatch.model.Title;
import br.com.alura.screenmatch.model.TitleOmdb;
import br.com.alura.screenmatch.model.TitleOmdbResponse;

public class SearchMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        
        Envloader envLoader = new Envloader(".env");
        String apiKey = envLoader.get("OMDB_API_KEY");
        
        String search = "";
        List<TitleOmdb> titles = new ArrayList<>();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        
        while (!search.equalsIgnoreCase("sair")) {
            
            Scanner movie = new Scanner(System.in);
            System.out.println("Digite um filme: ");
            search = movie.nextLine();

            if(search.equalsIgnoreCase("sair")) {
                break;
            }

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
                
                TitleOmdbResponse titleOmdbResponse = gson.fromJson(json, TitleOmdbResponse.class);
                
                if (titleOmdbResponse.search() != null && !titleOmdbResponse.search().isEmpty()) {
                    
                    TitleOmdb firstTitle = titleOmdbResponse.search().get(0);
                    
                    Title title = new Title(firstTitle.title(), firstTitle.getYearAsInt());
                    System.out.println("Título já convertido:");
                    System.out.println(title);
                    
                    titles.add(firstTitle);
                } else {
                    System.out.println("Nenhum filme encontrado para a pesquisa.");
                }
                
            } catch (NumberFormatException e) {
                
                System.out.println("Aconteceu um erro: " + e.getMessage());
                
            } catch (IllegalArgumentException e) {
                
                System.out.println("Ocorreu algum erro no argumento da busca: " + e.getMessage());
            }
            
        }

        System.out.println(titles);

        FileWriter writer = new FileWriter("movies.json");
        writer.write(gson.toJson(titles));
        writer.close();

        System.out.println("Programa finalizado!");
    }
}
