package lab3.xml;

import lab3.entity.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;

public class SaveDB {
    public static void saveHouseList(List<House> houses) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(HouseWrapper.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        HouseWrapper houseWrapper = new HouseWrapper();
        houseWrapper.setHouses(houses);

        marshaller.marshal(houseWrapper, new File("houses.xml"));
    }

    public static void saveApartmentList(List<Apartment> apartments) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(ApartmentWrapper.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        ApartmentWrapper apartmentWrapper = new ApartmentWrapper();
        apartmentWrapper.setApartments(apartments);

        marshaller.marshal(apartmentWrapper, new File("apartments.xml"));
    }

    public static void savePeopleList(List<People> people) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(PeopleWrapper.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        PeopleWrapper peopleWrapper = new PeopleWrapper();
        peopleWrapper.setPeople(people);

        marshaller.marshal(peopleWrapper, new File("people.xml"));
    }
}
