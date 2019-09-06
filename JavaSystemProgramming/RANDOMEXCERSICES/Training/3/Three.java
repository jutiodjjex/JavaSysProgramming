import java.util.Scanner;

public class Three{
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
	double euroPrice = 70.56;
	double valueOfRoubles = scanner.nextDouble();
	double valueOfEuro = 0;
	System.out.println(converter(euroPrice, valueOfRoubles, valueOfEuro));
	}
	
	public static double converter(double euroPrice, double valueOfRoubles, double valueOfEuro){
		valueOfEuro = valueOfRoubles / euroPrice;
		
		return valueOfEuro;
	}
}
