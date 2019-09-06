/**
 * Учебная программа, которая умножает без оператора умножения.
 * @author Pronichkin Vyacheslav 16IT18k
 */
 
public class Multiplication {
    public static void main(String[] args) {

        System.out.println("Результат = " + multiply(-4, 5));
    }

    private static int multiply(int firstNumber, int secondNumber) {

        int result = 0;
        boolean isMinus = false;
        if (firstNumber < 0) {
            firstNumber = -firstNumber;
            isMinus = true;
        }
        if (secondNumber == 0) {
            return result;
        }
        while (firstNumber != 0) {
            result += secondNumber;
            firstNumber--;
        }

        if (isMinus) result = -result;
        return result;
    }


}
