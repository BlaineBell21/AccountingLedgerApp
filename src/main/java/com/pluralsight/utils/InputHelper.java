package com.pluralsight.utils;

/*
This helps avoid repeating Scanner code everywhere.
 */

import java.io.*;
import java.util.Scanner;

public class InputHelper {
    /*
2024-01-05|09:15:32|office chair|Amazon|-129.99
2024-01-08|14:22:10|client payment|Acme Corp|2500.00
2024-01-12|11:05:45|laptop charger|Best Buy|-39.95
2024-01-15|16:40:20|freelance web design|Smith LLC|1200.00
2024-02-02|10:10:10|coffee supplies|Starbucks|-18.75
2024-02-10|13:33:55|subscription refund|Adobe|59.99
2024-02-18|08:25:00|software license|JetBrains|-89.00
2024-03-01|12:00:00|monthly retainer|BlueSky Agency|3000.00
2024-03-10|17:45:30|external hard drive|Walmart|-79.49
2024-03-22|09:50:15|consulting payment|Tech Solutions|1800.00
 */


    public static String promptString(){
        Scanner userInput = new Scanner(System.in);
        return userInput.nextLine();
    }

    public static double promptDouble(){
        Scanner userInput = new Scanner(System.in);

        return userInput.nextDouble();
    }
}
