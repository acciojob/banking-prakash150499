package com.driver;

public class StudentAccount extends BankAccount {

    private String institutionName;

    public StudentAccount(String name, double balance, String institutionName) {
        super(name, balance, 0); // Minimum balance required for student account is 0 by default
        this.institutionName = institutionName;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }
}
