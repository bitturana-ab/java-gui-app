public class ConcurrencyThread {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Printing from thread: " + i);
                    try {
                        Thread.sleep(1000); // Sleep for 1 second
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start(); // Start the thread
        for (int i = 0; i < 5; i++) {
            System.out.println("Printing from main: " + i);
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
