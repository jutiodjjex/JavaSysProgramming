package BankAccount;

//Класс MoneyTimerThread отвечает за начисление денег на счет, когда все деньги будут пересланны - MoneyTakerThread выйдет из состояния ожидания.

class MoneyTimerThread extends Thread {
    Money amount;
	
	//Булеан, который шлет истинное значение в другой поток, когда этот поток заканчивает свою работу.
    static boolean ready = false;

    MoneyTimerThread(String name, Money amount) {
        setName(name);
        this.amount = amount;
    }
        @Override
        public void run(){
			
		//Блокировка
        synchronized (amount) {
            System.out.printf("Поток %s запущен. Кол-во денег: %s \n", getName(), MoneyOperations.output(amount));
			
			//Цикл, который шлет рандомное кол-во денег на счет. Всего десять итераций.
            for (int i = 0; i < 10; i++) {
                int RandomDollarsSender = (1 + (int) (Math.random() * ((1000 - 1) + 1)));
                MoneyOperations.plus(amount, RandomDollarsSender);
                System.out.printf("Пришло %d руб. Теперь у вас на счету %s руб. \n", RandomDollarsSender, MoneyOperations.output(amount));
            }

			//Тут цикл заканчивает свою работу, осталось лишь поменять значение булеана и оповестить другой
			//поток об окончании работы этого с помощью notify().
            System.out.println("Все деньги отосланы.");
            ready = true;
            amount.notify();
        }
        }
}