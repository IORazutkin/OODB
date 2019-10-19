package lab3.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "service")
public class Service {
    long id;
    String title;
    double price;
    String unit;
}