public class Receipt {
    long id;
    Service service;
    double value;
    Apartment apartment;
    People payer;

    double getPrice() {
        return service.price * value;
    }

    void setPayer(People payer) {
        this.payer = payer;
    }
}