package Delta;

public class TextLoadThread extends Thread {
    TextLoadThread(String name) {
        setName(name);
    }

    @Override
    public void run() {

            System.out.printf("Поток %s запущен.\n", getName());
            try {
                for (int i = 0; i <= 5; i++) {
                    sleep(1_000);
                    System.out.printf("Прошло %d секунд (%s)\n", i, getName());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("Поток %s выполнен.\n", getName());
        }
    }