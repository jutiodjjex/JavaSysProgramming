package Analysis;

import java.io.IOException;
import java.util.Scanner;

/**
 * Класс для анализа текста.
 *
 * @author P.V.V. 16IT18K
 */
public class Main {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        Analysis textStatistic = new Analysis();

        System.out.println("Введите полное имя текстового файла: ");

        try {

            textStatistic.getCount(scan.nextLine());
            System.out.println(textStatistic.getOutput());

        } catch (IOException e) {

            System.out.println("Файл отсутствует или имя файла введено неверно.");

        }

    }

}
