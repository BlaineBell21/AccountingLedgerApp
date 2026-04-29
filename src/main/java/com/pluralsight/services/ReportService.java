package com.pluralsight.services;

import com.pluralsight.models.Transaction;
import com.pluralsight.ui.LedgerScreen;
import com.pluralsight.ui.ReportScreen;
import com.pluralsight.utils.InputHelper;
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
            LocalDate previousMonth = today.minusMonths(1); //sets previous month to = current (today) month - 1 (month)

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

    public static void customFilterUI(){
        System.out.println("\n════════════════════════════════════════════");
        System.out.println("        ⚒️ CUSTOM FORGE FILTER ⚒️");
        System.out.println("════════════════════════════════════════════");
        System.out.println("Refine your ledger search with:");
        System.out.println(" [1] Start Date");
        System.out.println(" [2] End Date");
        System.out.println(" [3] Description");
        System.out.println(" [4] Amount Range");
        System.out.println(" [5] Vendor");
        System.out.println("════════════════════════════════════════════");
        System.out.print("Choose a filter to forge: ");
    }
    public static void customFilterOptions(WriteAndReadCSV transactions) throws IOException {
        //method to prompt user for their custom filter options
        boolean isDoneFiltering = false;
        String startDate = null;
        String endDate = null;
        String description = null;
        String vendor = null;
        double minAmount =0;
        double maxAmount = 0;

        while (!isDoneFiltering){
            customFilterUI(); //shows custom filter CLI
            String chosenFilter = InputHelper.promptString();
            if(chosenFilter.equals("1")){ //filter by start date
                System.out.println("Enter the earliest transaction date to forge from [yyyy-MM-dd]: ");
                startDate = InputHelper.promptString();

            }
            if(chosenFilter.equals("2")){ //filter by end date
                System.out.println("Enter the final transaction date in your search range [yyyy-MM-dd]: ");
                endDate = InputHelper.promptString();
            }
            if(chosenFilter.equals("3")){ //filter by transaction description
                System.out.println("Enter the transaction description to search for: ");
                String descriptionInput = InputHelper.promptString();
                description = descriptionInput.toLowerCase().trim(); //allows user to ignore casing and trims extra space
            }
            if(chosenFilter.equals("4")){
                System.out.println("Enter minimum transaction amount: ");
                minAmount = InputHelper.promptDouble(); //filter by minimum

                System.out.println("Enter maximum transaction amount: ");
                maxAmount = InputHelper.promptDouble(); //filter by maximum amount
            }
            if(chosenFilter.equals("5")){ //filter by vendor name
                System.out.println("Enter the merchant/vendor name: ");
                String vendorInput = InputHelper.promptString();
                vendor = vendorInput.toLowerCase().trim();
            }
            boolean isDoneChoosing = false;

            while(!isDoneChoosing){
                System.out.println("Continue adding filters? (yes/no): ");
                String userChoice = InputHelper.promptString(); //lets user choose whether or not to continue adding filters
                if (userChoice.equals("yes")){ //if yes, breaks out of current while loop to loop through options again
                    System.out.println("Filter added. Heating the forge for another refinement...");
                    break;
                }else if (userChoice.equals("no")){ //if no, exits out of filter loop and continues to next method
                    isDoneChoosing = true;
                    isDoneFiltering = true;
                }else{
                    System.out.println("Filters complete. Searching the ledger archives...");
                }
            }
        }
        matchedTransaction(startDate, endDate, description, vendor, minAmount, maxAmount, transactions); //returns user choices to transaction matching method
    }
    public static void matchedTransaction(String startDate, String endDate, String description, String vendor, double minAmount, double maxAmount, WriteAndReadCSV transactions) throws IOException {
        //method to filter through transactions based on inputted filters
        ArrayList<Transaction> listOfTransactions = WriteAndReadCSV.getTransactions(); //calls main array list

        for(Transaction transaction : listOfTransactions) { //loops through transactions in array list
            LocalDate transactionDate = LocalDate.parse(transaction.getDate()); //parsing transaction date into LocalDate

            //if inputted starting date is null or transaction starting date is after is equal to or later than inputted starter date
            boolean matchStartDate = startDate == null || !transactionDate.isBefore(LocalDate.parse(startDate));

            //if inputted ending date is null or transaction ending date is after is equal to or later than inputted ending date
            boolean matchEndDate = endDate == null || !transactionDate.isAfter(LocalDate.parse(endDate));

            //if inputted description is null or transaction description is equal to inputted description
            //ignores casing and includes descriptions that include inputted word
            boolean matchDescription = (description == null
                                        || transaction.getDescription().toLowerCase().equals(description)
                                        || transaction.getDescription().contains(description));
            //if inputted vendor is null or transaction vendor is equal to inputted vendor
            //ignores casing and includes vendors that include inputted word
            boolean matchVendor = (vendor == null
                                    || transaction.getVendor().toLowerCase().equals(vendor)
                                    || transaction.getVendor().contains(vendor));

            //if inputted min value is 0 or transaction min value is greater than or equal to min
            boolean matchMinAmount = minAmount == 0 || transaction.getAmount() >= minAmount;

            //if inputted max value is 0 or transaction max value is less than or equal to max
            boolean matchMaxAmount = maxAmount == 0 || transaction.getAmount() <= maxAmount;

            if(matchStartDate && matchEndDate && matchDescription && matchVendor && matchMinAmount && matchMaxAmount){
                //checks if all criteria are met

                System.out.println(transaction);//once all matches are found, prints out transactions
            }
        }
        LedgerScreen.transactionHistoryEnd();
        ReportScreen.ReportScreenUI(transactions); //returns to previous menu
    }
}
