package com.pluralsight.services;

import com.pluralsight.models.Transaction;
import com.pluralsight.ui.LedgerScreen;
import com.pluralsight.utils.WriteAndReadCSV;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class LedgerService {
    public static void showAllTransactions(WriteAndReadCSV transactions) throws IOException {
        ArrayList<Transaction> listOfTransactions = WriteAndReadCSV.getTransactions();

        Comparator<Transaction> amountComparator = new Comparator<Transaction>() {
            @Override
            public int compare(Transaction o1, Transaction o2) {
                if(o1.getAmount() > o2.getAmount()){
                    return -1;
                } else if (o1.getAmount() < o2.getAmount()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
        for (Transaction transaction : listOfTransactions){
            System.out.println(transaction);
        }
        LedgerScreen.transactionHistoryEnd();
        LedgerScreen.LedgerScreenUI(transactions);
    }

    public static void showOnlyDeposits(WriteAndReadCSV transactions) throws IOException {
        ArrayList<Transaction> listOfTransactions = WriteAndReadCSV.getTransactions();

        for (Transaction transaction : listOfTransactions){
            if (transaction.getAmount() > 0){
                System.out.println(transaction);
            }
        }
        LedgerScreen.transactionHistoryEnd();
        LedgerScreen.LedgerScreenUI(transactions);
    }

    public static void showOnlyPayments(WriteAndReadCSV transactions) throws IOException {
       ArrayList<Transaction> listOfTransactions = WriteAndReadCSV.getTransactions();

       for (Transaction transaction : listOfTransactions){
           if (transaction.getAmount() < 0){
               System.out.println(transaction);
           }
       }
       LedgerScreen.transactionHistoryEnd();
        LedgerScreen.LedgerScreenUI(transactions);
    }
}
