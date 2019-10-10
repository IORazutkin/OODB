package lab2;

import com.google.gson.Gson;
import lab1.Apartment;
import lab1.House;
import lab1.People;
import lab1.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoadDB {
    public static List<House> loadHouses() throws IOException {
        String pStr;
        File file = new File("houses.json");

        if (file.exists()) {
            pStr = new String(Files.readAllBytes(file.toPath()));

            Gson gson = new Gson();

            House[] houses = gson.fromJson(pStr, House[].class);
            return new ArrayList<>(Arrays.asList(houses));
        } else {
            System.out.println("File houses.json not find");
        }

        return new ArrayList<>();
    }

    public static List<Apartment> loadApartments() throws IOException {
        String pStr;
        File file = new File("apartments.json");

        if (file.exists()) {
            pStr = new String(Files.readAllBytes(file.toPath()));

            Gson gson = new Gson();

            Apartment[] apartments = gson.fromJson(pStr, Apartment[].class);
            return new ArrayList<>(Arrays.asList(apartments));
        } else {
            System.out.println("File apartments.json not find");
        }

        return new ArrayList<>();
    }

    public static List<People> loadPeople() throws IOException {
        String pStr;
        File file = new File("people.json");

        if (file.exists()) {
            pStr = new String(Files.readAllBytes(file.toPath()));

            Gson gson = new Gson();

            People[] people = gson.fromJson(pStr, People[].class);
            return new ArrayList<>(Arrays.asList(people));
        } else {
            System.out.println("File people.json not find");
        }

        return new ArrayList<>();
    }
}
