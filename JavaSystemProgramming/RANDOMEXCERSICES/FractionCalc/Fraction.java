public class Fraction {
double denominator;
double numenator;
Fraction(double denominator, double numenator){
        this.denominator = denominator;
        this.numenator = numenator;
    }
    double getDenominator(){
        return denominator;
    }
    double getNumenator(){
        return numenator;
    }
	
	public static String outPrint(Fraction fraction){
        String output = fraction.denominator + "/" + fraction.numenator;
        return output;
    }
	
	/*public static void outPrintWithCharOption(Fraction fraction, char option){
		System.out.println(outPrint(Fraction fractionFirst, Fraction fractionSecond) + option + outPrint(outPrint(Fraction fractionFirst, Fraction fractionSecond))
	}
	*/

}