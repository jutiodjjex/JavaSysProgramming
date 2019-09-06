package BankAccount;

//Класс с методами отвечает за действия с обьектом Money.

public class MoneyOperations {

    //Метод для сложения двух целочисленных чисел.
    public static void plus(Money moneyAmount, int secondOperator){
        int result = moneyAmount.getMoney() + secondOperator;
        moneyAmount.setMoney(result);
    }
	
	//Метод для вычитания двух целочисленных чисел.
    public static void minus(Money moneyAmount, int secondOperator){
        int result = moneyAmount.getMoney() - secondOperator;
        moneyAmount.setMoney(result);
    }
	
	//Метод для двух целочисленных значений и логического оператора.
    public static boolean biggerOrEqual(Money moneyAmount, int secondOperator){
        boolean isBigger = false;
        if(moneyAmount.getMoney() >= secondOperator){
            isBigger = true;
        } else {
        }
        return isBigger;
    }
	
	//Метод для вывода значения обьекта Money в целочисленном представлении.
    public static int output(Money moneyAmount){
        return moneyAmount.getMoney();
    }
}
