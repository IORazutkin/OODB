package lab7.entity;

import lab7.annotation.Column;
import lab7.annotation.Entity;
import lab7.annotation.Id;

@Entity
public class House {
    @Id
    long house_id;
    @Column
    String address;

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