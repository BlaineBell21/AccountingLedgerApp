package com.pluralsight.ui;

import com.pluralsight.services.ReportService;
import com.pluralsight.utils.InputHelper;
import com.pluralsight.utils.WriteAndReadCSV;

import java.io.IOException;

public class ReportScreen {
        public static void displayReportScreen(){
           System.out.println("\nSelect an action to continue forging: ");
            System.out.println("1) month to date");
            System.out.println("2) previous month");
            System.out.println("3) previous year");
            System.out.println("4) search by year");
            System.out.println("5) search by vendor");
            System.out.println("0) previous menu");
            System.out.print("Enter your choice: ");

        }
        public static void ReportScreenUI(WriteAndReadCSV transactions) throws IOException {
            //accesses all service features related to report service
            boolean isDoneForging = false;

            while(!isDoneForging){ //while false continues menu loop
                displayReportScreen();
                String userOption = InputHelper.promptString();
                switch(userOption.toUpperCase()){ //allows lower case or upper case input without erroring
                    case "1": //allows search for current month to current date
                        System.out.println("month to date");
                        isDoneForging = true;
                        ReportService.searchMonthToDate(transactions);
                        break;
                    case "2": //allows search for previous month current year
                        System.out.println("previous month");
                        isDoneForging = true;
                        ReportService.searchByPreviousMonth(transactions);
                        break;
                    case "3": //allows search for previous year current month
                        System.out.println("previous year");
                        isDoneForging = true;
                        ReportService.searchByPreviousYear(transactions);
                        break;
                    case "4": //allows search for current year to current date
                        System.out.println("year to date");
                        isDoneForging = true;
                        ReportService.searchByYearToDate(transactions);
                        break;
                    case "5": //allows search by vendor in alphabetical order
                        System.out.println("search by vendor");
                        isDoneForging = true;
                        ReportService.searchByVendor(transactions);
                        break;
                    case "0": //allows user to go back to previous menu
                        System.out.println("Returning to previous menu.");
                        isDoneForging = true;
                        HomeScreen.homeScreenUI(transactions);
                        break;
                    default://if incorrect in put, restarts while loop
                        System.out.println("Invalid option, try again.\n");
                }
            }
        }
}
