package com.driver;

public class BankAccount {

    private String name;
    private double balance;

    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;

    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        if (digits <= 0 || sum < 0 || sum > digits * 9) {
            throw new Exception("Account Number can not be generated");
        }

        int[] accountDigits = new int[digits];
        int remainingSum = sum;

        // Generate digits for account number
        for (int i = digits - 1; i > 0; i--) {
            int maxDigit = Math.min(remainingSum, 9);
            int digit = (int) (Math.random() * (maxDigit + 1));
            accountDigits[i] = digit;
            remainingSum -= digit;
        }
        accountDigits[0] = remainingSum;

        // Construct account number as a string
        StringBuilder accountNumber = new StringBuilder();
        for (int digit : accountDigits) {
            accountNumber.append(digit);
        }

        return accountNumber.toString();
    }

    public void deposit(double amount) {
        //add amount to balance
        balance += amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if (balance - amount < minBalance) {
            throw new Exception("Insufficient Balance");
        }
        balance -= amount;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

}