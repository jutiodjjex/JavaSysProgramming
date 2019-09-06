package TenThreads;

class Threads extends Thread {
    Threads(String name) {
        setName(name);
    }

    @Override
    public void run() {
        System.out.printf("Поток %s  запущен. \n", getName());
    }
}

