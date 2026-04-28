package com.pluralsight;


import com.pluralsight.ui.HomeScreen;
import com.pluralsight.utils.WriteAndReadCSV;


import java.io.IOException;

public class App {
     static void main(String[] args) throws IOException {
         WriteAndReadCSV mainTransactionReference = new WriteAndReadCSV();
         WriteAndReadCSV.csvReader();
         HomeScreen.greetingMessage();
         HomeScreen.homeScreenUI(mainTransactionReference);

    }
}
