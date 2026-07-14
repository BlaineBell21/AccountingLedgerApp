package com.pluralsight.utils;

import com.pluralsight.models.Transaction;

import java.io.*;
import java.util.ArrayList;

public class WriteAndReadCSV {
    //array created to store transactions; encapsulation to avoid array being manipulated in areas not permitted to be
    private static ArrayList<Transaction> transactions = new ArrayList<>();

    public static String csvWriter(Transaction transactions) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("src/transaction.csv",true));

            String writeTransactions = transactions.toString();
            String[] parts = writeTransactions.split("\\|");
            if (parts.length != 5){ //created to skip invalidly formatted transactions
                System.out.println("Invalid format, skipping.");
            } else{
                writer.newLine();
                writer.append(writeTransactions); //appends new transaction to existing csv file
            }
    writer.close();
    return null;
    }

    public static void overWriteCSV() throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/transaction.csv"));
        writer.write("date|time|description|vendor|amount");
        for (Transaction transaction : transactions)
        {
            writer.newLine();
            writer.write(transaction.toString());
        }
        writer.close();
    }

    public static void csvReader() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/transaction.csv"));
        String line;
        //tracks records already loaded so the same transaction is never added twice
        ArrayList<String> seenTransactions = new ArrayList<>();
        reader.readLine(); //allows reader to skip first line that shows the file formatting
        while((line = reader.readLine()) != null) {

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
    }
        public static ArrayList<Transaction> getTransactions() throws IOException { //getter to access private array
        return transactions;
        }
    }
