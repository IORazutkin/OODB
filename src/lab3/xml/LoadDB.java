package lab3.xml;

import lab3.entity.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LoadDB {
    public static List<House> loadHouses() {
        try {
            JAXBContext context = JAXBContext.newInstance(HouseWrapper.class);
            Unmarshaller un = context.createUnmarshaller();

            File file = new File("houses.xml");
            if (file.exists()) {
                List<House> list = ((HouseWrapper) un.unmarshal(file)).getHouses();
                return list;
            }

            return new ArrayList<>();
        } catch (JAXBException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static List<Apartment> loadApartments() {
        try {
            JAXBContext context = JAXBContext.newInstance(ApartmentWrapper.class);
            Unmarshaller un = context.createUnmarshaller();

            File file = new File("apartment.xml");
            if (file.exists()) {
                List<Apartment> list = ((ApartmentWrapper) un.unmarshal(file)).getApartments();
                return list;
            }

            return new ArrayList<>();
        } catch (JAXBException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static List<People> loadPeople() {
        try {
            JAXBContext context = JAXBContext.newInstance(PeopleWrapper.class);
            Unmarshaller un = context.createUnmarshaller();

            File file = new File("people.xml");
            if (file.exists()) {
                return ((PeopleWrapper) un.unmarshal(file)).getPeople();
            }

            return new ArrayList<>();
        } catch (JAXBException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
