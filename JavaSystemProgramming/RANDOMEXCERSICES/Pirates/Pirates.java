/**
 * Класс Pirates выполняет поиск всех значений в диапазоне
 *
 *
 * @author Pronichkin Vyacheslav
 */

public class Pirates{

    public static void main(String[] args) {

        int gems = 7;

        while (gems <= 10000){

            if(isRight(gems){

                System.out.println(gems);

            }

            gems++;

        }
    }


    /**
     * Метод возвращает значение true, если проверяемое число
	 * делится на 2-6 с остатком 1 и делится на 7 без остатка.
     *
     * @param g - проверяемое число.
     *
     */
    private static boolean isDivisible(int g){

        for(int i = 2 ; i < 7; i++){

            if((g % i) != 1){

                return false;

            }

        }

        return ((n % 7) == 0);

    }

}