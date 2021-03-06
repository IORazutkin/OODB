package lab7.entity;

import lab7.annotation.ManyToOne;
import lab7.annotation.Column;
import lab7.annotation.Entity;
import lab7.annotation.Id;

@Entity
public class Apartment {
    @Id
    @Column(name="apartment_id")
    Long apartment_id;
    /*@Column
    @ManyToOne
    House apartment_house;*/
    @Column
    int apartment_number;

    public Apartment(long id, House house, int number) {
        this.apartment_id = id;
        //this.apartment_house = house;
        this.apartment_number = number;
    }

    /*public House getApartment_house() {
        return apartment_house;
    }*/

    public int getApartment_number() {
        return apartment_number;
    }

    public long getApartment_id() {
        return apartment_id;
    }

    /*@Override
    public String toString() {
        return "Apartment{" +
                "apartment_id=" + apartment_id +
                ", apartment_house=" + apartment_house +
                ", apartment_number=" + apartment_number +
                '}';
    }*/
}