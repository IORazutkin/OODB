package lab6.entity;

import lab6.annotation.Column;
import lab6.annotation.Entity;
import lab6.annotation.ManyToOne;

import java.util.Date;

@Entity
public class Receipt {
    long id;
    @ManyToOne
    Service service;
    @Column
    double value;
    @ManyToOne
    @Column
    Apartment apartment;
    @ManyToOne
    @Column
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