package lab2;

import lab2.entity.Apartment;
import lab2.entity.House;
import lab2.entity.People;
import lab2.json.LoadDB;
import lab2.json.SaveDB;
import lab2.service.PeopleService;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<House> houseList = LoadDB.loadHouses();
        List<Apartment> apartmentList = LoadDB.loadApartments();
        List<People> peopleList = LoadDB.loadPeople();

        peopleList.add(PeopleService.createPerson(peopleList.size(), houseList, apartmentList));

        SaveDB.saveHouseList(houseList);
        SaveDB.saveApartmentList(apartmentList);
        SaveDB.savePeopleList(peopleList);
    }
}