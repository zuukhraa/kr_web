package ru.itis.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClientParse {
    public String getTimeBus(String garagNumb) {
        String beginUrl = "https://data.kzn.ru:8082/api/v0/dynamic_datasets/bus/" + garagNumb + ".json";
        try {
            URL url = new URL(beginUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestMethod("GET");
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            )) {
                StringBuilder content = new StringBuilder();
                String input;
                while ((input = reader.readLine()) != null) {
                    content.append(input);
                }
                connection.disconnect();
                return content.toString();
            }
            catch (Exception e){
                return "Сайт перегружен";
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
