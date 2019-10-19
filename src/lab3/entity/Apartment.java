package lab3.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "apartment")
public class Apartment {
    long id;
    House house;
    int number;

    public Apartment() {
    }

    public Apartment(long id, House house, int number) {
        this.id = id;
        this.house = house;
        this.number = number;
    }

    @XmlElement(name = "id")
    public long getId() {
        return id;
    }

    @XmlElement(name = "house")
    public House getHouse() {
        return house;
    }

    @XmlElement(name = "number")
    public int getNumber() {
        return number;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}