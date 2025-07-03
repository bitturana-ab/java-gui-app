public class Hello {

    public static void main(String[] args) {
        // System.out.println("Hello, World!");
        // String a = "Hello, World!";
        // int b = 10;
        // int c = 20;
        // System.out.println(false ? a : c);
        // System.out.println(a > b ? a : b);

        // string in java is class not primitive data type
        String name = "Hello, World!";
        // System.out.println(name.toUpperCase());
        int a = 5, b = 2;
        double result = (double) a / b;
        // System.out.println("Result: " + result);
        // operators
        // System.out.println(a++); // prints 5, then increments a to 6
        // System.out.println(++a); // increments a to 7, then prints 7

        // destructure for loop
        int i = 0;
        for (;;) {
            if (i < 5)
                System.out.println("Iteration " + i);
            else
                break; // exit the loop when i is 5
            i++;
        }
    }
}