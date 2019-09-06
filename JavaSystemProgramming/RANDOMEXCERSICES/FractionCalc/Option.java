import java.util.Arrays;

public class Option { 

    
	
    //Метод для суммирования дробей
	public static Fraction addition(Fraction fractionFirst, Fraction fractionSecond){
		double[] symList = reducingNumenator(fractionFirst, fractionSecond);
		double additionResult;
		if(fractionFirst.numenator == fractionSecond.numenator){
			System.out.println("Numenators are equal.");
		} else {
			System.out.println("Reducing to the global numenator...");
		}
		//result
		symList[2] = symList[0] + symList[2];
		returnResultAsFraction(fractionSecond, symList);
	return fractionSecond;
	}
	
		
	//Метод для вычитания дробей
	public static Fraction subtraction(Fraction fractionFirst, Fraction fractionSecond){
		double[] symList = reducingNumenator(fractionFirst, fractionSecond);
		double additionResult;
		if(fractionFirst.numenator == fractionSecond.numenator){
			System.out.println("Numenators are equal.");
		} else {
			System.out.println("Reducing to the global numenator...");
		}
		//result
		symList[2] = symList[0] - symList[2];
		returnResultAsFraction(fractionSecond, symList);
	return fractionSecond;
	}
	
	//Метод для деления дробей
	public static Fraction division(Fraction fractionFirst, Fraction fractionSecond){
		double[] saveSpotForFraction = {fractionFirst.denominator, fractionFirst.numenator, fractionSecond.denominator, fractionSecond.numenator};
		//переворачиваем делитель 
		fractionSecond.denominator = saveSpotForFraction[3];
		fractionSecond.numenator = saveSpotForFraction[2];
		//перевернули, теперь умножение
		multiplication(fractionFirst, fractionSecond);
		
	return fractionSecond;
	}
	
	//Метод для умножения дробей
	public static Fraction multiplication(Fraction fractionFirst, Fraction fractionSecond){
		fractionSecond.denominator = fractionSecond.denominator * fractionFirst.denominator;
		fractionSecond.numenator = fractionSecond.numenator * fractionFirst.numenator;
		
	return fractionSecond;
	}
	
	//Метод для нахождения общего знаменателя
	public static double[] reducingNumenator(Fraction fractionFirst, Fraction fractionSecond){
		double symList[] = {fractionFirst.denominator, fractionFirst.numenator, fractionSecond.denominator, fractionSecond.numenator};
	    double saveSpotForFirstNumenator;
		double saveSpotForSecondNumenator;
		saveSpotForFirstNumenator = symList[1];
		saveSpotForSecondNumenator = symList[3];
		symList[1] = symList[1] * symList[3];
		symList[3] = symList[3] * saveSpotForFirstNumenator;
		symList[0] = symList[0] * saveSpotForSecondNumenator;
		symList[2] = symList[2] * saveSpotForFirstNumenator;
        return symList;
		}
	
	//Метод для преобразования результата из массива в объект типа Fraction и его возвращение объектом.
	public static Fraction returnResultAsFraction(Fraction fractionSecond, double[] resultList){
		fractionSecond.denominator = resultList[2];
		fractionSecond.numenator = resultList[3];
		return fractionSecond;
	}
	
}


	//Что-то лишнее, не помню, зачем оно надо было.
	/*public static double reducingNumenator(Fraction fractionFirst, Fraction fractionSecond){
		if(fractionFirst.numenator % fractionSecond.numenator == 0.0){
			double saveSpotForFirstNumenator;
			double saveSpotForSecondNumenator;
			double symList[] = {fractionFirst.denominator, fractionFirst.numenator, fractionSecond.denominator, fractionSecond.numenator};
			saveSpotForFirstNumenator = fractionFirst.numenator;
			saveSpotForSecondNumenator = fractionSecond.numenator;
			fractionFirst.numenator = fractionFirst.numenator * fractionSecond.numenator;
			fractionSecond.numenator = fractionSecond.numenator * saveSpotForFirstNumenator;
			fractionFirst.denominator = fractionFirst.denominator * saveSpotForSecondNumenator;
			fractionSecond.denominator = fractionSecond.denominator * saveSpotForFirstNumenator;
			}
			
		return fractionFirst.denominator + fractionFirst.numenator + fractionSecond.denominator + fractionSecond.numenator; 
	*/