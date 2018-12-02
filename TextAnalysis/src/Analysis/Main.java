package Analysis;

import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        Statistic textStatistic = new Statistic();

        System.out.println("Введите полное имя текстового файла:");

        try {

            textStatistic.counter(scan.nextLine());
            System.out.println(textStatistic.toString());

        } catch (IOException e) {

            System.out.println("Файл отсутствует или имя файла введено неверно.");

        }

    }

}
