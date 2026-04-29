package com.pluralsight.models;

public class Transaction {
    private String date;
    private String time;
    private String description;
    private String vendor;
    private double amount;

    public Transaction(String _date, String _time, String _description, String _vendor, double _amount) {
        this.date = _date;
        this.time = _time;
        this.description = _description;
        this.vendor = _vendor;
        this.amount = _amount;
    }

    @Override
    public String toString() {
        return getDate()+ "|"+ getTime() + "|" + getDescription() + "|" + getVendor() + "|" +getAmount();
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }


    public String getVendor() {
        return vendor;
    }


    public double getAmount() {
        return amount;
    }

}
