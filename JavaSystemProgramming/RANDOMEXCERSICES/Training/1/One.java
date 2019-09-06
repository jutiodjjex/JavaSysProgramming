import java.util.Scanner;

public class One {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		String expression = scanner.nextLine();
		char[] symbols = expression.toCharArray();
		dotCheck(symbols);
	
	}
	public static void dotCheck(char[] symbols){
            for(int j = 0; j < symbols.length; j++){
			if(symbols[j] != '.'){
				System.out.println("Symbol " + symbols[j] + " Successfully read");
			}
			else
			{
				System.out.println("It seems like the point has been caught. Symbols read is disabled.");
				break;
			}
		}
	    System.out.println("All symbols successfully read.");
    }
}
