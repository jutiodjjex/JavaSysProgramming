import java.util.Scanner;

public class Seven{
	static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
	double doubleTypeNumber = scanner.nextDouble();
	if(doubleTypeNumber % 1 == 0){
		System.out.println("double type number is integer.");
	} else {
		System.out.println("double type number is not integer.");
	}
	}
}
