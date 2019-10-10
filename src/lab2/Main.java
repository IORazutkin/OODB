package lab2;

import lab1.Apartment;
import lab1.House;
import lab1.People;

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
