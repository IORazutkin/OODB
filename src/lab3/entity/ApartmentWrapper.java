package lab3.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "apartmentWrapper")
public class ApartmentWrapper {
    private List<Apartment> apartments;

    public ApartmentWrapper() {
    }

    @XmlElementWrapper(name = "apartments")
    @XmlElement(name = "apartment")
    public List<Apartment> getApartments() {
        return apartments;
    }

    public void setApartments(List<Apartment> apartments) {
        this.apartments = apartments;
    }
}
