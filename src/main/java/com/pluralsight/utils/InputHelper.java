package com.pluralsight.utils;

import java.io.*;
import java.util.Scanner;

public class InputHelper {


    public static String promptString(){ //reusable method for scanning string input
        Scanner userInput = new Scanner(System.in);
        return userInput.nextLine();
    }

    public static double promptDouble(){ //reusable method for scanning double input
        Scanner userInput = new Scanner(System.in);
        return userInput.nextDouble();
    }
}
