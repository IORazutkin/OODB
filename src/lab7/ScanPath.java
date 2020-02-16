package lab7;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public final class ScanPath {
    private final static String PATH_NAME = "lab6.entity";

    public static HashMap<String, HashSet<String>> getPathStructure() {
        HashMap<String, HashSet<String>> classes = new HashMap<>();

        List<Class<?>> classList = find(PATH_NAME);

        for (Class<?> cl : classList) {
            HashSet<String> hashSetFields = new HashSet<>();

            Field[] fields = cl.getDeclaredFields();
            for (Field field : fields) {
               hashSetFields.add(field.getName().toLowerCase());
            }

            classes.put(cl.getSimpleName().toLowerCase(), hashSetFields);
        }

        return classes;
    }

    private static List<Class<?>> find(String scannedPackage) {
        String scannedPath = scannedPackage.replace('.', '/');
        URL scannedUrl = Thread.currentThread().getContextClassLoader().getResource(scannedPath);
        if (scannedUrl == null) {
            throw new IllegalArgumentException("Bad package " + scannedPackage);
        }
        File scannedDir = new File(scannedUrl.getFile());
        List<Class<?>> classes = new ArrayList<>();
        for (File file : scannedDir.listFiles()) {
            classes.addAll(find(file, scannedPackage));
        }
        return classes;
    }

    private static List<Class<?>> find(File file, String scannedPackage) {
        List<Class<?>> classes = new ArrayList<>();
        String resource = scannedPackage + "." + file.getName();
        if (file.isDirectory()) {
            for (File child : file.listFiles()) {
                classes.addAll(find(child, resource));
            }
        } else if (resource.endsWith(".class")) {
            String className = resource.substring(0, resource.length() - 6);
            try {
                classes.add(Class.forName(className));
            }
            catch (ClassNotFoundException e) {}
        }
        return classes;
    }
}
