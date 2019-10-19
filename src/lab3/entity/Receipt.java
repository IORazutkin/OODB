package lab3.entity;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name = "receipt")
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