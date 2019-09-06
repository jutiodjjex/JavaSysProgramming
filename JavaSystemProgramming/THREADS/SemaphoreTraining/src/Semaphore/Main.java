package Semaphore;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws Exception {
        Semaphore semaphore = new Semaphore(1, true);

        TestThread testThread0 = new TestThread("Инсаф", semaphore);
        TestThread testThread1 = new TestThread("Ильсаф", semaphore);
        TestThread testThread2 = new TestThread("Егор", semaphore);
        TestThread testThread3 = new TestThread("Дмитрий", semaphore);
        TestThread testThread4 = new TestThread("Софья", semaphore);
        TestThread testThread5 = new TestThread("Г'аля", semaphore);
        testThread0.start();
        testThread1.start();
        testThread2.start();
        testThread3.start();
        testThread4.start();
        testThread5.start();
    }
}
