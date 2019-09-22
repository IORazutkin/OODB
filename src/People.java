import java.time.LocalDate;
import java.time.Period;

public class People {
    long id;
    String fullName;
    LocalDate birthDay;
    Apartment apartment;

    int getAge() {
        return Period.between(birthDay, LocalDate.now()).getYears();
    }

    void printAddress() {
        System.out.println(apartment.house.address + " " + apartment.number);
    }

    @Override
    public String toString() {
        return fullName + ", " + getAge() + " лет";
    }
}