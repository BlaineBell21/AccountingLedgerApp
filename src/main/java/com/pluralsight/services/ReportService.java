package com.pluralsight.services;

/*
Handles all report-related filtering:
custom search (bonus)
 */

import com.pluralsight.models.Transaction;
import com.pluralsight.ui.LedgerScreen;
import com.pluralsight.ui.ReportScreen;
import com.pluralsight.utils.WriteAndReadCSV;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ReportService {
    public static void searchMonthToDate(WriteAndReadCSV transactions) throws IOException {
        ArrayList<Transaction> listOfTransactions = WriteAndReadCSV.getTransactions();

        for (Transaction transaction : listOfTransactions){
            LocalDate transactionDate = LocalDate.parse(transaction.getDate());
            LocalDate today = LocalDate.now();

            if (transactionDate.getMonth() == today.getMonth() && transactionDate.getYear() == today.getYear()){
                System.out.println(transaction);
            }
        }
        LedgerScreen.transactionHistoryEnd();
        ReportScreen.ReportScreenUI(transactions);
    }
    public static void searchByPreviousMonth(WriteAndReadCSV transactions) throws IOException {
        ArrayList<Transaction> listOfTransactions = WriteAndReadCSV.getTransactions();

        for (Transaction transaction : listOfTransactions){
            LocalDate transactionDate = LocalDate.parse(transaction.getDate());
            LocalDate today = LocalDate.now();

            LocalDate previousMonth = today.minusMonths(1);

            if (previousMonth.getMonth() == transactionDate.getMonth() && previousMonth.getYear() == transactionDate.getYear()){
                System.out.println(transaction);
            }
        }
        LedgerScreen.transactionHistoryEnd();
        ReportScreen.ReportScreenUI(transactions);
    }
    public static void searchByPreviousYear(WriteAndReadCSV transactions) throws IOException {
        ArrayList<Transaction> listOfTransactions = WriteAndReadCSV.getTransactions();

        for (Transaction transaction : listOfTransactions){
            LocalDate transactionDate = LocalDate.parse(transaction.getDate());
            LocalDate today = LocalDate.now();

            LocalDate previousYear = today.minusYears(1);

            if (previousYear.getYear() == transactionDate.getYear()){
                System.out.println(transaction);
            }
        }
        ReportScreen.ReportScreenUI(transactions);
    }
    public static void searchByYearToDate(WriteAndReadCSV transactions) throws IOException {
        ArrayList<Transaction> listOfTransactions = WriteAndReadCSV.getTransactions();

        for (Transaction transaction : listOfTransactions){
            LocalDate transactionDate = LocalDate.parse(transaction.getDate());
            LocalDate today = LocalDate.now();

            if (transactionDate.getYear() == today.getYear() && transactionDate.getMonth() == today.getMonth()){
                System.out.println(transaction);
            }
        }
        LedgerScreen.transactionHistoryEnd();
        ReportScreen.ReportScreenUI(transactions);
    }
    public static void searchByVendor(WriteAndReadCSV transactions) throws IOException {
        ArrayList<Transaction> listOfTransactions = WriteAndReadCSV.getTransactions();

        listOfTransactions.sort((o1, o2) -> o1.getVendor().compareTo(o2.getVendor()));

        for (Transaction transaction : listOfTransactions){
            System.out.println(transaction);
        }
        LedgerScreen.transactionHistoryEnd();
        ReportScreen.ReportScreenUI(transactions);
    }
}
