import java.util.Scanner;
import java.util.Arrays;


public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String args[]){
	
		double firstDenominator = 0, firstNuminator = 0, secondDenominator = 0, secondNuminator = 0; //Иниөиализаөия переменных для дробей
		char optionForMethod; //Переменная для знака операции

		Checker checker = new Checker(firstDenominator, firstNuminator, secondDenominator, secondNuminator); 
		
		/* Тут у нас участвует метод для введения значений в переменные, в классе Checker находится обьект, который берёт в свои поля значения
		*  из полей объекта Fraction, далее пихает их в метод проверки. Метод проверки работает таким образом: переменные знаменателей и числителей
		*  обеих дробей изначально равны нулю. Он проверяет каждую переменную, начиная с первой, то есть числитель первой дроби. Если числитель первой
		*  дроби равен нулю, то в него заносится следующее значение с клавиатуры типа char. Если же значение переменной не равно нулю, то заносится во вторую
		*  переменную. Если и вторая не равна нулю, то в третью и так далее. Под каждым возможным результатом работы оператора if так же строке 
		*  denominatorOrNumenatorForFraction присваивается значение типа String. От этого значения и зависит результат работы следующего цикла, 
		*  а точнее - оператора switch.
		*/
		for(int i = 1; i < 5; i++){ 
		System.out.println("Enter " + checker.optionalString(firstDenominator, firstNuminator, secondDenominator, secondNuminator));
		switch(checker.optionalString(firstDenominator, firstNuminator, secondDenominator, secondNuminator)){
		    case "denominator for first fraction": 
		        firstDenominator = scanner.nextDouble();
		        break;
		    case "numinator for first fraction":
		        firstNuminator = scanner.nextDouble();
		        break;
		    case "denominator for second fraction":
		        secondDenominator = scanner.nextDouble();			
		        break;
		    case "numinator for second fraction":
		        secondNuminator = scanner.nextDouble();
				break;
		    
			
		}
		}
		
		
	Fraction fractionFirst = new Fraction(firstDenominator, firstNuminator); //Ввод значений переменных в поля объекта типа Fraction. Первая дробь.
	Fraction fractionSecond = new Fraction(secondDenominator, secondNuminator);  //Ввод значений переменных в поля объекта типа Fraction. Вторая дробь.
	/*Метод для вывода дробей на экран. Выводит первую и вторую дробь, используя
	* методы из класса Fraction для каждой дроби: первой и второй.
	*/
	fractionVisible(fractionFirst, fractionSecond);
	System.out.println(QUESTION_WOULD_DO); 
	System.out.println(OPTION_SELECT);
	optionForMethod = scanner.next().charAt(0); //Ввод данных типа Char для операций с дробями, чем и занимается оператор switch
	switch(optionForMethod){
		    case '+': 
		        Option.addition(fractionFirst, fractionSecond);
		        break;
		    case '-':
		        Option.subtraction(fractionFirst, fractionSecond);
		        break;
		    case '/':
		        Option.division(fractionFirst, fractionSecond);			
		        break;
		    case '*':
		        Option.multiplication(fractionFirst, fractionSecond);
				break;
		    
			
		}
	System.out.println("Result is: " + Fraction.outPrint(fractionSecond)); //Результат. Результат у меня всегда хранится в объекте fractionSecond

	}
	
	public static void fractionVisible(Fraction fractionFirst, Fraction fractionSecond){
		System.out.println(FIRST_FRACTION_IS);
	    System.out.println(Fraction.outPrint(fractionFirst));
	    System.out.println(SECOND_FRACTION_IS);
		System.out.println(Fraction.outPrint(fractionSecond));
	}
	
    private static final String QUESTION_WOULD_DO = "What would you do with this fractions?";
    private static final String FIRST_FRACTION_IS = "First fraction is: ";
    private static final String SECOND_FRACTION_IS = "Second fraction is: ";
    private static final String OPTION_SELECT = "You can do '+' '-' '/' '*' with fractions. Choose one: ";

}
	
	
	   
	 