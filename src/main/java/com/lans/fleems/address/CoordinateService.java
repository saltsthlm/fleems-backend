package com.lans.fleems.address;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CoordinateService {

    public static Address coordinatesToAddress(Coordinate coord) throws IOException {
        String urlString = String.format("https://nominatim.openstreetmap.org/reverse?lat=%f&lon=%f&format=json", coord.getX(), coord.getY());
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("User-Agent", "fleems");

        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            throw new IOException("Error fetching address: " + responseCode);
        }

        Scanner scanner = new Scanner(url.openStream());
        StringBuilder inline = new StringBuilder();
        while (scanner.hasNext()) {
            inline.append(scanner.nextLine());
        }
        scanner.close();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(inline.toString());
        JsonNode addressNode = root.path("address");

        Address address = new Address();
        address.setCity(addressNode.path("city").asText());
        address.setCountry(addressNode.path("country").asText());
        address.setHouseNumber(addressNode.path("house_number").asText());
        address.setPostcode(addressNode.path("postcode").asText());
        address.setRoad(addressNode.path("road").asText());

        return address;
    }

    public static String addressToJson(Address address) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(address);
    }

    public static Coordinate coordinateStringToCoordinate(String coord) {
        String[] parts = coord.split(",");
        return new Coordinate(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]));
    }

    public static Address coordinateStringToJsonString(String coord){
        Coordinate coordinate = coordinateStringToCoordinate(coord);
        try {
            Address address = coordinatesToAddress(coordinate);
            return address;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
