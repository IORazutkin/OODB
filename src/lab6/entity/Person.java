package lab6.entity;

import lab6.annotation.Column;
import lab6.annotation.Entity;
import lab6.annotation.ManyToOne;

import java.sql.Date;

@Entity
public class Person {
    long person_id;
    @Column
    String full_name;
    @Column
    Date birth_day;
    @ManyToOne
    @Column
    Apartment person_apartment;

    public Person(long id, String fullName, Date birthDay, Apartment apartment) {
        this.person_id = id;
        this.full_name = fullName;
        this.birth_day = birthDay;
        this.person_apartment = apartment;
    }

    public long getPerson_id() {
        return person_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public Date getBirth_day() {
        return birth_day;
    }

    public Apartment getPerson_apartment() {
        return person_apartment;
    }

    @Override
    public String toString() {
        return "Person{" +
                "person_id=" + person_id +
                ", full_name='" + full_name + '\'' +
                ", birth_day=" + birth_day +
                ", person_apartment=" + person_apartment +
                '}';
    }

    void printAddress() {
        System.out.println(person_apartment.apartment_house.address + " " + person_apartment.apartment_number);
    }
}