import java.util.Scanner;

public class Six{
	static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
		int multiplication = scanner.nextInt();
		
		for(int i = 1; i <= 10; i++){
			System.out.println(multiplication + "x" + i + "=" + multiplication*i);
		}
		
	}
}
