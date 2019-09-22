import java.util.List;

public class Apartment {
    long id;
    House house;
    int number;
    List<People> peoples;

    void addPeople(People people) {
        if (!peoples.contains(people)) {
            peoples.add(people);
        }
    }

    void removePeople(People people) {
        if (peoples.contains(people)) {
            peoples.remove(people);
        }
    }

    void printPeoples() {
        peoples.stream().forEach(people -> System.out.println(people));
    }
}