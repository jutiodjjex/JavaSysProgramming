package Delta;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TextLoadThread firstThread = new TextLoadThread("firstThread");
        TextLoadThread secondThread = new TextLoadThread("secondThread");
        final long before = System.currentTimeMillis();
        firstThread.start();
        secondThread.start();
        firstThread.join();
        secondThread.join();
        final long after = System.currentTimeMillis();
        System.out.printf("Delta %d \n", (after - before) / 1000);
    }
}
