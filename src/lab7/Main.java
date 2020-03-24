package lab7;

import lab7.annotation.ManyToOne;
import lab7.annotation.OneToMany;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<String, HashSet<String>> dbStructure = ScanDB.getDBStructure();
        HashMap<String, HashSet<Field>> pathStructure = ScanPath.getPathStructure();

        for (Map.Entry<String, HashSet<Field>> entry : pathStructure.entrySet()) {
            System.out.print(entry.getKey());
            if (dbStructure.containsKey(entry.getKey())) {
                System.out.println(" ✔");
                HashSet<String> fields = dbStructure.get(entry.getKey());
                for (Field field : entry.getValue()) {
                    String fieldName = field.getName().toLowerCase();
                    String oneToMany = "";
                    if (field.getAnnotation(ManyToOne.class) != null) {
                        fieldName += "_id";
                    } else if (field.getAnnotation(OneToMany.class) != null) {
                        if (dbStructure.containsKey(entry.getKey() + "_" + fieldName)) {
                            HashSet<String> dbFields = dbStructure.get(entry.getKey() + "_" + fieldName);
                            if (dbFields.contains(entry.getKey() + "_id")) {
                                oneToMany += "✔";
                            }
                            if (dbFields.contains(fieldName + "_id")) {
                                oneToMany += "✔";
                            }
                        }
                    }
                    System.out.print("\t● " + fieldName);
                    if (oneToMany.isEmpty()) {
                        if (fields.contains(fieldName)) {
                            System.out.println(" ✔");
                        } else {
                            System.out.println(" x");
                        }
                    } else {
                        System.out.println(" " + oneToMany);
                    }
                }

            } else {
                System.out.println(" x");
            }
        }
    }
}