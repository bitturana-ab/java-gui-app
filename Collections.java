import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class CopyArray {
    public void arrayCopy() {
        String names[] = { "Alice", "Bob", "Charlie" };
        // copy to new array for size increase
        String newNames[] = new String[5];
        // copy names to newNames
        for (int i = 0; i < names.length; i++) {
            newNames[i] = names[i];
        }
        newNames[3] = "David";
        newNames[4] = "Eve";
        // print newNames
        for (String name : newNames) {
            System.out.println(name);
        }
    }
}

class Student {
    private String name;
    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

}

public class Collections {

    public static void main(String[] args) {

        // CopyArray cArray = new CopyArray();
        // cArray.arrayCopy();

        // Collections start here
        ArrayList<String> names = new ArrayList<>();
        names.add("ans");
        names.add("asvbd");
        names.add("cndsvj");
        // System.out.println(names.get(0)); // Accessing the first element

        // names.remove("asvdb");

        // for (String name : names) {
        // System.out.println(name);
        // }

        // Map and HashMap example
        // Map<String, Integer> studens = new HashMap<>();
        // studens.put("ab", 21);
        // studens.put("cd", 12);
        // studens.put("ef", 23);

        // System.out.println(studens.get("ab"));
        // System.out.println(studens.containsKey("cd"));
        // System.out.println(studens.containsValue(23));

        // insert student objects into a map
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("ab", 1));
        students.add(new Student("cd", 12));

        for (Student student : students) {
            System.out.println("Name: " + student.getName() + " ID: " + student.getId());
        }

    }
}
