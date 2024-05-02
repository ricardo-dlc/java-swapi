package dev.ricardodlc.swapi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FilmSearcher filmSearcher = new FilmSearcher();
        FileGenerator fileGenerator = new FileGenerator();

        try {
            System.out.print("Enter an episode number: ");
            int userInput = Integer.valueOf(scanner.nextLine());

            StarWarsFilm film = filmSearcher.searchEpisode(userInput);
            fileGenerator.toJsonFile(film, film.title() + ".json");
        } catch (NumberFormatException e) {
            System.out.println("Cannot get a number " + e.getLocalizedMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error ocurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}