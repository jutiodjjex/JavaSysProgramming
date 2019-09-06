package BankAccount;

//Класс для обьекта Money. Симулирует сами деньги. Имеет поля класса, геттер и сеттер.

class Money {
    private int money;
    Money(int money){
        this.money = money;
    }
    public int getMoney(){
        return money;
    }
    public void setMoney(int money){
        this.money = money;
    }
}
