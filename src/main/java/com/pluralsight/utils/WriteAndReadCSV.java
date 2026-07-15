package com.pluralsight.utils;

import com.pluralsight.models.Transaction;

import java.io.*;
import java.util.ArrayList;

public class WriteAndReadCSV {
    // array created to store transactions; encapsulation to avoid array being manipulated in areas not permitted to be
    private static ArrayList<Transaction> transactions = new ArrayList<>();
    private static final String DIRECTORY_PATH = "src/main/java/data/transactionRecords";
    private static final String FILE_NAME = "transactions.csv";

    public static void csvWriter(Transaction transactions) {

        try {

            File folder = new File(DIRECTORY_PATH);

            if (!folder.exists()) { // enters if statement if directory doesnt exist

                System.out.println("Missing directories: " + folder.getName()); // informs user of what directory is missing
                if (!folder.mkdirs()) {
                    System.out.println("Failed to create directories");
                    return; // if directors fail to be created exists csv logic
                }
                System.out.println("Directories created");
            }

            File file = new File(folder, FILE_NAME); // creates missing csv file

            boolean newFile = !file.exists();

            String writeTransactions = transactions.toString();

            String[] parts = writeTransactions.split("\\|");
            if (parts.length != 5) { // created to skip invalidly formatted transactions
                System.out.println("Invalid format, skipping.");
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));

            if (newFile) {
                System.out.println("Missing CSV file");
                writer.append("date|time|description|vendor|amount");
                writer.newLine();
                System.out.println("CSV file created");
            }
            writer.append(writeTransactions); // appends new transaction to existing csv file
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: Unable to write to CSV file.");
        }
    }
    public static void csvReader() {
        try {
            //tracks records already loaded so the same transaction is never added twice
            ArrayList<String> seenTransactions = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader("src/main/java/data/transactionRecords/transactions.csv"));
            String line;
            reader.readLine(); // allows reader to skip first line that shows the file formatting
            while ((line = reader.readLine()) != null) {

                String[] parts = line.split("\\|");
                if (parts.length == 5) {
                    String dateOfTransaction = parts[0].trim();
                    String timeOfTransaction = parts[1].trim();
                    String descriptionOfTransaction = parts[2].trim();
                    String vendorOfTransaction = parts[3].trim();
                    double amountOfTransaction = Double.parseDouble(parts[4].trim());

                    //builds a key from the parsed values; using the parsed amount normalizes 2500.00 and 2500.0 to the same value
                    String transactionKey = dateOfTransaction + "|" + timeOfTransaction + "|" + descriptionOfTransaction + "|" + vendorOfTransaction + "|" + amountOfTransaction;
                    if (seenTransactions.contains(transactionKey)) {
                        continue; //skips a record we have already loaded, preventing duplicates in memory
                    }
                    seenTransactions.add(transactionKey);

                    transactions.add(new Transaction(dateOfTransaction, timeOfTransaction, descriptionOfTransaction, vendorOfTransaction, amountOfTransaction));
                    //reads csv file and adds transactions into array to be accessed elsewhere
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error: Unable to read CSV file");
        }
    }
    public static ArrayList<Transaction> getTransactions(){
        return transactions;
    }
}