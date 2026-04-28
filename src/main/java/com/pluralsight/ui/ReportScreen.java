package com.pluralsight.ui;

import com.pluralsight.services.ReportService;
import com.pluralsight.utils.InputHelper;
import java.io.IOException;

public class ReportScreen {
        public static void displayReportScreen(){
            //System.out.println("\nSelect an action to continue forging: ");
            System.out.println("report screen check");
            System.out.println("1) month to date");
            System.out.println("2) previous month");
            System.out.println("3) previous year");
            System.out.println("4) search by year");
            System.out.println("5) search by vendor");
            System.out.println("0) previous menu");
            System.out.print("Enter your choice: ");

        }
        public static void ReportScreenUI() throws IOException {
            boolean isDoneForging = false;

            while(!isDoneForging){
                displayReportScreen();
                String userOption = InputHelper.promptString();
                switch(userOption.toUpperCase()){ //allows user to enter in lower case or upper case letter without erroring
                    case "1":
                        System.out.println("month to date");
                        isDoneForging = true;
                        ReportService.searchMonthToDate();
                        break;
                    case "2":
                        System.out.println("previous month");
                        isDoneForging = true;
                        ReportService.searchByPreviousMonth();
                        break;
                    case "3":
                        System.out.println("previous year");
                        isDoneForging = true;
                        ReportService.searchByPreviousYear();
                        break;
                    case "4":
                        System.out.println("search by year"); //custom search
                        isDoneForging = true;
                        ReportService.searchByYearToDate();
                        break;
                    case "5":
                        System.out.println("search by vendor"); //custom search
                        isDoneForging = true;
                        ReportService.searchByVendor();
                        break;
                    case "0":
                        System.out.println(); //eats extra line
                        System.out.println("previous menu"); //allows user to go back to previous menu
                        isDoneForging = true;
                        break;
                    default:
                        System.out.println("Invalid option, try again.\n");
                }
            }
        }
}
