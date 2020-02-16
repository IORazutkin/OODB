package lab7.entity;

import lab7.annotation.Column;
import lab7.annotation.Entity;
import lab7.annotation.ManyToOne;
import lab7.annotation.Id;

import java.util.Date;

@Entity
public class Receipt {
    @Id
    long id;
    @Column
    @ManyToOne
    Service service;
    @Column
    double value;
    @Column
    @ManyToOne
    Apartment apartment;
    @Column
    @ManyToOne
    Person payer;
    @Column
    Date formationDate, paymentDate;

    double getPrice() {
        return service.price * value;
    }

    void setPayer(Person payer) {
        this.payer = payer;
    }

    boolean checkPaymentStatus() {
        return paymentDate == null;
    }
}