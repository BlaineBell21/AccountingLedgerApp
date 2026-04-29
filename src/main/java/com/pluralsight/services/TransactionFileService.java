package com.pluralsight.services;

import com.pluralsight.models.Transaction;
import com.pluralsight.ui.LedgerScreen;
import com.pluralsight.utils.DateUtils;
import com.pluralsight.utils.InputHelper;
import com.pluralsight.utils.WriteAndReadCSV;


import java.io.IOException;

public class TransactionFileService {

    public static void depositService() throws IOException {
        boolean isDoneDepositing = false;

        while(!isDoneDepositing){
            System.out.println("What is the deposit for?");
            System.out.println("Enter in a short description: ");
            String description = InputHelper.promptString();

            System.out.println("Enter in the vendor name: ");
            String vendorName = InputHelper.promptString();

            System.out.println("Enter in the amount you'd like to deposit: ");
            double depositAmount = InputHelper.promptDouble();
            if (depositAmount < 0) {
                System.out.println("You must enter in a positive amount");
                break;
            }
            Transaction newDeposit = new Transaction(DateUtils.currentDate(), DateUtils.currentTime(), description,vendorName, depositAmount);
            WriteAndReadCSV.csvWriter(newDeposit);

            System.out.println("Would you like to make another deposit?");
            System.out.println("Enter in yes or no: ");
            String decision = InputHelper.promptString();

            if (decision.equals("no")){
                isDoneDepositing = true;
            } else if(decision.equals("yes")){
                System.out.println("Starting new deposit.");
            } else {
                System.out.println("Incorrect input. Returning to main menu.");
                isDoneDepositing = true;
            }
        }
    }

    public static void paymentService() throws IOException {

        boolean isDonePaying = false;

        while(!isDonePaying){
            System.out.println("What is the payment for?");
            System.out.println("Enter in a short description: ");
            String description = InputHelper.promptString();

            System.out.println("Enter in the vendor name: ");
            String vendorName = InputHelper.promptString();

            System.out.println("Enter in the amount you are being billed for: ");
            double depositAmount = InputHelper.promptDouble();
            if (depositAmount < 0) {
                System.out.println("You must enter in a positive amount");
                break;
            }
            Transaction newPayment = new Transaction(DateUtils.currentDate(), DateUtils.currentTime(), description,vendorName, -depositAmount);
            WriteAndReadCSV.csvWriter(newPayment);

            System.out.println("Would you like to make another payment?");
            System.out.println("Enter in yes or no: ");
            String decision = InputHelper.promptString();

            if (decision.equals("no")){
                isDonePaying = true;
            } else if(decision.equals("yes")){
                System.out.println("Starting new deposit.");
            } else {
                System.out.println("Incorrect input. Returning to main menu.");
                isDonePaying = true;
            }
        }
        LedgerScreen.transactionHistoryEnd();
    }
}
