package com.pluralsight.services;

import com.pluralsight.models.Transaction;
import com.pluralsight.ui.LedgerScreen;
import com.pluralsight.ui.ReportScreen;
import com.pluralsight.utils.WriteAndReadCSV;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ReportService {
    public static void searchMonthToDate(WriteAndReadCSV transactions) throws IOException {
        ArrayList<Transaction> listOfTransactions = WriteAndReadCSV.getTransactions(); //accesses transaction repository holding all transactions

        for (Transaction transaction : listOfTransactions){
            LocalDate transactionDate = LocalDate.parse(transaction.getDate()); //gets transaction date
            LocalDate today = LocalDate.now(); //gets current, local date

            if (transactionDate.getMonth() == today.getMonth() && transactionDate.getYear() == today.getYear()){
                //checks if transaction month and year are the same as current month and year
                System.out.println(transaction);
            }
        }
        LedgerScreen.transactionHistoryEnd();
        ReportScreen.ReportScreenUI(transactions);
    }
    public static void searchByPreviousMonth(WriteAndReadCSV transactions) throws IOException {
        ArrayList<Transaction> listOfTransactions = WriteAndReadCSV.getTransactions();

        for (Transaction transaction : listOfTransactions){
            LocalDate transactionDate = LocalDate.parse(transaction.getDate()); //gets transaction date
            LocalDate today = LocalDate.now(); //gets current, local date
            LocalDate previousMonth = today.minusMonths(1); //sets previous month to = current (today) month - 1 (year)

            if (previousMonth.getMonth() == transactionDate.getMonth() && previousMonth.getYear() == transactionDate.getYear()){
                //checks if transaction previous month and transaction current year is the same as local previous month and local current year
                System.out.println(transaction);
            }
        }
        LedgerScreen.transactionHistoryEnd();
        ReportScreen.ReportScreenUI(transactions);
    }
    public static void searchByPreviousYear(WriteAndReadCSV transactions) throws IOException {
        ArrayList<Transaction> listOfTransactions = WriteAndReadCSV.getTransactions();

        for (Transaction transaction : listOfTransactions){
            LocalDate transactionDate = LocalDate.parse(transaction.getDate()); //gets transaction date
            LocalDate today = LocalDate.now(); //gets current, local date
            LocalDate previousYear = today.minusYears(1); //sets previous year to = current (today) year - 1 (year)

            if (previousYear.getYear() == transactionDate.getYear()){
                //searches if transaction previous year is same as local current year
                System.out.println(transaction);
            }
        }
        ReportScreen.ReportScreenUI(transactions);
    }
    public static void searchByYearToDate(WriteAndReadCSV transactions) throws IOException {
        ArrayList<Transaction> listOfTransactions = WriteAndReadCSV.getTransactions();

        for (Transaction transaction : listOfTransactions){
            LocalDate transactionDate = LocalDate.parse(transaction.getDate()); //gets transaction date
            LocalDate today = LocalDate.now(); //gets current, local date

            if (transactionDate.getYear() == today.getYear() && transactionDate.getMonth() == today.getMonth()){
                //searches all transactions of current year to current date
                System.out.println(transaction);
            }
        }
        LedgerScreen.transactionHistoryEnd();
        ReportScreen.ReportScreenUI(transactions);
    }
    public static void searchByVendor(WriteAndReadCSV transactions) throws IOException {
        ArrayList<Transaction> listOfTransactions = WriteAndReadCSV.getTransactions();
        //sorts vendors in alphabetical order
        listOfTransactions.sort((o1, o2) -> o1.getVendor().compareTo(o2.getVendor()));

        for (Transaction transaction : listOfTransactions){
            System.out.println(transaction);
        }
        LedgerScreen.transactionHistoryEnd();
        ReportScreen.ReportScreenUI(transactions);
    }

    public static void customFilterOptions(){

    }
}
