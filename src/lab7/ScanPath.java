package lab7;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.*;

public final class ScanPath {
    private final static String PATH_NAME = "lab7.entity";

    public static HashMap<String, HashSet<Field>> getPathStructure() {
        HashMap<String, HashSet<Field>> classes = new HashMap<>();

        List<Class<?>> classList = find(PATH_NAME);

        for (Class<?> cl : classList) {

            Field[] fields = cl.getDeclaredFields();

            classes.put(cl.getSimpleName().toLowerCase(), new HashSet<>(Arrays.asList(fields)));
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
