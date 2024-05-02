package dev.ricardodlc.swapi;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class FilmSearcher {
    private HttpClient client;
    private String apiBaseUrl = "https://swapi.py4e.com/api/films/";
    private Gson gson;

    public FilmSearcher() {
        this.client = HttpClient.newHttpClient();

        this.gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting()
                .create();
    }

    public StarWarsFilm searchEpisode(int episodeId) {
        StarWarsFilm result = null;

        try {
            URI uri = URI.create(this.apiBaseUrl + String.valueOf(episodeId) + "/");
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .build();
            HttpResponse<String> response = this.client.send(request, BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                result = this.gson.fromJson(response.body(), StarWarsFilm.class);
            }

            return result;
        } catch (IOException | InterruptedException e) {
            System.out.println("Error while requesting film information.");
        } catch (Exception e) {
            System.out.println("An error occured.");
        }

        return result;
    }

}
