package lab3.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "peopleWrapper")
public class PeopleWrapper {
    private List<People> people;

    public PeopleWrapper() {
    }

    @XmlElementWrapper(name = "people")
    @XmlElement(name = "man")
    public List<People> getPeople() {
        return people;
    }

    public void setPeople(List<People> people) {
        this.people = people;
    }
}
