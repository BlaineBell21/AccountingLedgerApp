package com.pluralsight.services;

import com.pluralsight.models.Transaction;
import com.pluralsight.ui.LedgerScreen;
import com.pluralsight.utils.WriteAndReadCSV;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;


public class LedgerService {
    public static void showAllTransactions(WriteAndReadCSV transactions) throws IOException {
        ArrayList<Transaction> listOfTransactions = WriteAndReadCSV.getTransactions(); //accesses transaction repository holding all transactions

        listOfTransactions.sort(Comparator.comparing(Transaction::getAmount));

        for (Transaction transaction : listOfTransactions){ //loops through all transactions and prints them
            System.out.println(transaction);
        }
        LedgerScreen.transactionHistoryEnd();
        LedgerScreen.LedgerScreenUI(transactions); //returns to ledger screen
    }

    public static void showOnlyDeposits(WriteAndReadCSV transactions) throws IOException {
        ArrayList<Transaction> listOfTransactions = WriteAndReadCSV.getTransactions(); //accesses transaction repository holding all transactions

        for (Transaction transaction : listOfTransactions){ //checks for deposits (positive transactions)
            if (transaction.getAmount() > 0){
                System.out.println(transaction);
            }
        }
        LedgerScreen.transactionHistoryEnd();
        LedgerScreen.LedgerScreenUI(transactions); //returns to ledger screen
    }

    public static void showOnlyPayments(WriteAndReadCSV transactions) throws IOException {
       ArrayList<Transaction> listOfTransactions = WriteAndReadCSV.getTransactions(); //accesses transaction repository holding all transactions

       for (Transaction transaction : listOfTransactions){
           if (transaction.getAmount() < 0){ //checks for payments (negative transactions)
               System.out.println(transaction);
           }
       }
       LedgerScreen.transactionHistoryEnd();
       LedgerScreen.LedgerScreenUI(transactions); //returns to ledger screen
    }
}
