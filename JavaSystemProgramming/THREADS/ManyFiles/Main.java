

import java.io.IOException;


public class Main{

    private static final int AMOUNT_NUMBERS = 100000;
    private static final int MIN_NUMBER = 10;
    private static final int MAX_NUMBER = 9999989;


    private static final String FILE_PATH_NUMBERS_TXT = "C:\\Users\\Rescue\\Documents\\GitHub\\Study\\Reg\\ManyFiles\\numbers.txt";
    private static final String FILE_PATH_NUMBERS_DAT = "C:\\Users\\Rescue\\Documents\\GitHub\\Study\\Reg\\ManyFiles\\numbers.dat";
    private static final String FILE_PATH_NUMBERS6_DAT = "C:\\Users\\Rescue\\Documents\\GitHub\\Study\\Reg\\ManyFiles\\numbers6.dat";
    private static final String FILE_PATH_LUCKYNUMBERS_TXT = "C:\\Users\\Rescue\\Documents\\GitHub\\Study\\Reg\\ManyFiles\\luckyNumbers.txt";

    public static void main(String[] args) throws IOException {

        RewriteTxtToInt rewriteTxtToInt = new RewriteTxtToInt(FILE_PATH_NUMBERS_TXT, FILE_PATH_NUMBERS_DAT);
        rewriteTxtToInt.rewrite();
        rewriteTxtToInt.close();

        RewriteIntToInt rewriteIntToInt = new RewriteIntToInt(FILE_PATH_NUMBERS_DAT, FILE_PATH_NUMBERS6_DAT);
        rewriteIntToInt.filterRewrite(1001, 999999);
        rewriteIntToInt.close();

        RewriteIntToLuckyTxt rewriteIntToLuckyTxt = new RewriteIntToLuckyTxt(FILE_PATH_NUMBERS6_DAT, FILE_PATH_LUCKYNUMBERS_TXT);
        rewriteIntToLuckyTxt.rewrite();
        rewriteIntToLuckyTxt.close();

    }

}