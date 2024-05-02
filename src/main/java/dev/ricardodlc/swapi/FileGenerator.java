package dev.ricardodlc.swapi;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class FileGenerator {
    public void toJsonFile(StarWarsFilm content, String fileName) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        String json = gson.toJson(content);
        writer.write(json);
        writer.close();
    }
}
