package lab9.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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