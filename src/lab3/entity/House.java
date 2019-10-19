package lab3.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "house")
public class House {
    long id;
    String address;

    public House() {
    }

    public House(long id, String address) {
        this.id = id;
        this.address = address;
    }

    @XmlElement(name = "id")
    public long getId() {
        return id;
    }

    @XmlElement(name = "address")
    public String getAddress() {
        return address;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}