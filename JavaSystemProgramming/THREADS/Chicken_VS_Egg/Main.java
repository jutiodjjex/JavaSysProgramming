package Chicken.VS.Egg;

public class Main {
    public static void main(String[] args) {
        boolean chickenIsOver = false;

        Egg egg = new Egg("egg");
        Chicken chicken = new Chicken("Chicken");

        egg.start();
        chicken.start();

        while (egg.isAlive()) {
            if (chicken.isAlive()) {
            } else {
                System.out.println("Яйцо победило");
                chickenIsOver = true;
                break;
            }
        }
            if(chickenIsOver){
            } else {
                System.out.println("Курица победила");
            }


        }

    }
