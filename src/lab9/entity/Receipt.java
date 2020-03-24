package lab9.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Receipt {
    @Id
    @Column(name="id")
    long id;
    @ManyToOne
    Service service;
    @Column
    double value;
    @ManyToOne
    Apartment apartment;
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