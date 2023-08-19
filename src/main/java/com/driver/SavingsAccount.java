package com.driver;

public class SavingsAccount extends BankAccount {
    private double rate;
    private double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        super(name, balance, 0); // Minimum balance required for savings account is 0 by default
        this.rate = rate;
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    @Override
    public void withdraw(double amount) throws Exception {
        if (amount > maxWithdrawalLimit) {
            throw new Exception("Maximum Withdraw Limit Exceed");
        }
        if (amount > getBalance()) {
            throw new Exception("Insufficient Balance");
        }
        setBalance(getBalance()-amount);

    }

    public double getSimpleInterest(int years) {
        // Return the final amount considering that bank gives simple interest on the current amount
        double simpleInterest = getBalance() * (1 + years * rate);
        return simpleInterest;
    }

    public double getCompoundInterest(int times, int years) {
        // Return the final amount considering that bank gives compound interest on the current amount given times per year
        double compoundInterest = getBalance() * Math.pow(1 + rate / times, times * years);
        return compoundInterest;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public void setMaxWithdrawalLimit(double maxWithdrawalLimit) {
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }
}