package Semaphore;

import java.util.concurrent.Semaphore;
import java.lang.InterruptedException;

public class TestThread extends Thread {

    private final Semaphore semaphore;

    TestThread(String name, Semaphore semaphore) {
        setName(name);
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            runUnsafe();
        } catch (InterruptedException e) {
            System.out.println(getName() + " is interrupted");
        }
    }


    @SuppressWarnings("InfiniteLoopStatement")
    private void runUnsafe() throws InterruptedException {
        semaphore.acquire();
        try {
            BrotherGimmeSomeLOOPS();
        } finally {
            System.out.printf("Философ %s вышел из-за стола. \n", getName());
            semaphore.release();
        }
    }

    private void BrotherGimmeSomeLOOPS() {
        System.out.printf("Философ %s присел за стол. \n", getName());
        if(getName() == "Егор"){
            System.out.printf("Философ %s не получает ложку, он не будет есть хрючево. \n", getName());
        } else {
            System.out.printf("Философ %s получает ложку. \n", getName());
        }

    }
}
