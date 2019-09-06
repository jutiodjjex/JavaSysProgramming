package Multiplication;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MultiplicationTest {
    @Test
    public void unit_test1(){
        int firstNumber = (-10000 + (int) (Math.random() * ((10000 - (-10000)) + 1)));
        int secondNumber = (-10000 + (int) (Math.random() * ((10000 - (-10000)) + 1)));
        int expected = firstNumber * secondNumber;
        Assert.assertEquals(expected, Multiplication.multiply(firstNumber, secondNumber));
        Assert.assertEquals("This is not equals", expected, Multiplication.multiply(firstNumber, secondNumber));

        System.out.println("Unit test1 finished without errors.");
    }
}