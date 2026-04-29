package com.pluralsight.ui;

import com.pluralsight.services.LedgerService;
import com.pluralsight.utils.InputHelper;
import com.pluralsight.utils.WriteAndReadCSV;
import java.io.IOException;

public class LedgerScreen {

    public static void displayLedgerScreen(){
        System.out.println("\nledger screen check: ");
        System.out.println("D) display all entries");
        System.out.println("P) display only deposits");
        System.out.println("L) display only payments");
        System.out.println("R) reports");
        System.out.println("X) Exit the Forge");
        System.out.print("Enter your choice: ");
    }
    public static void LedgerScreenUI(WriteAndReadCSV transactions) throws IOException {
        //accesses all service features related to ledger service
        boolean isDoneForging = false;

        while(!isDoneForging){
            displayLedgerScreen();
            String userOption = InputHelper.promptString();
            switch(userOption.toUpperCase()){ //allows user to enter in lower case or upper case letter without erroring
                case "D": //displays all transactions unordered/unsorted
                    isDoneForging = true;
                    LedgerService.showAllTransactions(transactions);
                    break;
                case "P": //only shows deposits (positive balance transactions)
                    isDoneForging = true;
                    LedgerService.showOnlyDeposits(transactions);
                    break;
                case "L": //only shows payments (negative balance transactions)
                    isDoneForging = true;
                    LedgerService.showOnlyPayments(transactions);
                    break;
                case "R": //takes user to reports menu
                    System.out.println("Going to report menu.");
                    isDoneForging = true;
                    ReportScreen.ReportScreenUI(transactions);
                    break;
                case "X": //allows user to go back to previous menu
                    System.out.println(); //eats extra line
                    System.out.println("Returning to previous menu.");
                    isDoneForging = true;
                    HomeScreen.homeScreenUI(transactions);
                    break;
                default:
                    System.out.println("Invalid option, try again.\n");
            }
        }
    }
    public static void transactionHistoryEnd(){
        System.out.println("End of transaction history.\n" +
                "Returning to previous menu.");
    }
}
