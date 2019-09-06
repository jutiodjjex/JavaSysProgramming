package Delta;

public class SynchronizedMain {
    public static void main(String[] args) throws InterruptedException {
        ITextLoad firstThread = new MockLoader("firstThread");
        ITextLoad secondThread = new MockLoader("secondThread");

        final long before = System.currentTimeMillis();
        System.out.println(firstThread.loadText());
        System.out.println(secondThread.loadText());
        final long after = System.currentTimeMillis();
        System.out.printf("Delta %d \n", (after - before) / 1000);
    }
}
