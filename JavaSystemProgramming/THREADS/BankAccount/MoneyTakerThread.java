package BankAccount;
 
//Класс MoneyTakerThread отвечает за снятие денег в тот момент, когда все деньги из потока MoneyTimerThread будут перечислены.

class MoneyTakerThread extends Thread {
    Money amount;
    MoneyTakerThread(String name, Money amount) {
        setName(name);
        this.amount = amount;
    }


    @Override
    public void run() {
		
		//То кол-во денег, которое захочет снять РАНДОМ.
        int howMuchDollarsIWant = (2300 + (int)(Math.random() * ((3200 - 2300) + 1)));
		
		//Пустая строка для последующего if'a
        String money = "";
		
		//Подтверждение наличия нужного количества денег для их снятия.
        boolean isMuch = false;
		
		//Комиссия при снятии денег, которую тоже определяет рандом.
        int comissionPercent = (5+(int)(Math.random()*((25 - 5)+1)));
		
		//Нахождение самой комиссии по отношению к сумме, подлежащей к снятию.
        int comission = (howMuchDollarsIWant/100)*comissionPercent;
		
		//Полная стоимость. Деньги, подлежащие к снятию и комиссия.
        int allCost = comission+howMuchDollarsIWant;
		
		//Цикл ожидания. Поток ожидает того момента, когда таймер закончит свою работу и передаст булеановое значение true, а так же notify();
        System.out.printf("Поток %s в режиме ожидания. \n", getName());
        synchronized(amount) {
            while (!MoneyTimerThread.ready){
                try {
                    amount.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
			
			//Таймер закончил свою работу, поток снятия снова активен.
            System.out.printf("Поток %s активен. Все деньги приняты. Кол-во денег: %s \n", getName(), MoneyOperations.output(amount));
			
			//Если денег на счету больше или равно значению, подлежащему к снятию, то строковое значение остается тем же, а значение
			//булеана меняется на истину. Это позволяет пройти по коду дальше и снять деньги.
            if (MoneyOperations.biggerOrEqual(amount, allCost)) {
                isMuch = true;
            } else {
                money = "не";
            }
            System.out.printf("Комиссия: %d процентов. \nЯ хочу снять %d рублей, комиссия составит %d рублей. \nВсего: %d рублей. \nЯ проверил счет и, кажется, вам %s хватает денег. \n", comissionPercent, howMuchDollarsIWant, comission, allCost, money);
			
			//То самое прохождение по коду дальше, что описано на пару строк выше.
            if (isMuch) {
                MoneyOperations.minus(amount, allCost);
                System.out.printf("Деньги были успешно сняты. \nСнято: %d рублей. \nКомиссия: %d рублей. \nОстаток: %s рублей.", allCost, comission, MoneyOperations.output(amount));
            }
        }

    }
}

