package org.example.model;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Model {
    static String root = "http://localhost:8080/";
    static String allPaises = root + "paises";
    static String paisById = root + allPaises + "/";
    static String paisAdd = root + "add";
    static String paisByCodigo = root + "codigo" + "/";
    static String paisUpdate = root + "update" + "/";
    static String sedesQuery = root + "sedes";

    public static HttpResponse<String> getAllPaises() {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(allPaises))
                .GET()
                .build();

        HttpResponse<String> response;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return response;
    }

    public static HttpResponse<String> getPaisById(String id) {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(paisById + id))
                .GET()
                .build();

        HttpResponse<String> response;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return response;
    }
}
