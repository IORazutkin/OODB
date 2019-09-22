package lab1;

import java.util.Date;

public class Receipt {
    long id;
    Service service;
    double value;
    Apartment apartment;
    People payer;
    Date formationDate, paymentDate;

    double getPrice() {
        return service.price * value;
    }

    void setPayer(People payer) {
        this.payer = payer;
    }

    boolean checkPaymentStatus() {
        return paymentDate == null;
    }
}