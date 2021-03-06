package lab7.entity;

import lab7.annotation.Column;
import lab7.annotation.Entity;
import lab7.annotation.Id;

@Entity
public class Service {
    @Id
    @Column(name="id")
    long id;
    @Column
    String title;
    @Column
    float price;
    @Column
    String unit;
}