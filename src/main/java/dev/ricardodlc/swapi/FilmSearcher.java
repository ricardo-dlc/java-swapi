package dev.ricardodlc.swapi;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class FilmSearcher {
    public StarWarsFilm searchEpisode(int episodeId) {
        String API_BASE_URL = "https://swapi.py4e.com/api/films/";
        HttpClient client = HttpClient.newHttpClient();

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        try {
            URI uri = URI.create(API_BASE_URL + episodeId + "/");
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .build();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return gson.fromJson(response.body(), StarWarsFilm.class);
            } else if (response.statusCode() == 404) {
                throw new RuntimeException("Episode not found.");
            } else {
                throw new RuntimeException("Server response error.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
