package dev.ricardodlc.swapi;

public record StarWarsFilm(
        String title,
        int episode_id,
        String opening_crawl,
        String director,
        String producer,
        String release_date) {
}
