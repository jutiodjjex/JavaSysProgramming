package BankAccount;

/* Программа, симулирующая банковский счет, на который приходят деньги, а впоследствии
 * после накопления определенной суммы - снимаются.
 * Программа имеет два класса с потоками, один класс с объектом, один класс методов для объекта и мейн-класс.
 *
 *
 * @author Pronichkin Vyacheslav 16IT18k
 */
 
public class Main {
    public static void main(String[] args){
		
		//Изначальное кол-во денег - ноль. Деньги обозначаются словом amount, что значит количество.
        int amount = 0;
		
		//moneyAmount - экземпляр класса Money. 
        Money moneyAmount = new Money(amount);
		
		//Запуск потоков.
            new MoneyTimerThread("Отправитель денег", moneyAmount).start();
            new MoneyTakerThread("Получатель денег", moneyAmount).start();
    }
}