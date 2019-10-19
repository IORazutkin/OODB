package lab3;

import lab3.entity.Apartment;
import lab3.entity.House;
import lab3.entity.People;
import lab3.service.PeopleService;
import lab3.xml.LoadDB;
import lab3.xml.SaveDB;

import javax.xml.bind.JAXBException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JAXBException {
        List<House> houseList = LoadDB.loadHouses();
        List<Apartment> apartmentList = LoadDB.loadApartments();
        List<People> peopleList = LoadDB.loadPeople();

        peopleList.add(PeopleService.createPerson(peopleList.size(), houseList, apartmentList));

        SaveDB.saveHouseList(houseList);
        SaveDB.saveApartmentList(apartmentList);
        SaveDB.savePeopleList(peopleList);
    }
}