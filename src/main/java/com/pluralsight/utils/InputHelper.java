package com.pluralsight.utils;

import java.io.*;
import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHelper {


    public static String promptString(){ //reusable method for scanning string input
        Scanner userInput = new Scanner(System.in);
        return userInput.nextLine();
    }

    public static BigDecimal promptBigDecimal(){ //reusable method for scanning monetary input
        Scanner userInput = new Scanner(System.in);
        // nextBigDecimal() throws InputMismatchException on non-numeric input (e.g. "f"),
        // which otherwise crashes the whole program; loop until the user gives a valid number
        while (true) {
            try {
                return userInput.nextBigDecimal();
            } catch (InputMismatchException e) {
                System.out.println("Invalid amount. Please enter a numeric value: ");
                userInput.next(); // discard the bad token so the scanner doesn't loop on the same input
            }
        }
    }
}
