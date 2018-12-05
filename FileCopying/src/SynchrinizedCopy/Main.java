package SynchrinizedCopy;


//import java.util.Scanner;

/**
 * Класс для последовательного копирования файлов двумя потоками.
 *
 * @author P.V.V. 16IT18K
 */
public class Main {
    public static void main(String[] args) {

        //Scanner scan = new Scanner(System.in);

        String[] firstThreadInfo = {"C:\\Test\\Test1\\3.txt", "C:\\Test\\Test1\\4new.txt"};
        String[] secondThreadInfo = {"C:\\Test\\Test1\\3.txt", "C:\\Test\\Test1\\5new.txt"};

        //String firstThreadInfo[] = {naming(scan), naming(scan)};
        //String secondThreadInfo[] = {naming(scan), naming(scan)};

        final long before = System.currentTimeMillis();

        createNStart("firstThread", firstThreadInfo);
        createNStart("secondThread", secondThreadInfo);

        final long after = System.currentTimeMillis();

        System.out.printf("Delta %d \n", (after - before));
        System.out.println("Программа закончила свою работу.");

    }

    /**
     *
     * Метод для ожидания конца работы потока,
     * чтобы сделать выполнение потоков последовательным.
     *
     * @param thread - поток для копирования файлов.
     */
    private static void sync(ICopyResult thread){
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Поток %s закончил свою работу. \n", thread.getName());
    }

    /**
     * Метод создает и запускает поток, затем вызывает метод sync()
     * для того, чтобы подождать, пока он закончится для последовательной работы потоков.
     *
     * @param name - Имя потока.
     * @param info - Строковый массив для передачи пути-источника и пути-доставки.
     */
    private static void createNStart(String name, String[] info){
        ICopyResult copy = new ICopyResult(name, info[0], info[1]);
        copy.start();
        sync(copy);
    }
}

