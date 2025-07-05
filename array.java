import java.lang.reflect.Array;
import java.util.ArrayList;

public class array {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        list.add("!");
        list.add("Java");
        list.add("Programming");
        list.add(1, "Java");
        list.remove(2);
        System.out.println("ArrayList: " + list.get(3));

    }
}
