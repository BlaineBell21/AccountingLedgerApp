package com.pluralsight;

import com.pluralsight.ui.HomeScreen;
import com.pluralsight.utils.WriteAndReadCSV;
import java.io.IOException;

public class App {
     static void main(String[] args) throws IOException {
         WriteAndReadCSV mainTransactionReference = new WriteAndReadCSV(); //initializes a main reference to use between classes, avoiding duplicates
         WriteAndReadCSV.csvReader(); //initial loading of csv entries

         HomeScreen.greetingMessage(); //displays app greeting message
         HomeScreen.homeScreenUI(mainTransactionReference); //puts user into main homescreen loop
    }
}
