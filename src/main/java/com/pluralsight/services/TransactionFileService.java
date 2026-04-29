package com.pluralsight.services;

import com.pluralsight.models.Transaction;
import com.pluralsight.ui.LedgerScreen;
import com.pluralsight.utils.DateUtils;
import com.pluralsight.utils.InputHelper;
import com.pluralsight.utils.WriteAndReadCSV;


import java.io.IOException;

public class TransactionFileService {

    public static void depositService() throws IOException {
        //method for prompting user for deposits (positive values) they'd like to add to the record
        boolean isDoneDepositing = false;

        while(!isDoneDepositing){
            System.out.println("What is the deposit for?");
            System.out.println("Enter in a short description: ");
            String description = InputHelper.promptString(); //takes string input of transaction description

            System.out.println("Enter in the vendor name: ");
            String vendorName = InputHelper.promptString(); //takes string input on transaction vendor name

            System.out.println("Enter in the amount you'd like to deposit: ");
            double depositAmount = InputHelper.promptDouble(); //takes double input of deposit amount
            if (depositAmount < 0) {
                System.out.println("You must enter in a positive amount");
                break;
            }
            //creates an object for transaction
            Transaction newDeposit = new Transaction(DateUtils.currentDate(), DateUtils.currentTime(), description,vendorName, depositAmount);
            WriteAndReadCSV.csvWriter(newDeposit); //writes transaction details to CSV file

            boolean isFinished = false;
            while (!isFinished) {
                System.out.println("Would you like to make another deposit?");
                System.out.println("Enter in yes or no: ");
                String decision = InputHelper.promptString(); //prompt asking user if they'd like to continue adding more deposits

                if (decision.equals("no")) { //if not, exits to previous menu
                    isDoneDepositing = true;
                    isFinished = true;
                    System.out.println("Returning to previous menu.");

                } else if (decision.equals("yes")) { //if yes, starts while loop over for a new transaction entry
                    System.out.println("Starting new deposit.");
                    break;
                } else { //if user enters in something other than "yes" or "no" restarts loop
                    System.out.println("Incorrect input.");
                }
            }
        }
    }

    public static void paymentService() throws IOException {
        //method for adding payments (negative values) they'd like to add to the record
        boolean isDonePaying = false;

        while(!isDonePaying){
            System.out.println("What is the payment for?");
            System.out.println("Enter in a short description: ");
            String description = InputHelper.promptString(); //takes string input of transaction description

            System.out.println("Enter in the vendor name: ");
            String vendorName = InputHelper.promptString(); //takes string input on transaction vendor name

            System.out.println("Enter in the amount you are being billed for: ");
            double depositAmount = InputHelper.promptDouble(); //takes double input of payment amount
            if (depositAmount < 0) {
                System.out.println("You must enter in a positive amount");
                break;
            }
            //creates an object for transaction
            Transaction newPayment = new Transaction(DateUtils.currentDate(), DateUtils.currentTime(), description,vendorName, -depositAmount);
            WriteAndReadCSV.csvWriter(newPayment);

            boolean isFinished = false;

            while(!isFinished) {
                System.out.println("Would you like to make another payment?");
                System.out.println("Enter in yes or no: ");
                String decision = InputHelper.promptString(); //prompt asking user if they'd like to continue adding more deposits

                if (decision.equals("no")) { //if not, exits to previous menu
                    isDonePaying = true;
                    isFinished = true;
                    System.out.println("Returning to previous menu.");
                } else if (decision.equals("yes")) { //if yes, starts while loop over for a new transaction entry
                    System.out.println("Starting new deposit.");
                    break;
                } else { //if user enters in something other than "yes" or "no" restarts loop
                    System.out.println("Incorrect input.");
                }
            }
        }
    }
}
