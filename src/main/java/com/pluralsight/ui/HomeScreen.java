package com.pluralsight.ui;

import com.pluralsight.services.TransactionFileService;
import com.pluralsight.utils.InputHelper;
import com.pluralsight.utils.WriteAndReadCSV;

import java.io.IOException;

public class HomeScreen {

    public static void displayHomeScreen(){
        System.out.println("\nSelect an action to continue forging: ");
        System.out.println("D) Forge a Deposit");
        System.out.println("P) Record a Payment");
        System.out.println("L) Open the Ledger");
        System.out.println("X) Exit the Forge");
        System.out.print("Enter your choice: ");

    }
    public static void homeScreenUI(WriteAndReadCSV transactions) throws IOException {
        boolean isDoneForging = false;

        while(!isDoneForging){
            displayHomeScreen();
            String userOption = InputHelper.promptString();
            switch(userOption.toUpperCase()){ //allows user to enter in lower case or upper case letter without erroring
                case "D": //takes user to depositing service
                    System.out.println("going to deposit menu");
                   TransactionFileService.depositService();
                    break;
                case "P": //takes user to payment service
                    System.out.println("going to payment menu");
                    TransactionFileService.paymentService();
                    break;
                case "L": //takes users to ledger menu
                    System.out.println("going to ledger menu");
                    isDoneForging = true;
                    LedgerScreen.LedgerScreenUI(transactions);
                    break;
                case "X": //exits out of program
                    HomeScreen.goodByeMessage(); //displays good bye message
                    isDoneForging = true;
                    break;
                default:
                    System.out.println("Invalid option, try again.\n");
            }
        }
    }
    public static void greetingMessage(){
        System.out.println("=============================================================");
        System.out.println("                🔥 WELCOME TO BUDGET FORGE 🔥");
        System.out.println(" Forging better financial habits, one transaction at a time. ");
        System.out.println("=============================================================");
    }
    public static void goodByeMessage(){

        System.out.println("\n====================================");
        System.out.println(" Forge session complete.");
        System.out.println(" Your financial progress is preserved.");
        System.out.println(" Keep forging better habits.");
        System.out.println("====================================");
    }
}
