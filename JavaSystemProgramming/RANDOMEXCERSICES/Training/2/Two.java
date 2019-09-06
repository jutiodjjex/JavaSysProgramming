import java.util.Scanner;
import java.util.Arrays;


public class Two {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args){
		
		double[] array = {43, 23, 51, 234, 214, 641, 32, 423, 531, 423};
		System.out.println(Arrays.toString(array));
		System.out.println("Enter the index of massive thats you want to increase to 10%");
		int arrayIndex = scanner.nextInt();
        System.out.println(indexIncrease(array, arrayIndex));
	}
	public static double indexIncrease(double[] array, int arrayIndex){
	    double tenPercentOfIndex = 0;
	    tenPercentOfIndex = array[arrayIndex] / 100;
		tenPercentOfIndex = array[arrayIndex] * 0.10;
		array[arrayIndex] = array[arrayIndex] + tenPercentOfIndex;
		
	    return array[arrayIndex];
	}
}
