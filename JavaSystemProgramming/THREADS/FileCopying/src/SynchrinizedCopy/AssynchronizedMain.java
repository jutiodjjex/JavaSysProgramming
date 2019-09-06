package SynchrinizedCopy;


//import java.util.Scanner;

/**
 * Класс для параллельного копирования файлов двумя потоками.
 *
 * @author P.V.V. 16IT18K
 */
public class AssynchronizedMain {
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
     * Метод создает и запускает поток.
     *
     * @param name - Имя потока.
     * @param info - Строковый массив для передачи пути-источника и пути-доставки.
     */
    private static void createNStart(String name, String[] info){
        CopyingThread copy = new CopyingThread(name, info[0], info[1]);
        copy.start();
    }

    //public static String naming(Scanner scan){
            //System.out.println("Введите полное имя файла : ");
            //String info = scan.nextLine();
        //return info;
    //}
}