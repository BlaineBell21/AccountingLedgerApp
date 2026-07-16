package com.pluralsight.ui;

import com.pluralsight.services.ReportService;
import com.pluralsight.utils.InputHelper;
import com.pluralsight.utils.SoundUtils;
import com.pluralsight.utils.WriteAndReadCSV;

import java.io.IOException;

public class ReportScreen {
    public static void displayReportScreen(){
        System.out.println("\n════════════════════════════════════════════");
        System.out.println("        📊 FORGE REPORTS CENTER 📊");
        System.out.println("════════════════════════════════════════════");
        System.out.println(" [1] Month to Date");
        System.out.println(" [2] Previous Month");
        System.out.println(" [3] Previous Year");
        System.out.println(" [4] Year to Date");
        System.out.println(" [5] Search by Vendor");
        System.out.println(" [6] Custom Filter");
        System.out.println(" [0] Return to Ledger");
        System.out.println("════════════════════════════════════════════");
        System.out.print("Select a report to forge: ");
    }
    public static void ReportScreenUI(WriteAndReadCSV transactions) throws IOException {
        //accesses all service features related to report service
        boolean isDoneForging = false;

        while(!isDoneForging){ //while false continues menu loop
            displayReportScreen();
            String userOption = InputHelper.promptString();
            switch(userOption.trim().toUpperCase()){ //allows lower case or upper case input without erroring
                case "1": //allows search for current month to current date
                    SoundUtils.playMenuClick();
                    System.out.println("Forging month-to-date report...");
                    isDoneForging = true;
                    ReportService.searchMonthToDate(transactions);
                    break;
                case "2": //allows search for previous month current year
                    SoundUtils.playMenuClick();
                    System.out.println("previous month");
                    isDoneForging = true;
                    ReportService.searchByPreviousMonth(transactions);
                    break;
                case "3": //allows search for previous year current month
                    SoundUtils.playMenuClick();
                    System.out.println("previous year");
                    isDoneForging = true;
                    ReportService.searchByPreviousYear(transactions);
                    break;
                case "4": //allows search for current year to current date
                    SoundUtils.playMenuClick();
                    System.out.println("year to date");
                    isDoneForging = true;
                    ReportService.searchByYearToDate(transactions);
                    break;
                case "5": //allows search by vendor in alphabetical order
                    SoundUtils.playMenuClick();
                    System.out.println("Searching vendor records...");
                    isDoneForging = true;
                    ReportService.searchByVendor(transactions);
                    break;
                case "6":
                    SoundUtils.playMenuClick();
                    System.out.println("custom filter");
                    isDoneForging = true;
                    ReportService.customFilterOptions(transactions);
                    break;
                case "0": //allows user to go back to previous menu
                    SoundUtils.playMenuClick();
                    System.out.println("Returning to previous menu.");
                    isDoneForging = true;
                    LedgerScreen.LedgerScreenUI(transactions);
                    break;
                default://if incorrect in put, restarts while loop
                    System.out.println("Invalid option, try again.\n");
            }
        }
    }
}
