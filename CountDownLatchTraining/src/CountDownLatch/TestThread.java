package CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class TestThread extends Thread {

    private final CountDownLatch latch;

    TestThread(CountDownLatch latch, String name){
        this.latch = latch;
        setName(name);
    }

    @Override
    public void run(){
        try{
            runUnsafe();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private void runUnsafe() throws InterruptedException{

        System.out.println(getName() + " сел за стол и ждет остальных.");

        latch.countDown();
        latch.await();

        System.out.println(getName() + " начал есть.");

    }


}
