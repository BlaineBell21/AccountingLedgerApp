package com.pluralsight;


import com.pluralsight.ui.HomeScreen;
import com.pluralsight.utils.WriteAndReadCSV;
import java.io.IOException;

public class App {
     static void main(String[] args) throws IOException {
         WriteAndReadCSV mainTransactionReference = new WriteAndReadCSV();
         //initializes a main reference to use between classes, avoiding duplicates
         WriteAndReadCSV.csvReader();//intial loading of csv entries
         HomeScreen.greetingMessage();
         HomeScreen.homeScreenUI(mainTransactionReference);
    }
}
