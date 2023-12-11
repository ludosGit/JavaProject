class NumberPrinter extends Thread {
    private int start;
    private int end;

    public NumberPrinter(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        // Creating two threads
        NumberPrinter thread1 = new NumberPrinter(1, 5);
        NumberPrinter thread2 = new NumberPrinter(6, 10);

        // Starting the threads
        thread1.start();
        thread2.start();

        // Main thread continues its execution
        for (int i = 11; i <= 15; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}