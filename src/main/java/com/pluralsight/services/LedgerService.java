package com.pluralsight.services;

import com.pluralsight.models.Transaction;
import com.pluralsight.ui.LedgerScreen;
import com.pluralsight.utils.WriteAndReadCSV;

import java.io.IOException;
import java.util.ArrayList;


public class LedgerService {
    public static void showAllTransactions(WriteAndReadCSV transactions) throws IOException {
        ArrayList<Transaction> listOfTransactions = WriteAndReadCSV.getTransactions();
        for (Transaction transaction : listOfTransactions){
            System.out.println(transaction);
        }
        LedgerScreen.LedgerScreenUI(transactions);
    }

    public static void showOnlyDeposits(WriteAndReadCSV transactions) throws IOException {
        ArrayList<Transaction> listOfTransactions = WriteAndReadCSV.getTransactions();
        for (Transaction transaction : listOfTransactions){
            if (transaction.getAmount() > 0){
                System.out.println(transaction);
            }
        }
        LedgerScreen.LedgerScreenUI(transactions);
    }

    public static void showOnlyPayments(WriteAndReadCSV transactions) throws IOException {
       ArrayList<Transaction> listOfTransactions = WriteAndReadCSV.getTransactions();

       for (Transaction transaction : listOfTransactions){
           if (transaction.getAmount() < 0){
               System.out.println(transaction);
           }
       }
        LedgerScreen.LedgerScreenUI(transactions);
    }
}
