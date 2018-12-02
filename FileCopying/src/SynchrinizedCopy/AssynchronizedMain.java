package SynchrinizedCopy;


import java.util.Scanner;

public class AssynchronizedMain {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String firstThreadInfo[] = {"C:\\Test\\Test1\\3.txt", "C:\\Test\\Test1\\4new.txt"};
        String secondThreadInfo[] = {"C:\\Test\\Test1\\3.txt", "C:\\Test\\Test1\\5new.txt"};

        //String firstThreadInfo[] = {naming(scan), naming(scan)};
        //String secondThreadInfo[] = {naming(scan), naming(scan)};

        final long before = System.currentTimeMillis();

        createNStart("firstThread", firstThreadInfo);
        createNStart("secondThread", secondThreadInfo);

        final long after = System.currentTimeMillis();


        System.out.printf("Delta %d \n", (after - before));
        System.out.println("Программа закончила свою работу.");

    }


    public static void createNStart(String name, String[] info){
        ICopyResult copy = new ICopyResult(name, info[0], info[1]);
        copy.start();
    }

    public static void sync(ICopyResult thread){
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Поток %s закончил свою работу. \n", thread.getName());
    }

    //public static String naming(Scanner scan){
            //System.out.println("Введите полное имя файла : ");
            //String info = scan.nextLine();
        //return info;
    //}
}