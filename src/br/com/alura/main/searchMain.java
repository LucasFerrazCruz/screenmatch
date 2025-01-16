package br.com.alura.main;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class searchMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner movie = new Scanner(System.in);
        System.out.println("Digite um filme: ");
        var search = movie.nextLine();
        String url = "http://www.omdbapi.com/?s=" + search + "&apikey=3bca80ee";
        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build();
        HttpResponse<String> response = client
            .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}
