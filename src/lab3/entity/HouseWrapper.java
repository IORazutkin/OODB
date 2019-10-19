package lab3.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "houseWrapper")
public class HouseWrapper {
    private List<House> houses;

    public HouseWrapper() {
    }

    @XmlElementWrapper(name = "houses")
    @XmlElement(name = "house")
    public List<House> getHouses() {
        return houses;
    }

    public void setHouses(List<House> houses) {
        this.houses = houses;
    }
}
