import java.util.Scanner;

public class Contact {
    public static void main(String[] args) {
        String names[] = { "ans", "bittu", "sanjay", "vijay" };
        int numbers[] = { 91228, 726474, 343523, 3241 };

        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }

        System.out.println("Enter a name for number: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        boolean isFound = false;
        for (int i = 0; i < names.length; i++) {
            if (name.equals(names[i])) {
                System.out.println(name + " number is: " + numbers[i]);
                isFound = true;
            }
        }
        if (!isFound)
            System.out.println("Number not found for: " + name);

    }
}
