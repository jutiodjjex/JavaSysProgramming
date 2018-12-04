package CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws Exception {
        CountDownLatch latch = new CountDownLatch(6);

        TestThread testThread0 = new TestThread(latch, "Философ 1");
        TestThread testThread1 = new TestThread(latch, "Философ 2");
        TestThread testThread2 = new TestThread(latch, "Философ 3");
        TestThread testThread3 = new TestThread(latch, "Философ 4");
        TestThread testThread4 = new TestThread(latch, "Философ 5");
        TestThread testThread5 = new TestThread(latch, "Философ 6");
        testThread0.start();
        testThread1.start();
        testThread2.start();
        testThread3.start();
        testThread4.start();
        testThread5.start();
    }
}