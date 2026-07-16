package com.pluralsight.ui;

import com.pluralsight.services.LedgerService;
import com.pluralsight.utils.InputHelper;
import com.pluralsight.utils.SoundUtils;
import com.pluralsight.utils.WriteAndReadCSV;
import java.io.IOException;

public class LedgerScreen {

    public static void displayLedgerScreen(){
        System.out.println("\n════════════════════════════════════════════");
        System.out.println("        📜 THE LEDGER ARCHIVES 📜");
        System.out.println("════════════════════════════════════════════");
        System.out.println(" [A] View All Transactions");
        System.out.println(" [D] View Deposits");
        System.out.println(" [P] View Payments");
        System.out.println(" [R] Forge Reports");
        System.out.println(" [X] Return to the Forge");
        System.out.println("════════════════════════════════════════════");
        System.out.print("Select a ledger action: ");
    }
    public static void LedgerScreenUI(WriteAndReadCSV transactions) throws IOException {
        //accesses all service features related to ledger service
        boolean isDoneForging = false;

        while(!isDoneForging){
            displayLedgerScreen();
            String userOption = InputHelper.promptString();
            //allows user to enter in lower case or upper case letter without erroring and removes extra space
            switch(userOption.trim().toUpperCase()){
                case "A": //displays all transactions unordered/unsorted
                    SoundUtils.playMenuClick();
                    isDoneForging = true;
                    LedgerService.showAllTransactions(transactions);
                    break;
                case "D": //only shows deposits (positive balance transactions)
                    SoundUtils.playMenuClick();
                    isDoneForging = true;
                    LedgerService.showOnlyDeposits(transactions);
                    break;
                case "P": //only shows payments (negative balance transactions)
                    SoundUtils.playMenuClick();
                    isDoneForging = true;
                    LedgerService.showOnlyPayments(transactions);
                    break;
                case "R": //takes user to reports menu
                    SoundUtils.playMenuClick();
                    System.out.println("Opening financial reports...");
                    isDoneForging = true;
                    ReportScreen.ReportScreenUI(transactions);
                    break;
                case "X": //allows user to go back to previous menu
                    SoundUtils.playMenuClick();
                    System.out.println("Returning to the forge...");
                    isDoneForging = true;
                    HomeScreen.homeScreenUI(transactions);
                    break;
                default:
                    System.out.println("Invalid option, try again.\n");
            }
        }
    }
    public static void transactionHistoryEnd(){
        System.out.println("\n════════════════════════════════════");
        System.out.println(" End of ledger records.");
        System.out.println(" Returning to the archives...");
        System.out.println("════════════════════════════════════");
    }
}
