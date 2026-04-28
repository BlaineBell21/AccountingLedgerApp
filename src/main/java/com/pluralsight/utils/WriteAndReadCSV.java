package com.pluralsight.utils;

import com.pluralsight.models.Transaction;

import java.io.*;
import java.util.ArrayList;

public class WriteAndReadCSV {
    private static ArrayList<Transaction> transactions = new ArrayList<>();

    public static String csvWriter() throws IOException {

            BufferedWriter writer = new BufferedWriter(new FileWriter("src/transaction.csv", true));
            for (Transaction transaction : transactions) {
                String writeTransactions = transaction.toString();
                String[] parts = writeTransactions.split("\\|");
                if (parts.length != 5){
                    System.out.println("Invalid format, skipping.");
                } else{
                    writer.newLine();
                    writer.write(transaction.toString());
                }
            }
        writer.close();
        return null;
    }

    public static ArrayList<Transaction> csvReader() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/transaction.csv"));
        String line;
        reader.readLine(); //allows reader to skip first line that shows the file formatting
        while((line = reader.readLine()) != null) {

                String[] parts = line.split("\\|");
                if (parts.length == 5) {
                    String dateOfTransaction = parts[0].trim();
                    String timeOfTransaction = parts[1].trim();
                    String descriptionOfTransaction = parts[2].trim();
                    String vendorOfTransaction = parts[3].trim();
                    double amountOfTransaction = Double.parseDouble(parts[4].trim());
                   transactions.add(new Transaction(dateOfTransaction, timeOfTransaction, descriptionOfTransaction, vendorOfTransaction, amountOfTransaction));

                }
            }
        reader.close();
        return transactions;
        }
        public static void addNewTransactions(){

        }
        public static ArrayList<Transaction> getTransactions() throws IOException {
        return transactions;
        }
    }
