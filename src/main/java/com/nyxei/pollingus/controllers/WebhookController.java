package com.nyxei.pollingus.controllers;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.json.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WebhookController {
    public static final String URI_rappel = "https://graph.facebook.com/v16.0/102062986090216/messages";
    public static final String Token = "Bearer EAAGYN0OOscYBAL9uiOLYo3jlVfFdyRf2cZBilnZCA166sdR836ZC73pz3EX2q0wJiHUQwaZCxMDsxbUSGofrIGy8FSw6ZAbBiuZCq8PN6dpl1zKPK7uZBDdMUxZAyGBcDgfwXtZBMglQt4wpPLHU5ZB2aZADVDZCtyRs3nJEpJX5F7vzuNNzuWVvhZC38KcETvreTKqa6twzLZA0ATBLAZAx6qZBc3mWDMJdjJQp8XwZD";
    public static final String Json = "application/json";
    public static final String Message = "{ \"messaging_product\": \"whatsapp\", \"to\": \"237694219581\", \"type\": \"template\", \"template\": { \"name\": \"hello_world\", \"language\": { \"code\": \"en_US\" } } }";

        public static void envoitemplate (){

            try {
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(new URI(URI_rappel))
                        .header("Authorization", Token)
                        .header("Content-Type",Json )
                        .POST(HttpRequest.BodyPublishers.ofString(Message))
                        .build();
                HttpClient http = HttpClient.newHttpClient();
                HttpResponse<String> response = http.send(request, HttpResponse.BodyHandlers.ofString());
                int statusCode = response.statusCode();
                if (statusCode >= 400) {
                    // Gérer l'erreur
                    System.out.println("La requête a échoué avec le code " + statusCode);
                }
                } catch (URISyntaxException | IOException | InterruptedException e) {
                     e.printStackTrace();
                }
        }
}
