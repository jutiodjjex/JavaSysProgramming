public class Checker {
    double firstDenominator;
    double firstNumenator;
    double secondDenominator;
    double secondNumenator;
    
Checker(double firstDenominator, double firstNumenator, double secondDenominator, double secondNumenator){
    this.firstDenominator = firstDenominator;
    this.firstNumenator = firstNumenator;
    this.secondDenominator = secondDenominator;
    this.secondNumenator = secondNumenator;

}

    String denominatorOrNumenatorForFraction;

    public String optionalString(double firstDenominator, double firstNumenator, double secondDenominator, double secondNumenator){
    
        if(firstDenominator == 0){
            denominatorOrNumenatorForFraction = "denominator for first fraction";
        } else {
            if(firstNumenator == 0){
                denominatorOrNumenatorForFraction = "numinator for first fraction";
            } else { 
                if(secondDenominator == 0){
                    denominatorOrNumenatorForFraction = "denominator for second fraction";
                } else {
                    denominatorOrNumenatorForFraction = "numinator for second fraction";
                }
                
            }    
        
        }
        
        return denominatorOrNumenatorForFraction;
    }
    
    }
