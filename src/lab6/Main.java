package lab6;

import lab6.annotation.Column;
import lab6.annotation.Entity;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private final static String PATH_NAME = "lab6.entity";

    public static void main(String[] args) {
        System.out.println("STEP 1: scan package " + PATH_NAME + ":");

        List<Class<?>> classes = PathScan.find(PATH_NAME);
        classes.forEach(c -> System.out.println("\t" + c.getCanonicalName()));

        System.out.println("STEP 2: scan class fields:");
        for (Class<?> cl : classes) {
            System.out.println("\tFields of class " + cl.getName());
            Field[] fields = cl.getDeclaredFields();
            for (Field field : fields) {
                System.out.println("\t\t" + field.getName());
            }
        }

        System.out.println("STEP 3: scan class methods:");
        for (Class<?> cl : classes) {
            System.out.println("\tFields of class " + cl.getName());
            Method[] methods = cl.getMethods();
            for (Method method : methods) {
                System.out.println("\t\t" + method.getName());
            }

        }

        System.out.println("STEP 4: scan class annotations:");
        for (Class<?> cl : classes) {
            Annotation[] annotations = cl.getAnnotations();
            if (annotations != null) {
                for (Annotation a : annotations) {
                    if (a.annotationType().equals(Entity.class)) {
                        System.out.println("\t" + cl.getName() + " is entity!");
                    }
                }
            }
        }

        System.out.println("STEP 5: scan fields annotations:");
        for (Class<?> cl : classes) {
            System.out.println("\tClass " + cl.getName());
            Field[] fields = cl.getDeclaredFields();
            for (Field f : fields) {
                Annotation[] fannotations = f.getAnnotations();
                for (Annotation a : fannotations) {
                    if (a.annotationType().equals(Column.class)) {
                        System.out.println(String.format("\t\tField %s %s is attribute!", f.getType().getName(), f.getName()));
                    }
                }
            }
        }

        System.out.println("STEP 6: get superclass:");
        for (Class<?> cl : classes) {
            Class superClass = cl.getSuperclass();
            System.out.println("\tSuper class of " + cl.getName() + " is " + superClass.getName());
        }

        List<Node> nodes = new ArrayList<>();
        System.out.println("STEP 7: class structure");
        for (Class cl : classes) {
            nodes.add(new Node(cl, null, null, classes));
        }

        Node.createStructure(nodes);

        for (Node node : nodes) {
            Node.toString(node, "");
        }
    }
}