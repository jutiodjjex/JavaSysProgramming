/**
 * Класс Chocolate подсчитывает, какое количество шоколадок возможно получить
 *
 *
 *
 * @author Pronichkin Vyacheslav.
 */

import java.util.Scanner;


public class Chocolate{


    private static final String MONEY = "Введите кол-во денег:  ";
    private static final String PRICE = "Введите цену одной шоколадки: ";
    private static final String SCRAP = "Введите количество оберток за которое можно получить шоколадку: ";
    private static final String CHOCOLATES = "Всего шоколадок - ";


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int money      = 0;
        int price      = 0;
        int scrap      = 0;
        int chocolate  = 0;
        int wrap       = 0;


        System.out.print(MONEY);
        money = scan.nextInt();

        System.out.print(PRICE);
        price = scan.nextInt();

        System.out.print(SCRAP);
        stock = scan.nextInt();

        wrap = chocolates = money / price;


        while (wrap >= scrap){

            wrap -= stock;
            chocolate++;
            wrap++;

        }

       

        System.out.printf(CHOCOLATES, chocolate);

    }

}