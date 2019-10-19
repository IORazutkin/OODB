package lab3.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name = "man")
public class People {
    long id;
    String fullName;
    Date birthDay;
    Apartment apartment;

    public People() {
    }

    public People(long id, String fullName, Date birthDay, Apartment apartment) {
        this.id = id;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.apartment = apartment;
    }

    void printAddress() {
        System.out.println(apartment.house.address + " " + apartment.number);
    }

    @XmlElement(name = "id")
    public long getId() {
        return id;
    }

    @XmlElement(name = "fullName")
    public String getFullName() {
        return fullName;
    }

    @XmlElement(name = "birthDay")
    public Date getBirthDay() {
        return birthDay;
    }

    @XmlElement(name = "apartment")
    public Apartment getApartment() {
        return apartment;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }
}