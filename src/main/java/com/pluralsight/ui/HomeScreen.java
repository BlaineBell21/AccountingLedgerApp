package com.pluralsight.ui;

import com.pluralsight.services.TransactionFileService;
import com.pluralsight.utils.InputHelper;
import com.pluralsight.utils.SoundUtils;
import com.pluralsight.utils.WriteAndReadCSV;

import java.io.IOException;

public class HomeScreen {

    public static void displayHomeScreen(){
        System.out.println("\n════════════════════════════════════════════");
        System.out.println("        ⚒️  THE FORGE WORKSHOP  ⚒️");
        System.out.println("════════════════════════════════════════════");
        System.out.println(" [D] Forge New Deposit");
        System.out.println(" [P] Hammer Out Payment");
        System.out.println(" [L] Open Financial Ledger");
        System.out.println(" [X] Extinguish the Forge");
        System.out.println("════════════════════════════════════════════");
        System.out.print("Choose your next craft: ");
    }
    public static void homeScreenUI(WriteAndReadCSV transactions) throws IOException {
        boolean isDoneForging = false;

        while(!isDoneForging){
            displayHomeScreen();
            String userOption = InputHelper.promptString();
            switch(userOption.trim().toUpperCase()){ //allows user to enter in lower case or upper case letter without erroring
                case "D": //takes user to depositing service
                    SoundUtils.playMenuClick();
                    System.out.println("Forge a Deposit");
                   TransactionFileService.depositService();
                    break;
                case "P": //takes user to payment service
                    SoundUtils.playMenuClick();
                    System.out.println("Forge a Payment");
                    TransactionFileService.paymentService();
                    break;
                case "L": //takes users to ledger menu
                    SoundUtils.playMenuClick();
                    System.out.println("Open the Ledger");
                    isDoneForging = true;
                    LedgerScreen.LedgerScreenUI(transactions);
                    break;
                case "X": //exits out of program
                    SoundUtils.playExitSound();
                    HomeScreen.goodByeMessage(); //displays goodbye message
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
