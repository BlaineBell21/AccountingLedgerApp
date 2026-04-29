# 🔥 Budget Forge

Budget Forge is a command-line Java application for tracking personal or business financial transactions. It allows users to record deposits and payments, store them in a CSV file, and generate financial reports based on date ranges or vendor searches.

The application is designed to simulate a simple ledger system where all transactions are persisted and can be reviewed at any time.

---

## 📌 Features

- Add deposits (income transactions)
- Make payments (expense transactions)
- View full transaction ledger
- Filter transactions:
    - Month to Date
    - Previous Month
    - Year to Date
    - Previous Year
- Search transactions by vendor
- Transactions are saved to a CSV file for persistence
- Automatic loading of past transactions on startup

---

## 🧱 Tech Stack

- Java
- File I/O (BufferedReader / BufferedWriter)
- ArrayList data structures
- Object-Oriented Programming (OOP)

---

## 📁 File Structure

- `models/` – Transaction object definition
- `services/` – Business logic (deposits, reports, ledger operations)
- `utils/` – CSV reader/writer and helper utilities
- `ui/` – CLI screens and user interaction flow

---

## ▶️ How to Run the Project

1. Clone the repository:
   ```bash
   git clone <https://github.com/BlaineBell21/AccountingLedgerApp.git>


2. Open the project in IntelliJ IDEA (or your preferred Java IDE)
3. Run the App class
4. Follow the CLI menu prompts to navigate the application

## 📄 CSV Format

All transactions are stored in:


Each transaction follows this format:


    date|time|description|vendor|amount

Example:


    2026-04-15|10:13:25|Office Supplies|Staples|-45.99


## 🧠 Key Learning Concepts

This project demonstrates:

- File reading and writing in Java
- Data persistence using CSV files
- ArrayList manipulation
- Filtering and sorting data
- Menu-driven CLI design
- Object-oriented programming principles

## 👨‍💻 Blaine Anthony Bell

Built as part of a capstone project in Year Up United's Learn To Code Academy(LTCA).

---

