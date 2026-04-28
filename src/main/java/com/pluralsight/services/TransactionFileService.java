package com.pluralsight.services;

import com.pluralsight.models.Transaction;
import com.pluralsight.ui.HomeScreen;
import com.pluralsight.utils.DateUtils;
import com.pluralsight.utils.InputHelper;
import com.pluralsight.utils.WriteAndReadCSV;


import java.io.IOException;

public class TransactionFileService {

//    public static String depositService(WriteAndReadCSV transactions) throws IOException {
//
//        boolean isDoneDepositing = false;
//
//        while(!isDoneDepositing){
//            System.out.println("What is the deposit for?");
//            System.out.println("Enter in a short description: ");
//            String description = InputHelper.promptString();
//
//            System.out.println("Enter in the vendor name: ");
//            String vendorName = InputHelper.promptString();
//
//            System.out.println("Enter in the amount you'd like to deposit: ");
//            double depositAmount = InputHelper.promptDouble();
//            if (depositAmount < 0) {
//                System.out.println("You must enter in a positive amount");
//                break;
//            }
//            new Transaction(DateUtils.currentDate(), DateUtils.currentTime(), description,vendorName, depositAmount);
//
//            System.out.println("Would you like to make another deposit?");
//            System.out.println("Enter in yes or no: ");
//            String decision = InputHelper.promptString();
//
//            if (decision.equals("no")){
//                isDoneDepositing = true;
//                HomeScreen.homeScreenUI(transactions);
//            } else if(decision.equals("yes")){
//                System.out.println("Starting new deposit.");
//            } else {
//                System.out.println("Incorrect input. Returning to main menu.");
//                isDoneDepositing = true;
//            }
//        }
//        System.out.println("Deposits made made: ");
//        System.out.println("Deposits recorded. Returning to main menu.");
//        for (Transaction  payments : transactions){
//            System.out.println("===================================================" +
//                    "\nTransaction date and time: " + payments.getDate() + " "+ payments.getTime() + "\nReason for deposit: " +
//                    payments.getDescription() + "\nVendor name: " + payments.getVendor() + "\nAmount deposited: " + payments.getVendor() + "\n===================================================");
//        }
//
//        return WriteAndReadCSV.csvWriter();
//    }

//    public static String paymentService(WriteAndReadCSV transactions) throws IOException {
//
//        boolean isDonePaying = false;
//
//        while(!isDonePaying){
//            System.out.println("What is the payment for?");
//            System.out.println("Enter in a short description: ");
//            String description = InputHelper.promptString();
//
//            System.out.println("Enter in the vendor name: ");
//            String vendorName = InputHelper.promptString();
//
//            System.out.println("Enter in the amount you are being billed for: ");
//            double depositAmount = InputHelper.promptDouble();
//            if (depositAmount < 0) {
//                System.out.println("You must enter in a positive amount");
//                break;
//            }
//           new Transaction(DateUtils.currentDate(), DateUtils.currentTime(), description,vendorName,depositAmount);
//
//            System.out.println("Would you like to make another payment?");
//            System.out.println("Enter in yes or no: ");
//            String decision = InputHelper.promptString();
//
//            if (decision.equals("no")){
//                isDonePaying = true;
//                HomeScreen.homeScreenUI(transactions);
//            } else if(decision.equals("yes")){
//                System.out.println("Starting new deposit.");
//            } else {
//                System.out.println("Incorrect input. Returning to main menu.");
//                isDonePaying = true;
//            }
//        }
//        System.out.println("Payments made made: ");
//        for (int i = 0; i < transactions.){
//            System.out.println("===================================================" +
//                    "\nTransaction date and time: " + payments.getDate() + " "+ payments.getTime() + "\nReason for deposit: " +
//                    payments.getDescription() + "\nVendor name: " + payments.getVendor() + "\nAmount deposited: " + "-" +payments.getAmount() + "\n===================================================");
//        }
//        return WriteAndReadCSV.csvWriter();
//    }

}
