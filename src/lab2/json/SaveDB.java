package lab2.json;

import com.google.gson.Gson;
import lab2.entity.Apartment;
import lab2.entity.House;
import lab2.entity.People;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class SaveDB {
    public static void saveHouseList(List<House> houses) throws IOException {
        if (houses != null && houses.size() > 0) {
            Gson gson = new Gson();
            String housesAsJson = gson.toJson(houses);
            try (OutputStream os = new FileOutputStream(new File("houses.json"))) {
                os.write(housesAsJson.getBytes("UTF-8"));
                os.flush();
            }
        }
    }

    public static void saveApartmentList(List<Apartment> apartments) throws IOException {
        if (apartments != null && apartments.size() > 0) {
            Gson gson = new Gson();
            String apartmentsAsJson = gson.toJson(apartments);
            try (OutputStream os = new FileOutputStream(new File("apartments.json"))) {
                os.write(apartmentsAsJson.getBytes("UTF-8"));
                os.flush();
            }
        }
    }

    public static void savePeopleList(List<People> people) throws IOException {
        if (people != null && people.size() > 0) {
            Gson gson = new Gson();
            String peopleAsJson = gson.toJson(people);
            try (OutputStream os = new FileOutputStream(new File("people.json"))) {
                os.write(peopleAsJson.getBytes("UTF-8"));
                os.flush();
            }
        }
    }
}
