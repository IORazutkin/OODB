package lab5.entity;

import java.util.Date;

public class Receipt {
    long id;
    Service service;
    double value;
    Apartment apartment;
    Person payer;
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