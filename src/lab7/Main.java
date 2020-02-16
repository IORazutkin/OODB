package lab7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<String, HashSet<String>> dbStructure = ScanDB.getDBStructure();
        HashMap<String, HashSet<String>> pathStructure = ScanPath.getPathStructure();

        for (Map.Entry<String, HashSet<String>> entry : dbStructure.entrySet()) {
            System.out.print(entry.getKey());
            if (pathStructure.containsKey(entry.getKey())) {
                System.out.println(" ✔");
                HashSet<String> fields = pathStructure.get(entry.getKey());
                for (String field : entry.getValue()) {
                    System.out.print("\t● " + field);
                    if (fields.contains(field)) {
                        System.out.println(" ✔");
                    } else {
                        System.out.println(" x");
                    }
                }
            } else {
                System.out.println(" x");
            }
        }
    }
}