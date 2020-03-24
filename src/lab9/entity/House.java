package lab9.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class House {
    @Id
    @Column(name="house_id")
    long house_id;
    @Column
    String address;
    @Column
    @OneToMany
    List<Apartment> apartment;

    public House() {}

    public House(long id, String address) {
        this.house_id = id;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Apartment> getApartments() {
        return apartment;
    }

    public void setApartments(List<Apartment> apartments) {
        this.apartment = apartments;
    }

    public long getHouse_id() {
        return house_id;
    }

    @Override
    public String toString() {
        return "House{" +
                "house_id=" + house_id +
                ", address='" + address + '\'' +
                '}';
    }
}