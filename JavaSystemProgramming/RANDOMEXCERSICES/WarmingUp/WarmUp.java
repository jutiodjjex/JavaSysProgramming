

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class WarmUp

    private static final String FILE_PATH = "C:\\Users\\Rescue\\Documents\\GitHub\\Study\\Reg\\WarmingUp\\price.txt";

    public static void main(String[] args) throws IOException{

        BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH));

        String buf = null;

        while ((buf = bufferedReader.readLine()) != null){

            String [] arrBuf = buf.split(" ");

            int time = Integer.parseInt(arrBuf[0]);
            arrBuf[0] = null;

            int[] price = new int[arrBuf.length - 1];

            for(int i = 0, q = 0; q < arrBuf.length; ++q){

                if(arrBuf[q] != null){
                    price[i] = Integer.parseInt(arrBuf[q]);
                    ++i;
                }
            }

            bubbleSortMaxToMin(price);

            System.out.printf("time = %d ; price = ", time);
            printArray(price);
            System.out.printf("money = %d\n", money(time, price));


        }

        bufferedReader.close();

    }

    private static int money(int time, int[] price){

        int result = 0;

        for(int i = 0; i < price.length && time != 0; ++i, --time){
            result += price[i];
        }

        return result;

    }

    private static void printArray(int[] array){

        System.out.print('[');
        for(int i = 0; i < array.length; ++i){

            System.out.printf("%d ,",array[i]);

        }
        System.out.println(']');

    }

    private static void bubbleSortMaxToMin(int[] arr){

        int b = 0;

        for(int e = arr.length - 1; e > 0; --e){

            for(int i = 0; i < e; ++i){

                if(arr[i] < arr[i + 1]){
                    b = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = b;
                }

            }

        }

    }
}