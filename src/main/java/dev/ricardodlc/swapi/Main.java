package dev.ricardodlc.swapi;

public class Main {
    public static void main(String[] args) {
        FilmSearcher filmSearcher = new FilmSearcher();

        StarWarsFilm film = filmSearcher.searchEpisode(1);
        if (film instanceof StarWarsFilm) {
            System.out.println(film);
        } else {
            System.out.println("No result");
        }
    }
}