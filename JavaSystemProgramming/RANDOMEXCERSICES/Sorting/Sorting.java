package Sorting;

import java.util.ArrayList;
import java.util.Collections;

public class Sorting {

    static void printArray(int[] array) {

        for (int i = 0; i < array.length; ++i) {

            System.out.printf("[%d]", array[i]);

        }

    }

    public static void sort(int[] array) {
        ArrayList sortedArray = new ArrayList();
        for (int i = 0; i < array.length; i++) {
            sortedArray.add(array[i]);
        }


        System.out.printf("\nSorted array is: %s \n", sortedArray);
        //System.out.printf("Array is: %d, \n Same value: %s, \n", collection, falseCount);


    }

    public static void search(ArrayList list) {
        int maxNumber = Integer.parseInt(Collections.max(list));
        for (int i = 0; i < maxNumber; i++) {

        }
    }
}