package lab6;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Node {
    private Class nodeClass;
    private String nodeName;
    private Annotation[] nodeAnnotation;
    private List<Node> nodeFields;

    Node(Class nodeClass, String nodeName, Annotation[] nodeAnnotation, List<Class<?>> classes) {
        this.nodeClass = nodeClass;
        this.nodeName = nodeName;
        this.nodeAnnotation = nodeAnnotation;
        this.nodeFields = new ArrayList<>();

        if (classes.contains(nodeClass)) {
            Field[] fields = nodeClass.getDeclaredFields();
            if (fields.length > 0) {
                for (Field field : fields) {
                    nodeFields.add(new Node(field.getType(), field.getName(), field.getAnnotations(), classes));
                }
            }
        }
    }

    public static void createStructure(List<Node> nodes) {
        List<Node> nodeList = new ArrayList<>(nodes);
        for (Node n : nodes) {
            for (Node n1 : n.nodeFields) {
                if (nodes.contains(n1)) {
                    nodeList.remove(n1);
                    createStructure(nodeList);
                }
            }
        }
        nodes.clear();
        nodes.addAll(nodeList);
    }

    public static void toString(Node node, String tab) {
        String name = node.nodeName,
                type = node.nodeClass.getTypeName(),
                annotation = "";

        if (node.nodeAnnotation != null) {
            String separator = "@";
            for (Annotation a : node.nodeAnnotation) {
                annotation += separator + a.annotationType().getName();
                if (separator.equals("@")) separator = ", @";
            }
        }

        if (name != null)
            name = name + " : ";
        else
            name = "";

        if (annotation.isEmpty())
            System.out.printf(tab + "%s%s\n", name, type);
        else
            System.out.printf(tab + "%s%s %s\n", name, type, annotation);

        for (Node n : node.nodeFields) {
            toString(n, tab + "\t");
        }
    }

    @Override
    public boolean equals(Object obj) {
        Node node = (Node) obj;
        return this.nodeClass.equals(node.nodeClass);
    }
}